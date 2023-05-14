* 데이터를 저장하고 수정할 때 시간을 기록 해야하는 때가 있다.
* Spring boot에서는  @LastModifiedDate 어노테이션을 활성화하여 자동으로 수정된 시간을 DB에 반영해준다.

* 하지만 @LastModifiedDate를 적용 했음에도 Update시 변경된 시간이 적용되지 않는다,,

* 이유를 찾아보니 @LastModifiedDate가 동작하는 원리는 변경감지를 통해서 일어난 시간을 체크해 DB에 업데이트 한다고 한다.
* 하지만 업데이트를 @Modifying를 사용해 1차캐시를 무시하고 바로 DB에 쿼리를 날리니 @LastModifiedDate가 체크하지 못한것이다.

#### 해결 
* 해결법이라고 할건 없지만 수정할 때 쿼리에 수정된 시간을 임의로 변경하도록 바꿨다.
