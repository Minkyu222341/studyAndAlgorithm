* 프로젝트를 진행 중 MariaDB -> Postgresql로 데이터를 일부 이관해야 하는 상황이 발생했다.
* 구버전의 서비스에서 신버전으로 넘어가면서DB뿐 아니라 구성하고 있는 서비스로직 마저 전부 바뀌게 되어서
* 사실상 A서비스에서 새로운 B서비스로 넘어가는 수준이었다.

  
* 방식에 대해서는
  * Flyway같은 마이그레이션 툴
  * csv파일로 추출해서 INSERT
* 위 경우들을 고민했다.
   * Flyway같은 툴을 통해서 편하게 이관하는 방법이 있을까 해서 자료들을 찾아봤지만
   * 대부분 Local -> Prod의 싱크를 맞추는 처리였고
   * 현재의 상황과 같이 스키마와 서비스로직이 전혀 다른 이기종 데이터 마이그레이션에 대해서는 찾기가 힘들기도하고,
   * 중요한 데이터 이관 작업이었기에 완전히 이해하고 사용하기에는 일정상 무리가 있다고 판단하여 보류하였다.
 * 그래서 csv파일로 추출해서 (이관하려는 DB의 구조에 맞춰서 데이터를 조회 한 후 INSERT 하기위함) 삽입 하려고 생각을 하던 순간
 * 굳이 파일로 만들어야 하나 DB 2개를 연결해서 SELECT 한 후에 ISNERT를 하면 되지 않나라는 생각이 들어서
 * 하나의 애플리케이션에서 여러개의 DB를 연결하는 방법에 대해서 알아보았다.

<br><br>

## 프로젝트 패키지 구조

![멀티디비연결](https://github.com/Minkyu222341/studyAndAlgorithm/assets/108817236/1b50adbf-123b-4341-a0ce-d773cabe35c1)

* 우선 각 DB에서 연결될 Mapper와 Xml을 분리해줬다.

## 설정파일
```
  test:
    datasource:
      driver-class-name: net.sf.log4jdbc.sql.jdbcapi.DriverSpy
      jdbc-url: 
      username: 
      password: 

  prod:
    datasource:
      driver-class-name: org.mariadb.jdbc.Driver
      jdbc-url: 
      username: 
      password: 
```

* 연결할 DB에 대한 정보들을 위 같은 포맷으로 입력해준다. 
  * 주의할점은 url이 아니라 'jdbc-url'로 작성해야 인식한다는 것이다. 그냥 url로 작성시 인식하지 못한다.
 
## Config파일 설정
* 스프링의 Bean관리 기본 전략은 싱글톤 패턴을 사용하기 때문에 아무런 설정없이 실행을 하게 된다면
* 의존성 주입(Dependency Injection) 오류와 마주하게 될 것이다.
* 이를 방지하기 위해서 설정 클래스파일을 만들어서 순차적으로 커넥션을 할수 있도록 해줄것이다.
 
