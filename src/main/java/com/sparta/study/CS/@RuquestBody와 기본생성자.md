* 스프링 프로젝트를 진행하게되면, 컨트롤러를 통해 요청을 주고 받고 이 과정에서 DTO를 통해 데이터를 운반하게된다.
* 평소 DTO를 생성하면 @Getter와 @Noartsconstructor 어노테이션을 붙여 사용하곤 하는데,
* 더듬더듬 강의를 따라가던시절 어노테이션을 빼먹고 작동이 되지 않았던 기억이 있어 이유는 깊게 찾아보지 않고 습관처럼 굳어진 행동이다.
* 평소에는 그냥 넘겼을 부분이지만 최근에 기반지식이 많이 부족하다는걸 깨달았고 의문점이 생길때마다 기록하며 정리하려고한다.

<br><br>
### 우선 이유를 알아보기 전에 클라이언트로부터 요청이 들어오게되면 어떤 순서로 진행되는지 알고 넘어가자.

 ![image](https://user-images.githubusercontent.com/108817236/233076539-60286798-1376-4681-bed4-077bf93cccd5.png)
 
 <br>
 
* 사용자가 서버로 요청을 보내게 되면 위 사진과 같은 흐름으로 진행되고, 
*  Http요청을 분석해 필요한 데이터를 객체로 바인딩하여 
*  애플리케이션 단으로 전달하고 서비스로직을 실행하게 된다.

<br>

###  그렇다면 어느시점에 어떻게 어떤녀석이 바인딩을 수행하는것일까 ?

![image](https://user-images.githubusercontent.com/108817236/233079061-95295b9b-1d49-425d-9689-fbc42161a71d.png)
* DispatcherServlet이 호출한 __ArgumentResolver__ 라는 녀석이 사이에서 핸들러메소드의 파라미터의 속성을 파악해 객체를 생성한 후 
* HttpMessageConverter가 Http요청 본문의 Json데이터를 미디어 타입과 파라미터 타입이 일치한다면 바인딩을 수행하게된다.

* @RequestBody,@ResponseBody 요청이 들어오게되면 HandlerMethodArgumentResolver의 구현체인 RequestResponseBodyMethodProcessor가 동작하여 
* 객체를 생성하게 되는데 과정을 다시한번 정리해보자

1. POST 요청이 들어옴
2. 핸들러 어댑터가 요청을 처리할 핸들러 메소드를 찾음
3. 핸들러 메소드에 대한 정보를 분석하는 ArgumentResolver가 핸들러 메소드의 파라미터에 @RequestBody 어노테이션이 있는지 확인
4. @RequestBody 어노테이션이 있는 파라미터를 처리하기 위해 RequestResponseBodyMethodProcessor가 선택됨
5. RequestResponseBodyMethodProcessor가 요청 본문의 데이터를 읽어들여서 핸들러 메소드의 파라미터 타입에 맞게 변환함
6. 변환된 객체를 핸들러 메소드의 파라미터로 전달하여, 핸들러 메소드가 실행됨

![image](https://user-images.githubusercontent.com/108817236/233086283-c2d75ada-bfdc-4961-b3f4-fdecebdfa36e.png)

* 생성하는 부분을 살펴보면 기본생성자가 NULL이 아님을 확인 후 메소드를 호출하여 객체를 생성한다.
* 때문에 @RequestBody 요청에서 기본생성자가 존재하지 않았을 경우 예외가 발생했던 것이다.

---
https://blogshine.tistory.com/445



