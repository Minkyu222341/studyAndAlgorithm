* spring restdocs ?
  *  테스트코드 기반으로 API에 대한 문서를 자동화 해주는 도구이다.

* API 문서에 대하여 논할때 스웨거가 빠지지 않고 등장하는데 스웨거와 어떤 차별점을 가지고 있는지 알아보도록 하겠다.

### 스웨거(Swagger)
 * 애플리케이션 로직에 아래처럼 어노테이션등 코드가 직접적으로 침투하게 된다. -> 가독성이 매우 떨어진다. 
![image](https://github.com/Minkyu222341/studyAndAlgorithm/assets/108817236/6f2c17d1-0d2f-4516-a266-ef38db685a2b)

 * 테스트 코드 기반이 아니기에 제품 코드와 문서가 일치하지 않을 수가 있다. -> 문서에 대한 신뢰성이 떨어진다.

### 스프링 Restdocs
* 실제 서비스 코드에 영향을 주지 않는다.
* 테스트 코드 기반이기에 테스트가 통과 해야만 문서가 작성된다. -> 제품 코드 및 문서에 대한 신뢰도가 상승한다.

--- 
https://techblog.woowahan.com/2597/

https://velog.io/@kijrary/Spring-Boot-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8Gradle-%EC%97%90%EC%84%9C%EC%9D%98-Swagger-3.0.0-%EC%84%A4%EC%A0%95-%EB%B0%A9%EB%B2%95

https://backtony.github.io/spring/2021-10-15-spring-test-3/
