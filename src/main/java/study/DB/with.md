### WITH 문법이란 ?
* WITH 문법은 공통 테이블 표현(Common Table Expression, CTE)을 만드는 데 사용되는 SQL 문법이다.
* CTE는 하나 이상의 쿼리 결과를 임시로 정의하여 쿼리를 더 간결하고 가독성 있게 만드는 데 도움을 준다.

### WITH 문법의 구조

```
WITH cte_name (column1, column2, ...) AS (
    SELECT column1, column2, ...
    FROM table_name
    WHERE conditions
)
SELECT ...
FROM cte_name;
```

* CTE를 사용하지 않는 일반적인 쿼리
```
SELECT department, MAX(salary) AS max_salary
FROM Employees
GROUP BY department;

```

* CTE를 사용하는 쿼리

```
  WITH MaxSalaryPerDepartment AS (
    SELECT department, MAX(salary) AS max_salary
    FROM Employees
    GROUP BY department
)
SELECT * FROM MaxSalaryPerDepartment;

```

* WITH 문법은 중첩하여 사용할 수도 있고, 복잡한 쿼리를 더욱 간결하고 이해하기 쉽게 작성하는 데 도움이 된다.
