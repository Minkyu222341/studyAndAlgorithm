![image](https://github.com/Minkyu222341/studyAndAlgorithm/assets/108817236/aa84fefa-121d-4573-8376-a82bbcb62dcf)

* 위 사진은 기본적으로 스프링 시큐리티에서 로그인을 시도했을때 일어나는 과정이다.

* 여태까지 해왔던 프로젝트에서는 하나의 테이블에서만 사용자들의 데이터를 관리했기 때문에
* 프로바이더와 UserDetailsService의 구현체는 스프링에서 제공하는 디폴트 객체를 사용해왔다.
  * 스프링 시큐리티 6.x 버전으로 넘어오면서 AuthenticationManager 및 provider를 따로 설정파일에서 선언해주지 않아도
  * 디폴트 객체를 호출해서 진행이된다. <- 이 부분이 문제였다.
 

* 현재 내가 필요한건 2개이상의 provier와 UserDetailsService의 구현객체를 등록한 후 상황에 맞게 로그인 프로세스를 진행 하는 것이었다.
* 구글링을 해봐도 5.7 이전버전의 자료들이 대부분이라 Config파일을 여러개 만들어서 Order순서를 지정해주고 실행해봐도 돌아오는건 NPE.

* 이런 저런 삽질을 해보다가 AuthenticationManager부분을 커스텀해보기로 하였다.

* 결국에는 AuthenticationManager가 provider를 호출하고 provider가 UserDetatilsService의 구현체를 호출하여 사용자의 정보를 가져온 후
* 컨텍스트 홀더에 삽입하여 로그인 프로세스를 진행하는것이 아닌가.
* 그렇다면 현재 필요한 부분은 AuthenticationManager에서 원하는 provider를 호출하면 해결될 문제였다.

```
  @Override
  public UserDetails loadUserByUsername(String loginId) {
    UserDetails userDetails = examRepository.findByLoginId(loginId)
            .map(this::createUserDetails)
            .orElseThrow(() -> new UsernameNotFoundException("해당하는 유저를 찾을 수 없습니다."));
    return userDetails;
  }

@Override
  public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
    UserDetails userDetails = exam2Repository.findByLoginId(loginId)
            .map(this::createUserDetails)
            .orElseThrow(() -> new UsernameNotFoundException("해당하는 유저를 찾을 수 없습니다."));
    return userDetails;
  }
```
* 우선 UserDetatilsService의 구현체를 필요한 만큼 만들어준다.

```
@Service
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {
  private final ExamDetailServiceImpl examDetailService;
  private final PasswordEncoder passwordEncoder;
  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String username = authentication.getName();
    String password = authentication.getCredentials().toString();

    UserDetails userDetails = examDetailService.loadUserByUsername(username);

    // 비밀번호 검증
    if (!passwordEncoder.matches(password, userDetails.getPassword())) {
      throw new CustomException(ErrorCode.PASSWORD_MISMATCH);
    }

    // 인증 성공 시, UsernamePasswordAuthenticationToken을 반환합니다.
    return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
  }
}

@Service
@RequiredArgsConstructor
public class CustomExamAuthenticationProvider implements AuthenticationProvider {
  private final Exam2DetailsServiceImpl exam2DetailsService;
  private final PasswordEncoder passwordEncoder;
  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String username = authentication.getName();
    String password = authentication.getCredentials().toString();

    UserDetails userDetails = exam2DetailsService.loadUserByUsername(username);

    if (!passwordEncoder.matches(password, userDetails.getPassword())) {
      throw new BadCredentialsException(ErrorCode.PASSWORD_MISMATCH.getMsg());
    }

    // 인증 성공 시, UsernamePasswordAuthenticationToken을 반환합니다.
    return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
  }
}
```

* 후에 각각의 구현체를 호출해줄 프로바이더를 생성해준다.

```
 public AuthenticationManager getManager(String type) {
    if (type.equals("FLAG")) {
      return authentication -> examAuthenticationProvider.authenticate(authentication);
    } else {
      return authentication -> exam2AuthenticationProvider.authenticate(authentication);
    }
  }
```

* 최종적으로 AuthenticationManager를 상속받은 클래스에서 상황에 따라 프로바이더를 호출할 수 있도록 메서드를 선언해준다.

* 위의 방법이 맞는지는 모르겠으나 원하는 문제는 해결이 되었고 삽질을 하는 과정에서 시큐리티의 구조에 대해서 조금은 더 알게된것 같다.
