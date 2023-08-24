###  ResultMap이란?
* SQL의 실행 결과를 객체로 매핑하기 위해 사용되는 설정이다.
* 기본적으로 복잡한 매핑을 간편하게 할수 있도록 해주기위한 도구이다.

```
public class Person {
    private int id;
    private String name;
    private int age;
    private Address address;
    // Getter, Setter, Constructor 생략
}
public class Address {
    private String street;
    private String city;
    private String zipCode;
    // Getter, Setter, Constructor 생략
}
<!-- Person 객체의 ResultMap 정의 -->
<resultMap id="personResultMap" type="com.example.Person">
    <id property="id" column="person_id" />
    <result property="name" column="person_name" />
    <result property="age" column="person_age" />
    <association property="address" resultMap="addressResultMap" />
</resultMap>
<!-- Address 객체의 ResultMap 정의 -->
<resultMap id="addressResultMap" type="com.example.Address">
    <result property="street" column="address_street" />
    <result property="city" column="address_city" />
    <result property="zipCode" column="address_zip_code" />
</resultMap>
```

* 위의 코드처럼 객체와 객체를 매핑할때 직관적이고 편리하게 매핑을 할수 있도록 해주기도 하며
* 아래의 예제코드 처럼 1:N 관계에서 컬럼을 List의 형태로 매핑할 때 사용되기도 한다.
```
<!-- resultMap 정의 -->
<resultMap id="AuthorResultMap" type="com.example.Author">
  <id property="id" column="author_id" />
  <result property="name" column="author_name" />
  <result property="books" javaType="java.util.List" ofType="com.example.Book" resultMap="BookResultMap" />
</resultMap>
<resultMap id="BookResultMap" type="com.example.Book">
  <id property="id" column="book_id" />
  <result property="title" column="book_title" />
</resultMap>
<!-- SQL 매핑 -->
<select id="selectAuthorWithBooks" resultMap="AuthorResultMap">
  SELECT a.author_id, a.author_name, b.book_id, b.book_title
  FROM author a
  LEFT JOIN book b ON a.author_id = b.author_id
</select>
-------------------------------------------------------------------------------------------
{
  "id": 1,
  "name": "John Doe",
  "books": [
    {
      "id": 1,
      "title": "Book 1"
    },
    {
      "id": 2,
      "title": "Book 2"
    },
    {
      "id": 3,
      "title": "Book 3"
    }
  ]
}
```

### 문법 주의사항
* column으로 사용되는 부분의 key값은 부모 테이블에서 조회한 응답값을 따른다. 
  * 일반적으로 스네이크 케이스로 조회를 해도 Response로 매핑할 때 카멜케이스로 자동 매핑해주는 것과 달리 조회한 컬럼명 그대로 적용되니 as를 사용하여 컬럼명을 맞추도록 해야한다.
 
    
* 기준으로 잡을 'id'를 잘못 바인딩 한다면 정상적인 쿼리가 출력되고 결과가 정상적으로 나옴에도 불구하고
* 애플리케이션단 에서는 원하는 대로 데이터가 반환되지 않기 때문에 디버깅을 하기 쉽지않다. (본인 포함 동료가 실수하는 광경을 여러번 목격했다. 주의해서 사용하자.)
