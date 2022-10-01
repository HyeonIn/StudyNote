## Servlet

### httpServlet

- 내부적으로 http 요청 방식에 대한 처리 메소드를 나누어 두었다
  - doGet, doPost 등등
- 추상 클래스이지만 의미상의 추상클래스로 실제 추상메소드가 없다
  - 원하는 메소드만 골라서 오버라이딩하여 사용한다
- URL 맵핑

- web.xml을 이용한 서블릿 url 맵핑
``` xml
<servlet>
  <servlet-name>서블렛 이름</servlet-name>
  <servlet-class>서블렛 파일 경로</servlet-class>
</servlet>

<servlet-mapping>
  <servlet-name>서블렛 이름</servlet-name>
  <url-pattern>서블렛 url 패턴</url-pattern>
</servlet-mapping>
```
servlet과 servlet-mapping안에 servlet-name값이 같아야 매핑이 된다.

- Annotation 방식을 이용한 서블릿 url 맵핑
``` java
@WebServlet("/경로")
public class HelloServlet extends HttpServlet{
  ...
}
```
web.xml을 이용한 매핑 방식이 너무 번거로워서 Annotation 기법이 생겼다
- 위 두 방식을 중복으로 사용하면 에러가 날 수 있다
  - 같은 pattern 값이 양 쪽에서 모두 정의된 경우

- web.xml 파일을 이용하면 에러에 대한 처리도 가능하다
```xml
<error-page>
  <error-code>404</error-code>
  <location>/error/404.html</location>
</error-page>
```
### Java Servlet

- 자바를 이용해서 웹 페이지를 동적으로 만들 수 있는 서버측 프로그램을 말한다
- 자바 서블릿은 웹 서버의 성능을 향상하기 위해 사용하는 자바 클래스의 일종
- JSP와 비슷한 점이 있지만 서블릿은 HTML이 안에 있는 자바 파일이고 JSP 파일은 HTML안에 JAVA코드가 있는 파일이라는 차이점이 있다

### 동작 흐름

- 데이터를 얻어냄
- 비즈니스 로직을 처리
- DB로직 처리
  - JDBC 필요
- 응답 페이지 생성

### 상속 구조

- Servlet(인터페이스) > GenericServlet(추상클래스) > HttpServlet(의미상 추상클래스) 순으로 상속
  - API 사용이 편리하기 위함

### Sevlete Life-Cycle

- Servlet class는 javaSE에서의 class와는 다르게 main method가 없다. 
  - 객체의 생성부터 사용의 주체가 사용자가 아닌 **Servlet Container**(WAS)에 있다.
- Client가 요청을 하게 되면 Servlet Container는 Servlet 객체를 생성(생성자)하고 초기화(init)하며 요청에 대한 처리(service)를 하게 된다. 또한 Servlet 객체가 필요 없게 되면 제거(destroy)하는 일까지 Container가 담당하게 된다.
  - 요약 : Constructor [처음 한 번만 실행] -> init() [처음 한 번만 실행] -> **service(), doGet(), doPost()** [클라이언트 요청시마다 반복 실행] -> destroy() [처음 한 번만 실행]

### Parameter 전송 방식

- 서버에 데이터가 넘어갈 때는 태그안에 name속성이 넘어간다.
- form 안에 action 속성 값은 요청을 보낼 서블릿 주소
- GET
  - 특징
    - 전송되는 데이터가 URL뒤에 Query String으로 전달.
    - 입력 값이 적은 경우나 데이터가 노출이 되도 문제가 없을 경우 사용
  - 장점
    - 간단한 데이터를 빠르게 전송
    - form tag 뿐만 아니라 직접 URL에 입력하여 전송 가능
  - 단점
    - 데이터 양에 제한이 있다
    - URL을 통해 전달할 수 있는 사이즈는 2KB로 제한된다
- POST
  - 특징
    - URL과 별도로 전송
    - HTTP header 뒤 body에 입력 스트림 데이터로 전달
  - 장점
    - 데이터의 제한이 없다
    - 최소한의 보안 유지 효과를 볼 수 있다
  - 단점
    - 전달 데이터의 양이 같을 경우 GET 방식보다 속도가 느리다
      - 전송 패킷을 body에 데이터로 구성해야 하므로

#### GET 방식 전달 예시
```
http://localhost/good.jsp?parameter1=value&parameter2=value2
url : "http://localhost/good.jsp"
Query String Begin : '?'
Query String Separator : '&'
Parameter Separator : '='
Parameter Name : 'parameter1', 'parameter2'
Parameter Value : 'value1', 'value2'
```
- URL 뒤에 ? 가 붙음
- ? 뒤 내용을 Query String이라 부름
- & 를 구분자로 사용
- &로 구분된 내용이 Parameter
- Parameter도 = 을 기준으로 구분됨
- = 으로 구분된 두 값 중 앞에 값이 Parameter Name, 뒤에 값이 Parameter Value

#### etc

- 데이터를 가져왔는데 한글이 깨질 때
  - POST 방식일 때는 내부적인 스트림을 이용하여 값을 전달 받기 때문에 데이터를 받을 때나 넘겨줄 때 인코딩 작업이 필요하다
  - GET 방식은 html 파일안에서 페이지 인코딩 설정을 해주면 안깨진다.
  - <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

### Servlet API

- Request
  - request.getParameter("파라미터 이름")
    - 들어온 요청에 대해서 파라미터 이름에 매핑된 값을 가져옴
  - request.setCharacterEncoding("인코딩 속성")
    - 들어온 요청에 대해 인코딩 속성을 지정해준다
- Response
  - response.setContentType("지정할 컨텐츠 타입")
    - 응답 메세지를 내용을 어떤 타입으로 보낼지 설정
  - response.getWriter()
    - 내용을 적는 writer 객체 생성