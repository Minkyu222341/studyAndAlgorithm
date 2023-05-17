* 수동으로 배포하는 작업은 항상 귀찮고 시간이 무의미하게 소모되는 과정이기 때문에 

* 리액트 프로젝트를 자동으로 서버에 업로드 하도록 GitHup Actions를 사용해 CI를 구축하기로 했다.

<br>

* 워크플로우를 실행하는 중 빌드가 되지않는 에러가 발생했는데

* 로컬에서는 문제없이 동작 하기에 이유를 찾는데 애를 먹었다.

<br>

```
Treating warnings as errors because process.env.CI = true.

Most CI servers set it automatically.

Failed to compile.
```
<br>

* 공통적으로 위의 문구가 출력되는걸 발견했고, 

* 빌드를 실행 할 때 출력되는 경고메시지들을 GIT에서는 에러라고 판단하여 동작을 중지한 것이다 라고 생각했다.


<br>

```
  - name: Set CI environment variable
        run: echo "CI=false" >> $GITHUB_ENV
```
* 하여 위의 스크립트를 추가해주니 

<br>

![image](https://github.com/Minkyu222341/studyAndAlgorithm/assets/108817236/2a2810eb-84d2-4847-84a7-a3f6611edabd)

<br>

* 정상적으로 동작한다 ..! 

* 지금의 해결방법으로는 단순히 경고 메시지를 무시 하도록 설정 했지만, 

* 근본적인 해결방법과 동작방식을 공부하게 된다면 다시 포스팅 하도록,,할,,예정,,이다
