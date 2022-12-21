### MappedBy = 나는 ~에게 매핑이 되어있다.

**ex) List<Member> memberList는 Member.team에 의해 매핑이 되었다**

**즉 연관관계의 주인은 [Member.team]이다.**

값을 세팅 할 때 연관관계의 주인쪽에서만 적용이 되지만 객체지향적 설계 , 테스트 케이스 작성 등

을 고려 해봤을 때 양쪽에다 전부 값을 넣어줘야 한다.

만약 관계의 주인쪽에만 값을 넣어 주었을 경우 1차캐시가 flush 되지 않았을 때 

캐시의 값을 가져오기 때문에 문제가 생길 여지가 있다. 

ex) `comment.setArticle(article);`  , `article.getCommentList.add(comment);` 이런식으로 값을 초기화 시켜줘야 객체지향적인 설계가 되었다고 볼 수 있다.

추가적으로 이것을 한번에 처리하는걸 연관관계 편의메소드 라고 하는데 연관관계의 주인쪽에 값을 

초기화 시켜 줄 때 반대편의 값까지 같이 초기화 시켜준다.
ex) 

```jsx
Comment {
	public void addCommentToArticle(article){
	   this.article = article;
	   article.getCommentList.add(this);
	}
}
```

혹은

```jsx
Article{	
	public void addComment(Comment comment){
			comment.setArticle(this);
			commentList.add(comment);
	}
}
```

```jsx
Comment{
	public void setArticle(Article article){
			this.article = article;
	}
}
```

개인적으로 아래쪽이 직관적인 듯 하다.  

**양방향 관계정리**

설계를 할 때는 최대한 단방향으로 설계를 하되 필요에 의해서 양방향으로 수정하는 식으로 하는게 

좋다. 어차피 DB의 형태는 변하지 않으며 ENTITY코드만 몇줄 수정 될 뿐이다. 무작정 양방향으로 하

면 연관관계 편의 메소드라던지 고민거리가 늘어날 뿐이다.

**연관관계의 주인은 외래키의 위치를 기준으로**

### MappedBy 란

- MappedBy 란 객체의 양방향 연관관계를 맺을때 관계의 주인을 설정할때 사용하게 된다.
- 관계를 표현 하는데 있어 가장 중요한 개념은 외래키를 누가 가지고 있냐 이다.

Team 과 Member 객체가 1개의 팀은 여러 맴버를 가질수 있고 Member 는 1개의 팀에만 소속될 수 있는 비즈니스 로직이 있다고 가정하자.

```
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_temp_id")
    private Long id;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<MemberTemp> members = new ArrayList<>();
}

```

```
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_temp_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id")
    private Team team;
}
```

위 코드에서 Team 객체에서 PK 를 생성후 그 값을 Member 객체에 넘겨주어 Member 객체가 OwnerSide가 되며 연관관계의 주인이 된다.

Member를 연관관계의 주인을 설정하는 이유는 Team 객체에서 Id 한개를 Member 쪽으로 보냈을 경우 여러개의 Member 와 Team 이 조회 되지만 Member side 에서는 1개의 Id 로 특정 맴버와 팀 1개를 특정지을 수 있다.

 이런 의미에서 관계의 색깔을 더욱 명확하게 할 수있는 Member Side 에있는 team 이 연관관계의 주인으로 설정한는것이 바람직하다.

Member 테이블과 Team 테이블 그리고 Member_Team 테이블 총 3개를 생성한다.

위 코드에 연관관계의 주인이 설정되지 않았기 때문에 하이버네이트에서는 Team 과 Team-Member 단방향 연관관계 Member 와 Team-Member 단방향 연관관계가 맺어지게 되며

이럴 경우1번 맴버가 A 라는 팀에 소속되어 있다고 가정하고 Team-Member 테이블에서도 1번 멤버가 A라는 팀에 소속 되어있다고 가정해보자. 

