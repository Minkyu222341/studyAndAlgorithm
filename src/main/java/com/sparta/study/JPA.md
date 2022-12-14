## JPA(Java Persistence API)란?
* 자바 진영의 ORM(Object relational mapping)
  * ORM 
    * 객체는 객체대로 설계하며 관계형 데이터베이스는 RDBMS대로 설계하고 ORM프레임워크가 중간에서 매핑을 해주는 개념.
    * DAO -> JPA -> JDBC API -> DB와 같은 과정을 거침.
    * 즉슨 자바코드를 SQL문으로 매핑해주는 개념.
* JPA를 구현한 구현체는 Hibernate를 주로 사용함.  

### JPA의 장점
* SQL 중심적이 아닌 개발이 가능해짐.
  * SQL중심적인 개발이 이루어진다면 반복적인 CRUD 작업이 이루어져야한다.
  * 하나의 테이블을 생성해야 할 때 이에 해당하는 쿼리를 모두 만들어야 하며, 추후에 컬럼이 생성돠면 관련 SQL을 모두 수정해야하는 번거로움이 있다.

* 생산성이 증가한다.
  * 쿼리를 직접 생성하지 않고, 만들어진 객체에 JPA 메소드를 활용하여 DB를 다루기 때문에 개발자에게 편의성을 제공한다.

* 유지보수가 용이하다.
  * 쿼리의 수정이 필요 할 때 이를 담아야 할 DTO필드도 모두 변경 해야 하지만 JPA는 엔티티 클래스 정보만 변경하면 된다.
  * 추가로 다른 DB로 이관 할 때도 쿼리를 직접 작성하는 일이 없기 때문에 문법에따른 수정이 필요하지 않다.

* 성능 증가
  * 사람이 직접 SQL을 짜는것과 비교하여 JPA는 동일한 쿼리에대한 캐시기능(영속성)을 지원하기에 비교적 높은 성능을 가진다.


### 제약사항
* JPA는 복잡한 쿼리보다는 실시간 쿼리에 최적화 되어있다.
* 예를들어 통계처리와 같은 복잡한 작업이 필요한 경우 기존의 Mybatis와 같은 MApper방식이 효율적일 수 있다.
* 하지만 이를 보완하기 위한 Queryd과 같은 것도 있다. (나중에 따로 정리 후 링크추가)

