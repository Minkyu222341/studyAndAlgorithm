* 데이터를 삭제 할 때 기존에는 삭제할 게시물의 식별자를 받아서 조회 후 
* 조회한 데이터를 작성한 사람이 현재 로그인한 사람이 맞는지 확인 후 삭제를 하기 때문에
* 아래와같이 쿼리가 3번이 나갔다.

![image](https://user-images.githubusercontent.com/108817236/226785247-8ac19506-8239-45a8-b758-ab8b3cd8403e.png)

* 이런식으로 확인 후 삭제하는건 말도 안되게 비효율적이라고 생각이 들어 코드를 리팩토링 해보기로 하고 여러 방법을 시도해봤다.

```
int deleteFolderByIdAndMemberId(Long folderId, Long MemberId);
```
* JPA쿼리를 작성해서 조건이 맞아 삭제가 된다면 1 실패한다면 0을 반환하는 코드로 바꾼 후 실행해 보았다.

```
Hibernate: 
    select
        f1_0.id,
        f1_0.created_at,
        f1_0.member_id,
        f1_0.modified_at,
        f1_0.name 
    from
        folder f1_0 
    where
        f1_0.id=? 
        and f1_0.member_id=?
Hibernate: 
    delete 
    from
        folder 
    where
        id=?
```
* 결과는 바로 삭제 쿼리를 날리는 것이 아니라 한번 조회 후 조건이 맞는다면 삭제 쿼리를 날리는 상황.
* 더욱 개선의 여지가 보인다.


### @Modifying
* 일반적인 JPA쿼리에서는 지원하지 않고 네이티브 쿼리를 작성한 코드에만 적용이된다.
* 주로 벌크 연산과 같이 이용하며, JPA 엔티티의 라이프사이클을 무시하고 실행 되므로 영속성 컨텍스트 관리에 주의하여야 한다.
  * 영속성 컨텍스트를 무시하고 바로 쿼리를 실행하기 때문에 1차캐시와 DB의 싱크가 맞지않는 상황이 벌어질 수 있다. 

```
@Modifying
  @Query("DELETE FROM Folder f WHERE f.id = :folderId AND f.memberId = :memberId")
  int deleteFolderByIdAndMemberId(@Param("folderId") Long folderId, @Param("memberId") Long memberId);
```
* 코드를 변경 후 쿼리를 확인해보자

```
Hibernate: 
    delete 
    from
        folder 
    where
        id=? 
        and member_id=?
```
* 삭제를 실패하던 성공하던 결과값을 0,1로만 반환할 뿐 날아가는 쿼리는 같다. 
