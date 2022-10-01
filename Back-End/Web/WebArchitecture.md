## 웹 아키텍쳐

### 클라이언트

- 웹 브라우저
  - ML(HTML, XML)
  - CSS
  - JS
- data 발생
- http : hypertext transfer porotocol
  - 데이터를 전송하는 프로토콜
  - 데이터를 다루는 작업을 할 수는 없다

### 서버

- httpServer(웹 서버)
  - http 요청을 처리할 수 있는 서버
  - 언어를 해석하고 실행하는 능력이 없음
- 어플리케이션 서버
  - 언어(java(jsp/servlet), asp, php)를 해석할 수 있어서 디비와 연결할 수 있다.
- 클라이언트의 요청을 웹서버가 받고, 어플리케이션 서버가 디비와 연결 
- WAS (Web Application Server): 웹서버와 어플리케이션 서버의 역할을 모두 해줌
  - tomcat
    - 자바라는 언어를 웹 상에서 실행할 수 있게 해주는 서버이다
- 서버가 해야 하는 일
  - 클라이언트가 보낸 데이터를 얻어온다
    - http : GET/POST 방식의 요청
  - 로직을 처리한다
    - Business Logic : 페이징 등..
    - Persistence Login : DB 저장..
    - Presentation : 응답 페이지..
  - 응답 페이지를 만들어냄
    - HTML 요청이 들어오면 HTML 응답 페이지를 만들어줌

### 이클립스로 웹 프로젝트 만들기
- WAR : Web Archaive
- web.xml : WAR 파일을 톰캣이 알아서 압축을 풀고, 이후에 어떤식으로 돌아야하는지 적어두는 것
  - 웹 모듈  3.0 이전에는 web.xml을 꼭 만들어 줘야 했지만, 3.0 이상부터는 설정을 Annotation으로 대체함
- meta-data : 없어도 되지만 있으면 도움 되는 데이터들
- SQL connector 설정
  - maven 프로젝트를 만들어도 되고
  - jar 파일로 직접 build path에 추가해도 됨
- 데이터 베이스 연결은 클라이언트 요청이 올때마다 해줘야됨
  - 한번에 접속 가능한 클라이언트가 정해져있기 때문
  - 요청처리가 끝나면 연결을 끊어줘야 함