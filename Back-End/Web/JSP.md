## JSP

### JSP(Java Server Page)

- HTML내에 자바 코드를 삽입하여 웹 서버에서 동적으로 웹 페이지를 생성하여 웹 브라우저에 돌려주는 언어이다
- Java EE 스펙 중 일부로 웹 어플리케이션 서버에서 동작한다
- 실행시에는 자바 서블릿으로 변환된 후 실행되므로 서블릿과 거의 유사하다고 볼수 있다
  - 하지만 서블릿과는 달리 HTML 표준에 따라 작성되므로 웹 디자인하기에 편리하다
- 인터프리터의 장점과 컴파일러의 장점을 모두 가지고 있다
- 서블릿에서 쓸 수 있는 문법은 전부 JSP 에서 쓸 수 있다, 완전 대체가 가능하지만 실제로 그렇게 만들지 않는다

### 동작 흐름

1. 클라이언트 요청이 들어오면
2. JSP파일을 서블릿 자바 파일로 변환
   - 최초의 JSP 요청 시, JSP 파일 변경 시
     - JSP가 서블릿으로 변경 됨
3. 로직 처리
4. 응답 페이지 생성
5. 응답 보내기

### Scriptlet

JSP 스크립팅 요소

- 선언(Declaration)
   - 멤버변수 선언이나 메소드를 선언 하는 영역
   - 형식
    ```<%! 멤버변수와 method 작성 %>```
   - 예시
        ```
        <%! 
            String name; 
            public void init(){ 
                name = "최현인"; 
            } 
        %>
        ```
- 스크립트릿(Scriptlet)
  - 클라이언트 요청 시 매번 호출 영역으로, Servlet으로 변환시 service() 메소드에 해당되는 영역
  - request, response에 관련된 코드 구현
  - 형식
    ```<% java code %>```
  - 예시
    ```
    <%
        for(int num = 1; num<10; num++){
            out.println(num);
        }
    %>
    ```
- 표현식(Expression)
  - 데이터를 브라우저에 출력할 때 사용
  - 형식
    ``` <%= 문자열 %> ```
  - 예시
    ```
    <h2>안녕 <%= name %> !!!</h2>
    ```
  - 주의
    - 문자열 뒤 세미콜론은 작성 X
      - out.print(name;); 이렇게 쓴 것이랑 똑같은 것
- 주석(Comment)
  - 코드 상에서 부가 설명을 작성
  - 형식
    ``` <%-- 주석할 코드 --%> ```
  - 클라이언트로 넘어갈 때 주석이 제거 되면서 넘어가서 HTML 주석과는 차이가 있음
  
### Directive
JSP 지시자 
- Page Directive
  - 컨테이너에게 현재 JSP 페이지를 어떻게 처리할 것인가에 대해 정보를 제공
  - 형식
    ```
    <%@ page attr1="val1" attr2="val2" ... %>
    ```
  - 주요 속성
    - contentType
      - 브라우저로 내보내는 내용의 MIME 형식 지정 및 문자 집합 지정
    - import
      - 현재 JSP 페이지에서 사용할 java 패키지나 클래스를 지정
    - isErrorPage
      - 현재 JSP 페이지가 에러 핸들링 하는 페이지인지 지정하는 요소
- Include Directive
  - 특정 JSP 파일을 페이지에 포함
  - 여러 JSP 페이지에서 반복적으로 사용되는 부분을 JSP file로 만든 후 반복 영역에 Include 시켜 반복되는 코드를 줄일 수 있다
  - 형식
    ```
    <%@ include file="/template/header.jsp" %>
    ```
- Taglib Directive
  - JSTL 또는 사용자에 의해서 만든 커스텀 태그를 이용할 때 사용되며 JSP 페이지 내에 불필요한 자바 코드를 줄일 수 있다.
  - 형식
    ```
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    ```

### 기본 객체

- request
  - HTML 폼 요소의 선택 값 등 사용자 입력 정보를 읽어올 때 사용
- response
  - 사용자 요청에 대한 응답을 처리하기 위해 사용
- pageContext
  - 각종 기본 객체를 얻거나 forward 및 include 기능을 활용할 때 사용
- session
  - 클라이언트에 대한 세션 정보를 처리하기 위해 사용, page directive의 session 속성을 false로 하면 내장 객체를 생성이 안됨
- application
  - 웹 서버의 어플리케이션 처리와 관련된 정보를 레퍼런스하기 위해 사용
- out
  - 사용자에게 전달하기 위한 output 스트림을 처리할 때 사용
- config
  - 현재 JSP에 대한 초기화 환경을 처리하기 위해 사용
- page
  - 현재 JSP페이지에 대한 참조 변수에 해당됨
- exception
  - Error를 처리하는 JSP에서 isErrorPage속성을 true로 설정하면 exception 내장 객체를 사용할 수 있고 기본은 false로 설정되어 있다. 전달된 오류정보를 담고 있는 내장 객체

### 기본 객체의 영역(Scope)
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
  - 하나의 웹 어플리케이션과 관련된 영역
  - 웹 어플리케이션당 1개의 어플리케이션 객체가 생성됨
  - 같은 웹 어플리케이션에서 요청되는 페이지들은 같은 어플리케이션 객체를 공유함


#### Scope 공통 메소드

##### setAttribute
```jsp
void setAttribute(String name, Object value)
```
- 문자열 name 이름으로 Object형 데이터를 저장한다. Object형이므로 어떠한 Java 객체도 저장이 가능하다.

##### getAttribute
```jsp
Object getAttribute(String name)
```
- 문자열 name에 해당하는 속성 값이 있다면 Object 형태로 가져오고 없으면 null을 리턴한다. 따라서 리턴 값에 대한 적절한 형 변환이 필요하다.

##### getAttributeNames
```
Enumeration getAttributeNames()
```
- 현재 객체의 저장된 속성들의 이름들을 Enumberation 형태로 가져온다
##### removeAttribute
```
void removeAttribute(String name)
```
- 문자열 name에 해당하는 속성을 삭제한다.

### Web Page 이동

||forward(request,response)|sendRedirect(location)|
|--|--|--|
|사용 방법|```request.getRequestDispatcher(path).forward(request, response);```|```response.sendRedirect(location);```|
|이동 범위|동일 서버(project)내 경로|동일 서버 포함 타 URL 가능|
|location bar|기존 URL 유지(실제 이동되는 주소 확인 불가)|이동하는 Page로 변경|
|객체|기존의 request와 response가 그대로 전달|기존의 request와 response가 소멸되고 새로운 request와 response가 생성|
|속도|비교적 빠름|forward()에 비해 느림|
|데이터 유지|request의 setAttribute(name, value)를 통해 전달|request로는 데이터 저장 불가능, 세션이나 쿠키를 이용|
