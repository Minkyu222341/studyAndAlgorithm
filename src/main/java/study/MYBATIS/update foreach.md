* 프로젝트를 진행 하면서 리스트를 데이터로 요청 받아서 데이터를 수정해야 하는 일이 생겼다.

```
{
  "examIdList":[
      {
        "examId" : 1,
        "examUpdateData" : updateData1
      },
      {
        "examId" : 2,
        "examUpdateData" : updateData2
      },
      {
        "examId" : 3,
        "examUpdateData" : updateData3
      }
  ]
}
```

```
<update id="updateExamData" parameterType="java.util.List">
  <foreach collection="examIdList" item="exam">
    UPDATE exam_table
    SET exam_update_data = #{exam.examUpdateData}
    WHERE exam_id = #{exam.examId}
  </foreach>
</update>
```

* 위 와 같은 코드로 한번의 커넥션으로 3번의 업데이트 쿼리를 날려보려 했지만 
*  sql syntax error를 뱉으며 진행되지 않았고 이유를 찾아보니
*  DB커넥션 부분에 allowMultiQueries=true 옵션을 추가해주어야 한다고한다.
*  추가로 이 옵션은 mysql에만 있다고 한다.

* 또한 이 멀티쿼리옵션을 사용하려면 몇가지 주의사항이 있는데

1. 쿼리의 수가 길어지면 길어질수록 처리시간이 더욱 늘어날수가 있다.
2. 멀티쿼리를 날리는 방식은 보안상 위험할 수 있다. -> 하나의 쿼리에 여러 개의 SQL 문이 포함되어 있기 때문에 공격자가 SQL Injection 공격을 수행할 가능성이 높아진다.

* 따라서 무분별하게 사용하지 말고 처리해야할 쿼리의 양이 적을때 주의해서 사용해야 하겠다.
