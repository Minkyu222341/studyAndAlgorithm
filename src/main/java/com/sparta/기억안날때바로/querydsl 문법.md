<details>
  <summary>리스트의 조건 검색 - any()</summary>
<pre>
 exam.examSubList.any().examId.eq(condition.getId());
</pre>
</details>

<details>
  <summary>as - 별칭</summary>
<pre>
 ```
  QExam subQueryExam = new QExam("subQueryExam");  // 서브쿼리용 별칭
  <br>
  List<ExamTypeResponse> content = queryFactory
            .select(new QExamTypeResponse(
                    exam.examName,
                    JPAExpressions
                            .select(subQueryBoard.count())
                            .from(subQueryExam)
                            .where(subQueryExam.createdAt.after(LocalDateTime.now().minusDays(1)),
                                    subQueryExam.examName.eq(exam.examName)),
                    exam.countDistinct()
            ))
            .from(exam)
            .where(exam.deleted.eq(false))
            .groupBy(exam.examName)
            .orderBy(exam.examName.desc())
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetch();
 ```
</pre>
</details>
