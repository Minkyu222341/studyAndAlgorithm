* Mysql 8.0.14 버전 부터 추가된 join 방법이다.
* 서브쿼리에서 사용시 일반 join과 다른 방식으로 동작하는데

* 일반적인 join은 join조건을 기준으로 테이블이 결합되는데 반해
* Lateral join은 외부 쿼리의 각 행에 대해 서브쿼리를 실행하고 결과를 반환한다.

<br>

#### 예를들어 아래와 같은 관계를 가진 테이블이 있다고 해보자.

| OrderID | OrderDate   | CustomerID |    
| ------- | ----------- | ---------- |
| 1       | 2023-05-01  | 101        |
| 2       | 2023-05-02  | 102        |

| OrderID | ProductID | Quantity |
| ------- | --------- | -------- |
| 1       | 201       | 2        |
| 1       | 202       | 3        |
| 2       | 203       | 1        |

```
SELECT *
FROM Orders
LEFT JOIN LATERAL (
  SELECT *
  FROM OrderDetails
  WHERE OrderDetails.OrderID = Orders.OrderID
  LIMIT 1
) AS Details ON true;

```
* 위 처럼 Lateral join을 사용하면 서브쿼리 내부에서 Orders에 대한 식별자를 참조할수 있게 된다.
* 따라서 다음과 같은 결과를 낼 수 있을 것이다.

OrderID | OrderDate  | CustomerID | OrderID | ProductID | Quantity
------- | ---------- | ---------- | ------- | --------- | --------
1       | 2023-05-01 | 101        | 1       | 201       | 2
2       | 2023-05-02 | 102        | 2       | 203       | 1

* 언뜻 편리해 보이지만 Lateral join은 외부 쿼리의 각 행마다 서브쿼리를 실행하므로 성능에 영향을 줄 수 있기에 필요한 부분에서만 주의해서 사용해야한다.
