## Servlet

### Java Servlet

- 자바 서블릿은 자바를 사용하여 웹페이지를 동적으로 생성하는 서버측 프로그램 혹은 그 사양을 말하며 흔히 "서블릿" 이라 불린다. 자바 서블릿은 웹 서버의 성능을 향상하기 위해 사용되는 자바 클래스의 일종이다. 서블릿은 JSP와 비슷한 점이 있지만 JSP가 HTML 문서 안에 Java 코드를 포함하고 있는 반면, 서블릿은 자바 코드안에 HTML을 포함하고 있다는 차이점이 있다.
  - 출처 : 위키백과

### Sevlete Life-Cycle

- Servlet class는 javaSE에서의 class와는 다르게 main method가 없다. 즉 객체의 생성부터 사용의 주체가 사용자가 아닌 Servlet Container에 있다.
- Client가 요청을 하게 되면 Servlet Container는 Servlet 객체를 생성하고 초기화 하며 요청에 대한 처리를 하게 된다. 또한 Servlet 객체가 필요 없게 되면 제거하는 일까지 Container가 담당하게 된다.