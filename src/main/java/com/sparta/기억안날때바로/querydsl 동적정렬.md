* 프로젝트를 진행하는 도중 최신순, 인기순, 이름순으로 조건별로 조회해야 할 일이 생겼다.
* 물론 Service 단에서 들어온 입력값을 비교해서 쿼리를 다수 작성하게 된다면 해결할 수 있긴하다.
* 하지만 정렬조건이 계속 많아진다면 ? 
* 조건이 변화한다면 ?
* 계속해서 모든 코드를 변경해야한다. 이건아니다.
* 동적 정렬을 지원해주는 __OrderSpecifier__ 의 사용방법을 기록해 보겠다.


```
private OrderSpecifier[] createOrderSpecifier(OrderCondition orderCondition) {

    List<OrderSpecifier> orderSpecifiers = new ArrayList<>();

    if (Objects.isNull(orderCondition)) {
      orderSpecifiers.add(new OrderSpecifier(Order.DESC, board.id));
    } else if (orderCondition.equals(OrderCondition.POPULAR)) {
      orderSpecifiers.add(new OrderSpecifier(Order.ASC, JPAExpressions.select(recommendation.count())
              .from(recommendation)
              .where(recommendation.type.eq(RecommendationType.BOARD))));
    } else {
      orderSpecifiers.add(new OrderSpecifier(Order.DESC, board.id));
    }
    return orderSpecifiers.toArray(new OrderSpecifier[orderSpecifiers.size()]);
  }

```

* 위와 같은 방법으로 여러개의 조건을 받더라도 해당하는 값을 리턴 해줄수 있다.
* 조건이 추가 되거나 변경된다면 서비스코드는 변경할 필요 없이 조건을 담당하는 부분만 수정해 준다면 편리하게 변경이 가능하다.