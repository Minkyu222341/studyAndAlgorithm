# Spring Framework
* 객체지향의 특징을 잘 활용 할 수 있도록 해주며 , 개발자들은 핵심 비즈니스 로직에만 집중 할 수 있도록 해주는 프레임워크.
# Spring Boot 
* Spring Framework를 편리하게 사용 할 수 있도록 해주는 도구이지Spring Framework 과 별도로 사용 할 수 있는 것이 아니다. 

# Spring boot를 사용하면 달라지는 점 
* 의존성관리 → 기존의 스프링은 개발자가 필요한 모듈의 의존성을 모두 다운받아야 했으며 모든 버전을 설정해주었어야 했지만 Spring boot는 Spring-boot- starter를 사용함으로써 관련된 의존성 조합을 자동으로 지원하며 권장버전으로 자동으로 설정해준다.

* 환경설정의 편리함 → xml로 하나하나 설정해주었어야 했으나(타임리프 사용시 view의 serfix prefix를 설정해주었어야함.) 의존성만 추가해주면 기본적인 설정은 자동으로 해주며 별도의 설정또한 [aplication.properties](http://aplication.properties/) or yml 에 추가적으로 설정해주면 편리하게 환경설정이 가능함.

* 내장 WAS 지원 → 기존에는 별도의 WAS가 필요했다 . 패키징 이후 WAS를 외부에 별도로 설치하고 빌드한 WAR파일을 올려주었어야했다.
Spring boot를 사용하면 내장 WAS를 지원하므로 Jar파일로 패키징하여 바로 사용이 가능하다 . ( 기본적으로 톰캣이지만 설정을 통해 jetty로도 변경이 가능하다.)
---
#정리 
* Spring은 Spring framework를 기반으로 여러 서브 프로젝트들의 모음으로 이루어져있으며, 서브 프로젝트들은 여러 모듈을 가지고있다.
* 개발할 애플리케이션에 맞게 모듈을 조합하여 사용한다.
* spring boot도 Spring 프로젝트중의 하나로 Spring framework와 별개로 사용이 불가능하며 , Spring을 편하게 사용하게 해주는 역할이다.
