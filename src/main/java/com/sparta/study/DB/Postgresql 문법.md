
#### IFNULL 
```
SELECT COALESCE(arg1, arg2) FROM TB;
```
* Mysql에서는 IFNULL이 익숙했지만, 문법이 다르다. -> null이 아니면 arg1을, null이면 arg2를 가져옴

<br>

#### count filter
```
select
      count(*) as ALL , count(*)  filter (where e.flag = true) as ONLYTRUE
from exam e;
```
* Postgresql에서는 각 count 별로 조건을 걸어서 여러건의 집계를 동시에 진행할 수 있다.
