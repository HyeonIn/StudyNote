## Servlet

### life-cycle
- 첫 요청이 들어올 때 객체를 생성
- 객체를 한 번만 만들어놓고 재사용
- 서버가 꺼질 때 객체를 삭제

## JSP
43p 외우기

### 문법
``` jsp
<%   %>     //스크립트릿 = 실행할 자바 문장(변수, 객체, 조건문, 반복문...)
            //결과가  html에는 나타나지 않음

<%=   %>    // 표현식  => 자바 변수나 객체에 있는 값을 결과 html에 보여주고 싶을때

<%@   %>    // 디렉티브 
                // page : 현재 jsp 페이지에 대한 정보 (import, isErrorPage)
                // taglib : jsp 태그 쓸 때
                // include : 다른 jsp 전체를 가져올 때

<%!   %>    // 선언문... 잘 안씀

<%--  --%>  // 주석 .. 잘 안씀
```
### Scope

- pageContext
  - 하나의 jsp페이지를 처리할 때 사용되는 영역. 한번의 클라이언트 요청에 대해 하나의 jsp 페이지가 호출되며, 이 때 단 한 개의 page 객체만 대응이 된다.
  - 페이지 영역에 저장한 값은 페이지를 벗어나면 사라진다
  - 커스텀 태그에서 새로운 변수를 추가할 때 사용한다.
- request
  - 하나의 HTTP 요청을 처리할 때 사용되는 영역
  - 웹 브라우저가 요청을 할 때마다 새로운 request 객체가 생성됨
  - request 영역에 저장한 속성은 그 요청에 대한 응답이 완료되면 사라진다
- session
  - 하나의 웹 브라우저와 관련된 영역
  - 같은 웹브라우저 내에서 요청되는 페이지들은 같은 session들을 공유하게 됨
- application
  - ~~

### Scope - 공통 메소드

setAttribute
```jsp
void setAttribute(String name, Object value)
```
- 문자열 name 이름으로 Object형 데이터를 저장한다. Object형이므로 어떠한 Java 객체도 저장이 가능하다.

getAttribute
```jsp
Object getAttribute(String name)
```
- 문자열 name에 해당하는 속성 값이 있다면 Object 형태로 가져오고 없으면 null을 리턴한다. 따라서 리턴 값에 대한 적절한 형 변환이 필요하다.
## MVC

### MVC(Model-View-Controller)

#### Model

#### View

#### Controller

	
김지환[대전_5반]
오후 5:05







1.서블릿 url 맵핑 방법, Web.xml url 매핑 V
2.HttpServlet 라이프 사이클 V
3.서블릿 관련 객체, 주요 메서드 V
(HttpServlet, GenericServlet, HttpServletRequest/Response, HttpSession, ServletContext), getAttribute(), setAttribute() ..
3.페이지 이동 관련 객체 및 메소드 V
4.클라이언트 요청방식, 서블릿에서의 처리방법, 에러 응답 코드 V

5.JSP 구성요소별 기능 및 사용법
6.JSP구문 EL로 변환하기, EL 연산자(empty)
7.JSTL tag들
8.Scope 관련 객체들
9.예외처리방법
10.쿠키 개념, 특징, 설정,전송
11.세션 개념, 특징, 객체 타입, 메소드
12.MVC 패턴 이해 및 각 역할의 이해
