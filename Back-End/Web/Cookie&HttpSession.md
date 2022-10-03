## Cookie&Session

### http 프로토콜의 특징
- 클라이언트가 서버에 요청
- 서버는 요청에 대한 처리를 한 후 클라이언트에 응답
- 응답 후 연결을 해제
  - 지속적인 연결로 인한 자원 낭비를 줄이기 위해 연결을 해제한다
  - 그러나 클라이언트와 서버가 연결 상태를 유지해야 하는 경우 문제가 발생(로그인 정보 등..)
  - 즉 클라이언트 단위로 상태 정보를 유지해야 하는 경우 쿠키와 세션이 사용된다

### Cookie

- 서버에서 사용자의 컴퓨터에 저장하는 정보파일
- 사용자가 별도의 요청을 하지 않아도 브라우저는 request시 Request Header를 넣어 자동으로 서버에 전송
- key와 value로 구성되고 String 형태로 이루어져 있음
- Browser 마다 저장되는 쿠키는 다르다

#### 사용목적

- 세션 관리
  - 사용자 아이디, 접속시간, 장바구니 등의 서버가 알아야할 정보 저장
- 개인화
  - 사용자마다 다르게 그 사람에 적절한 페이지를 보여줄 수 있다.
- 트래킹
  - 사용자의 행동과 패턴을 분석하고 기록

#### 사용 예

- ID 저장
- 일주일간 다시 보지 않기
- 최근 검색한 상품들을 광고에 추천
- 쇼핑몰 장바구니 기능

#### 구성요소

- 이름 : 여러 개의 쿠키가 클라이언트의 컴퓨터에 저장되므로 각 쿠키를 구별하는 데 사용되는 이름
- 값 : 쿠키의 이름과 매핑되는 값
- 유효기간 : 쿠키의 유효기간
- 도메인 : 쿠키를 전송할 도메인
- 경로 : 쿠키를 전송할 요청 경로

#### 동작 순서

- 클라이언트가 페이지를 요청
- WAS는 Cookie를 생성
- HTTP Header에 Cookie를 넣어 응답
- Browser는 넘겨받은 Cookie를 PC에 저장하고, 다시 WAS가 요청할 때 요청과 함께 Cookie를 전송
- Browser가 종료되어도 Cookie의 만료 기간이 남아 있다면 Client는 계속 보관
- 동일 사이트 재방문 시 Client의 PC에 해당 Cookie가 있는 경우, 요청 페이지와 함께 Cookie를 전송

#### 특징

- 이름, 값, 만료일, 경로 정보로 구성
- 클라이언트에 총 300개의 쿠키를 저장할 수 있다
- 하나의 도메인 당 20개의 쿠키를 가질 수 있다
- 하나의 쿠키는 4KB까지 저장 가능하다

#### 주요기능
- 생성
  ```java
  Cookie cookie = new Cookie(String name, String value);
  ```
- 값 변경/얻기
  ``` java
  // 변경
  cookie.setValue(String value);
  // 얻기
  String value = cookie.getValue();
  ```
- 사용자 도메인 지정/ 얻기
  ``` java
  // 도메인 지정
  cookie.setDomain(String domain);
  // 도메인 얻기
  String domain = cookie.getDomain();
  ```
- 사용자 도메인 지정/ 얻기
  ``` java
  // 도메인 지정
  cookie.setDomain(String domain);
  // 도메인 얻기
  String domain = cookie.getDomain();
  ```
- 값 범위 지정/ 얻기
  ``` java
  // 범위 지정
  cookie.setPath(String path);
  // 범위 얻기
  String path = cookie.getPath();
  ```
- 유효기간 지정/ 얻기
  ``` java
  // 유효기간 지정
  cookie.setMaxAge(int expiry);
  // 유효기간 얻기
  int expiry = cookie.getMaxAge();
  // cookie 삭제
  cookie.setMaxAge(0);
  ```
- 생성된 cookie를 클라이언트에 전송
  ``` java
  response.addCookie(cookie);
  ```
- 클라이언트에 저장된 cookie 얻기
  ``` java
  Cookie cookies[] = request.getCookies();
  ```

### Session

- 방문자가 웹 서버에 접속해 있는 상태를 하나의 단위로 보고 그것을 세션이라 한다
- WAS의 메모리에 Object 형태로 저장
- 메모리가 허용하는 용량까지 제한 없이 저장 가능

#### 사용 예

- 사이트 내에서 화면을 이동해도 로그인이 풀리지 않고 유지
- 장바구니

#### 동작 순서

- 클라이언트가 페이지를 요청
- 서버는 접근한 클라이언트의 request-header 필드인 쿠키를 확인하여, 클라이언트가 해당 session-id를 보냈는지 확인
- session-id가 존재하지 않는다면, 서버는 session-id를 생성해 클라이언트에게 돌려줌
- 서버에서 클라이언트로 돌려준 session-id를 쿠키를 사용해 서버에 저장.
- 클라이언트는 재 접속 시, 이 쿠키를 이용하여 session-id 값을 서버에 전달

#### 특징

- 웹 서버에 웹 컨테이너의 상태를 유지하기 위한 정보를 저장
- 웹 서버에 저장되는 쿠키(=세션 쿠키)
- 브라우저를 닫거나, 서버에서 세션을 삭제 했을 때만 삭제가 되므로, 쿠키보다 비교적 보안이 좋다
- 저장 데이터에 제한이 없다
- 각 클라이언트 고유 세션 아이디를 부여한다
- 세션 아이디로 클라이언트를 구분하여 각 클라이언트 요구에 맞는 서비스를 제공

#### 주요 기능

- 생성
  ```java
  HttpSession session = request.getSession();
  HttpSession session = request.getSession(false);
  ```
- 값 저장
  ``` java
  session.setAttribute(String name, Object value);
  ```
- 값 얻기
  ``` java
  Object obj = session.getAttribute(String name);
  ```
- 값 제거
  ``` java
  session.removeAttribute(String name); // 특정 이름의 속성제거
  session.invalidate(); // 바인딩 되어 있는 모든 속성 제거
  ```
- 생성 시간
  ``` java
  long ct = session.getCreationTime();
  ```
- 마지막 접근 시간
  ``` java
  long lat = sesson.getLastAccessedTime();
  ```

### Cookie& Session 정리

||Session|Cookie|
|--|--|--|
|Type|인터페이스|클래스|
|저장 위치|Server의 메모리에 오브젝트로 저장|클라이언트 컴퓨터에 파일로 저장|
|저장 형식|오브젝트는 모두 가능|파일에 저장되기 때문에 String 한정|
|사용 예|로그인 시 사용자 정보, 장바구니 등|최근 본 상품 목록, 아이디 저장(자동로그인), 오늘은 그만 보기 기능 등|
|용량 제한|제한 없음|도메인당 20개, 1쿠키 당 4KB|
|만료 시점|알 수 없음|쿠키 저장 시 설정(설정 안했을 경우 브라우저 종료 시 만료)|
- 공통점
  - 전역에 저장하기 때문에 프로젝트내의 모든 JSP에서 사용가능
  - Map 형식으로 관리하기 때문에 key값의 중복을 허용하지 않음
