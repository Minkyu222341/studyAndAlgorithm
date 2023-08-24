# MVC
![mvc](https://user-images.githubusercontent.com/108817236/210118945-2be35c2c-5b2e-4256-9b80-736b15d8ecad.png)
* MVC 는 Model, View, Controller의 약자이며, 어플리케이션을 구성하는 요소를 역할에따라 3가지 모듈로 나누어 구분한 패턴이다.

### Model
* 어플리케이션의 데이터이며, 모든 데이터정보를 가공하여 가지고 있다.
* 사용자가 이용하려는 데이터를 가지고있어야 하며, View또는 Controller에 대해 어떠한 정보도 알 수 없어야 한다.
### View
* 디스플레이 데이터
* Model Data의 렌더링을 담당하면 HTML output을 생성
* Jsp,Thymeleaf,Freemarker 등 여러 템플릿 엔진이 이에 속한다.
### Controller(Handler)
* Model과 View를 연결해주는 역할을 한다.

# Spring MVC 구조
### DispatcherServlet(프론트 컨트롤러)
* FrontController 역할을 한다.
* 즉 가장 앞단에서 클라이언트의 요청을 처리하는 Controller로써 요청부터 응답까지 전반적인 처리과정을 통제한다.
* 
### Controller(handler)
* Handler는 DispatcherServlet이 전달해준 HTTP요청을 처리하고 그 결과를 Model에 저장한다.

### ModelAndView
* 말그대로 Controller에 의해 반환된 Model과 View가 들어있는 객체이다.

### ViewResolver
* ModelAndView를 처리하여 View를 그리는 역할을 한다.
* Model에 저장된 데이터를 이용해 View를 그리고 사용자는 렌더링된 화면을 보게된다.


# 실제 동작 구조
![image](https://user-images.githubusercontent.com/108817236/210103767-aa665050-fefc-4560-b838-33fe734dae1c.png)
* 1. 핸들러 조회
  * 핸들러 매핑을 통해 요청 URL에 매핑된 핸들러 조회

* 2. 핸들러 어댑터 조회
  * 조회한 핸들러를 실행 할 수 있는 어댑터를 조회한다.

* 3. 핸들러 어댑터 실행

* 4. ModelAndView 반환
  * 어댑터는 핸들러가 요청을 처리하고 반환하는 정보를 ModelAndView로 변환하여 반환한다.

* 5. ViewResolver 호출

* 6. ViewResolver 반환
  * ViewResolver는 View의 논리이름을 물리이름으로 바꾸고, 렌더링 역할을 담당하는 View 객체를 반환한다.

* 7. View렌더링
  * 사용자가 보는 화면을 그린다.

---
https://code-lab1.tistory.com/258

https://catsbi.oopy.io/f52511f3-1455-4a01-b8b7-f10875895d5b
