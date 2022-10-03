## EL(Expression Language)

### EL

- EL은 표현을 위한 언어로 JSP 스크립트의 표현식을 대신하여 속성 값을 쉽게 출력하도록 고안된 언어이다
- 즉 표현식 (<%= %>)를 대체할 수 있다
- EL 표현식에서 도트 연산자 왼쪽은 반드시 java.util.Map 객체 또는 Java Bean 객체여야 한다.
- EL 표현식에서 도트 연산자 오른쪽은 반드시 맵의 키이거나 Bean 프로퍼티여야 한다

#### 제공 하는 기능
  - JSP의 네가지 기본 객체가 제공하는 영역의 속성 사용
  - 자바 클래스 메소드 호출 가능
  - 표현 언어만의 기본 객체 제공
  - 수치, 관계, 논리 연산 제공

#### EL 문법

```jsp
${userinfo.zipDto.address}

Map을 사용하는 경우
${<Map>.<Map의 키>}

Java Bean을 사용하는 경우
${<Java Bean>.<Bean 프로퍼티>}
```
- [] 연산자 사용
```
${userinfo["name"]}
${userinfo.name}
// 같은 결과임
```

#### 내장 객체

- 범위 객체
  - pageScope
  - requestScope
  - sessionScope
  - applicationScope
- 요청 매개변수
  - param
    - request.getParameter(String)
  - paramValues
    - request.getParameterValues(String)
- 요청 헤더
  - header
  - headerValues
- 쿠키
  - cookie
    - request.getCookies()
- 초기화 매개변수
  - initParam

#### EL 사용법

- pageContext(Java beans)를 제외한 모든 EL 내장 객체는 Map이다
  - key와 value의 쌍으로 값을 저장
- 기본 문법
  - ```${expr}```

#### EL에서 객체 접근

- request.setAttribute("userinfo", "최현인");
  1. ``` ${requestScope.userinfo} ```
  2. ``` ${pageContext.request.userinfo}, ${userinfo} //프로퍼티 이름만 사용할 경우 범위 순으로 객체를 찾음 ```
- url?name=최현인&fruit=사과&fruit=바나나
  1. ``` ${param.name} ```
  2. ``` ${paramValues.fruit[0]}, ${paramValues.fruit[1]} ```
- request.setAttribute("bank.user", memberDto)
  1. ``` ${bank.user.name} //에러 발생, bank라는 속성이 없다고 뜸```
  2. ``` ${requestScope["bank.user"].name} ```
- Cookie
  - ${cookie.id.value}
    - cookie가 null이라면 null return
    - cookie가 null이 아니라면 id 검사 후 null이라면 null return
    - id가 null이 아니라면 value값 검사

**EL은 값이 null이라도 null을 출력하지 않는다. (공백처리)**

#### 연산자
- 산술
  - +, -, /, *, %
- 관계형
  - ==(eq), !=(ne), <(lt), >(gt), <=(le), >=(ge)
- 3항 연산
  - 조건 ? 값1 : 값2
- 논리
  - &&(and), ||(or), !(not)
- 타당성 검사
  - empty
    - empty 연산자에서 true를 리턴하는 경우
      - 값이 null
      - 값이 빈 문자열 ("")
      - 길이가 0인 배열
      - 빈 Map 객체
      - 빈 Collection 객체

#### 메소드 호출

```
<% 
  List<MemberDto> list = dao.getMembers();
  request.setAttribute("users", list);
%>

회원 수 : ${request.users.size()}

// 주의 : ${request.users.size} 괄호를 생략하면 프로퍼티에 접근하게 됨, size란 프로퍼티가 없었으면 에러 발생
```

## JSTL

### JSTL(Jsp Standard Tag Library)

- JSP에서 사용하는 표준 태그 라이브러리
- 자바 코들르 바로 사용하지 않고 로직을 내장하는 효율적인 방법을 제공한다
- custom tag: 개발자가 직접 태그를 작성할 수 있는 기능을 제공
- 많이 사용되는 custom tag를 모아서 JSTL이라는 규약을 만듦
- 논리적인 판단, 반복문의 처리, 데이터베이스 등의 처리를 할 수 있다

#### JSTL Tag

directive 선언 형식 : <%@ taglib prefix="prefix" uri="uri" %>
- core **[가장 많이 사용]**
  - prefix : c
  - 변수지원, 흐름제어, URL 처리
  - uri : http://java.sun.com/jsp/jstl/core
- XML
  - prefix : x
  - XML 코어, 흐름제어, XML 반환
  - uri : http://java.sun.com/jsp/jstl/xml
- 국제화
  - prefix : fmt
  - 지역, 메세지 형식, 숫자 및 날짜 형식
  - uri : http://java.sun.com/jsp/jstl/fmt
- database
  - prefix : sql
  - SQL
  - uri : http://java.sun.com/jsp/jstl/sql
- 함수
  - Collection, String 처리
  - uri : http://java.sun.com/jsp/jstl/functions

#### core tag - 주요 태그

- 변수 지원
  - set
    - jsp 페이지에서 사용 할 변수 설정
    ```JSP
      <!-- value 속성을 이용하여 변수 값 할당 -->
      <c:set value="value" var="varName" [scope="{page(default)|request|session|application}"] />

      <!-- 액션의 body content를 사용하여 변수 값 할당 -->
      <c:set var="varName" [scope="{page(default)|request|session|application}"]>
        body content
      </c:set>

      <!-- value 속성을 이용하여 대상 객체의 프로퍼티 값 할당 -->
      <c:set value="value" target="target" property="propertyName" />

      <!-- 액션의 Body 컨텐츠를 사용하여 대상 객체의 프로퍼티 값 할당 -->
      <c:set target="target" property="propertyName">
        body content
      </c:set>
    ```
- 흐름 제어
  - if
    - 조건에 따른 코드 실행
    ```JSP 
      <c:if test="조건" var="결과 boolean 값을 저장할 변수">
        조건이 true인 경우 실행할 코드
      </c:if>  
    ```
  - choose, when, otherwise
    - 다중 조건 처리
    ```JSP 
      <c:choose>
        <c:when test="조건1">
          조건1이 true인 경우 실행할 코드
        </c:when>
        <c:when test="조건2">
          조건2가 true인 경우 실행할 코드
        </c:when>
        <c:otherwise>
          모든 조건에 걸리지 않은 경우
        </c:otherwise>
      </c:choose>  
    ```
  - forEach
    - 반복문 처리
    - 컬렉션에 있는 항목들에 대하여 액션의 Body 컨텐츠를 반복하여 수행
    ```JSP
      <c:forEach var="반복에 대해 현재 항목" items="반복할 항목들을 갖는 컬렉션" varStatus="현재 반복의 상태">
        반복할 내용
      </c:forEach>
    ```
- 기타
  - catch
    - 예외 처리에 사용
    - JSP에서 예외가 발생할 만한 코드를 오류 페이지로 넘기지 않고 직접 처리할 때 사용
    - catch와 if 액션을 함께 사용하여 try-catch 구조를 구현할 수 있음
    ```JSP

    <c:catch var="ex">
      예외가 생길 수 있는 코드
    </c:catch>

    <c:if test="${ex != null}">
      예외가 발생하였습니다. ${ex.message}
    </c:if>
    ```