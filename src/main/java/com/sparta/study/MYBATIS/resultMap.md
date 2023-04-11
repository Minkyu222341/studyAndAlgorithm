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

