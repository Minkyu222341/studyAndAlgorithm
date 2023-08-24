* Dto <-> Entity 혹은 Dto <-> Dto 간의 매핑을 자동화 시켜주는 도구

* build.gradle에 아래의 의존성 추가
```
 implementation 'org.mapstruct:mapstruct:1.4.2.Final'
 annotationProcessor 'org.mapstruct:mapstruct-processor:1.4.2.Final'
```

* Entity를 매핑할 Dto를 선언

```
@Getter
@Builder
public class ExamCustom {
  private long totalElements;
  private int totalPages;
  private int numberOfElements;
  private boolean first;
  private List<?> content;

}
```
* 실제로 매핑을 수행하는 @Mapper선언

```
@Mapper(componentModel = "spring")
public interface PageCustomMapper {
  PageCustomMapper INSTANCE = Mappers.getMapper(PageCustomMapper.class);

  PageCustom toPageCustom(Page<?> page) {
   }
 }
```

* 위처럼 인터페이스를 작성하고 애플리케이션을 실행하게되면 자동으로 구현체를 생성해서 매핑을 시도한다.
* 필드의 이름이 다를경우 자동으로 매핑되지 않으니 주의하도록 하자.
