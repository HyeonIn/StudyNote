### Vue CLI(Command Line Interface)

##### 구조

- public
  - html파일 1개, js, css 파일들이 생성되어 만들어지는 최종 결과물 폴더
- src
  - 개발 중인 파일들
  - assets
    - 정적 img 등 미디어 파일
  - components
    - 조각이 되는 작은 컴포넌트
  - router
    - 화면 전환시 사용되는 컴포넌트 교체 설정
  - store
    - 데이터 상태 저장소(공용데이터) Vuex
  - views
    - components는 작은 조각인데 여기는 화면 단위의 페이지 같은 컴포넌트
  - App.vue, main.js
    - 사이트 전신(처음부터 끝까지 이 안에서 동작함)