이때 Member 테이블에서 1번 멤버의 팀을 B로 변경한다고 하면 Team-Member 의 테이블도 동일한 데이터로 업데이트를 쳐야하는일이 발생할 수 있다.

Team 테이블은 Team-Member 테이블을 조회하여 Team 과 Member 의 연관관계를 조회하는데 의존적이지만 Member 테이블은 Team-Member 테이블을 의존하지 않는다.

Member 테이블을 업데이트 할때 Team-Member 를 같이 업데이트 해주지 않으면 Team 테이블을 조회할때 데이터 정합성이 깨지게 된다.

```
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_temp_id")
    private Long id;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "team")
    List<MemberTemp> members = new ArrayList<>();
}
```

위 코드가 의미하는 바는 Member side 에 있는 team 이 연관관계의 주인이 되며 수정 삭제 생성 의 권한을 Member.team 이 갖게 하겠다는 의미이다.

Team 객체에서는 조회만 가능하며 Team.getMembers().add(member) 를 아무리 해도 수정 권한이 Team 쪽에 있는것이 아니기때문에 정상적으로 관계가 추가되지 않는다.

***하지만 Team 에 수정권한이 없다고 해서 add(member) 구문을 실행하지 말라는것은 아니다. Member 에 Team이 추가 됐다면 Member 에 연관관계를 맺어주는것은 필연 무조건 해야할 작업일것이며 Team 에도 add 를 해주어 같이 연관관계를 맺어주도록 하자.***

### 결론

- MappedBy 는 수정을 어디에서 할 것인가를 명시하는것과 동시 FK 를 어디에 가질것인지를 명시하는것이다.
- 양방향 관계에 있어 FK 를 갖는쪽이 연관관계의 주인이다.
- @ManyToOne 은 MappedBy 속성이 없다 이유는 매우 간단하다 @ManyToOne 은 양방향 관계일경우 항상 연관관계의 주인이된다

---

---

만약

 teamA.getMembers().add(memberA)과 

memberA.setTeam(teamB)가 호출된다면 어떻게 처리할 것인가.

teamA에 memberA를 넣되 memberB는 teamB다? 또는 Team에서 members의 team 값을 바꾸도록 한다?

jpa가 내린 규칙은 간단하다.

한쪽에서만 테이블의 외래키를 바꿀 수 있도록 하는 것이다. 그 관리자를 '연관관계의 주인' 이라고 정한다.

반면 객체의 연관 관계는 사실 두개의 단방향으로 이루어진다.

따라서 엔티티를 양방향 매핑으로 설정하면 객체의 참조는 둘인데 반해, 테이블은 하나의 외래 키 만을 사용하게 된다.

만약 teamA.getMembers().add(memberA)과 memberA.setTeam(teamB)가 호출된다면 어떻게 처리할 것인가.

teamA에 memberA를 넣되 memberB는 teamB다? 또는 Team에서 members의 team 값을 바꾸도록 한다?

jpa가 내린 규칙은 간단하다.

한쪽에서만 테이블의 외래키를 바꿀 수 있도록 하는 것이다. 그 관리자를 '연관관계의 주인' 이라고 정한다.

mappedBy는 어떤 객체가 주인인지를 표시하는 어노테이션 인 것이다.

mappedBy(team)이면, team을 갖고 있는 Member가 team(FK)의 주인이 되는 것이다.

### Owner

그럼 주인은 어떻게 정하는 게 좋을까. 김영한 강사님의 팁은 다음과 같다.

1. FK가 있는 곳을 주인으로 한다.

2. 객체의 개념에 따라서 Team의 members에도 member를 추가하고, member에도 team을 추가하는 식으로 양쪽 다 삽입하는 것도 실수를 줄이기 위한 방법이다.

3. 설계는 단방향으로 하되, 반대로 접근이 필요해진 곳에 양방향을 추가하는 식으로 코드를 작성한다.
