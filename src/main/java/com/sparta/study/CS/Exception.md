 ![image](https://user-images.githubusercontent.com/108817236/231750721-7c6331eb-e8c5-417c-a53b-618536bb226b.png)
* 예외의 종류는 크게 Error와 Exception으로 나뉘게 되며
* Exception은 예외를 반드시 체크해야 하는지의 여부에 따라 CheckedException과 UncheckedException으로 나뉜다.

### ERROR
* Error: Error는 프로그램 실행 중에 발생하는 예외 상황 중 치명적인 상황을 가리킨다.
* 예를 들어, OutOfMemoryError, StackOverflowError와 같이 복구가 불가능하고 프로그램의 비정상적인 종료를 초래하는 상황을 뜻한다.
* Error는 주로 시스템 레벨에서 발생하며, 개발자가 직접 처리할 수 없는 경우가 많다.

### Exception
* Error와 달리 애플리케이션 코드에서 예외가 발생하였을 경우에 사용된다.
* Exception 은 CheckedException과 UncheckedException 으로 구분할 수 있습니다.

#### CheckedException
* 반드시 처리해야 하는 예외 -> 해결하지 않을시 컴파일을 수행할 수 없다.
  * 보통의 경우 try/catch 블럭을 사용하여 예외를 처리한다.
* RuntimeException을 상속받지 않는다.
* Rollback이 적용되지 않으며 반드시 해당부분에서 예외를 잡아서 처리해줘야한다.

#### UncheckedException
* RuntimeException Class를 상속.
* Transaction으로 Rollback이 진행 됨.
* 반드시 처리를 해야만 애플리케이션이 동작하는 예외는 아니다. 
* 예외를 피할 수 있지만 개발자가 부주의해서 발생할 수 있는 경우를 위해 만든 예외이다. EX) IllegalArgumentException , NullPoinException ..

* 예외처리는 애플리케이션의 안정성을 위해서 반드시 처리해주어야한다.
* 꼼꼼하게 처리하지 않은 애플리케이션은 예외가 발생해서 해결을 하려고해도 빠르게 해결할 수 없으며 디버깅을 하는데도 하루종일 걸리게 될것이다.

#### BestCase
```
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable("userId") Long userId) {
        // UserService를 통해 사용자 정보를 조회하는 로직
        User user = userService.getUser(userId);
        if (user == null) {
            throw new UserNotFoundException("사용자를 찾을 수 없습니다."); // 커스텀 예외 발생
        }
        return user;
    }

    // 커스텀 예외 처리
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}

```
#### WorstCase
```
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable("userId") Long userId) {
        // UserService를 통해 사용자 정보를 조회하는 로직
        User user = userService.getUser(userId);
        if (user == null) {
            // 예외를 처리하지 않고 예외를 그대로 던짐
            throw new RuntimeException("사용자를 찾을 수 없습니다."); // 예외 미처리
        }
        return user;
    }
}
```
## 추가 SQLException 처리
* JdbcTemplate템플릿/콜백의 경우 코드레벨에서 복구할 수 없는 SQLException을 런타임 예외인 DataAccessException으로 포장해서 던져준다. 
* 그렇기에 필요한 경우 DataAccessException을 잡아 처리하면 되고 그렇지 않은 경우 무시해도 된다.

### 예외 전환
##### 이유
* catch/throws 를 최소화 하기 위하여
* 로우레벨의 예외를 좀 더 의미 있고 추상화된 예외로 바꿔서 던져주기 위하여
* 스프링의 JdbcTemplate가 던져주는 DataAccessException은 SQLException을 포장해서 던져주는 런타임 예외이다. 
* 그렇기에 애플리케이션에서 거의 복구가 불가능한 SQLException을 신경쓸 이유를 없애준다. 
* 하지만 이 뿐만 아니라 SQLException에 담긴 힘든 예외에 대한 상세한 정보를 의미 있고 일관성 있는 예외로 전환해서 추상화해주려는 용도로도 쓰인다.

```
try {
            couponAdminRepository.insertCoupon(request);
            if (memberType.equals(TARGET) || memberType.equals(GRADE)) {
                couponAdminRepository.insertCouponToTargetMember(request.getMemberTarget(), request.getCouponId());
            }
            if (!itemType.equals(ALL)) {
                couponAdminRepository.insertCouponTargetItem(request.getItemTarget(), request.getCouponId());
            }
        } catch (DataAccessException e) {
            if (e instanceof DuplicateKeyException) {
                throw new CustomException(DUPLICATE_ERROR);
            }
        }
```
* 해당 부분은 위의 자료를 참고해여 프로젝트를 진행하면서 DB레벨의 오류를 상세하게 응답하기 위하여 적용시켜본 사례이다.
