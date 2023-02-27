## DTO
![image](https://user-images.githubusercontent.com/108817236/208283372-1b3ccbc1-4be3-46a4-8db1-a9f9ae211b21.png)

* DTO는 (data transfer Object)로 계층간 데이터를 전달해주는 객체이다.
* setter와getter로 이루어져있고 데이터 접근 메소드 외에는 다른 기능을 가지지 않습니다.
* 데이터직렬화 정렬 등의 데이터 표현을 위한 기능들은 가질 수 있습니다.
* 데이터를 캡슐화 하여 원하는 데이터를 유연하게 뽑아서 사용이 가능하며 이는 데이터 요청 수 감소 효과를 불러 일으킵니다.

## VO (Value Object)
![image](https://user-images.githubusercontent.com/108817236/208283418-41700d02-6647-4aff-bb88-33e8ebe642a0.png)
* 위의 고유한 값은 모두 다르지만 우리는 모두 저것을 '5만원'이라고 부른다.
* 도메인에서 한 개 또는 그 이상의 속성들을 묶어서 특정 값을 나타내는 객체.
* 값 그 자체를 표현하는 객체이므로 무조건 불변이어야 한다.
* 자바 컴파일러는 기본적으로 인스턴스간 비교를 해시코드를 통해서 진행.
  * 때문에 VO는 자바 컴파일러가 인스턴스간 동등성 비교를 해시코드가 아닌 필드 값으로 하도록 유도하기 위해서 equals, hashCode 메서드를 필수로 구현.  
    * equals와 hashcode의 관계의 관해서는 후에 기술 후 추가예정.

## DTO vs VO
![DTOVSVO](https://user-images.githubusercontent.com/108817236/208283827-162eb51d-0a6c-4910-a3bc-b535fe82099d.png)


 
