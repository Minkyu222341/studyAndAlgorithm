* 사전적 의미로 '테스트를 위해 만든 모형'을 의미하고, 
* 테스트를 위해 실제 객체와 비슷한 모의 객체를 만드는 것을 모킹(Mocking), 모킹한 객체를 메모리에서 얻어내는 과정을 목업(Mock-up)이라 한다.

#### Mock을 왜 사용하는가 ?
* 객체를 테스트 하려면 대상 객체가 있어야 하지만, 생성하는데 번거로운 객체가 있을 수도 있고 
* 다른 WAS나 다른 소프트웨어의 도움이 반드시 필요한 객체도 있을 수 있다. 
* 또한 복잡한 의존성을 가지고 있을 때, 모킹한 객체를 이용하면 의존성을 단절시킬 수 있어 쉽게 테스트할 수 있다.
* 
