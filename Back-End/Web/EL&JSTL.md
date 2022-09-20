## EL(Expression Language)

### EL

- EL은 표현을 위한 언어로 JSP 스크립트의 표현식을 대신하여 속성 값을 쉽게 출력하도록 고안된 언어이다
- 즉 표현식 (<%= %>)를 대체할 수 있다
- EL 표현식에서 도트 연산자 왼쪽은 반드시 java.util.Map 객체 또는 Java Bean 객체여야 한다.
- EL 표현식에서 도트 연산자 오른쪽은 반드시 맵의 키이거나 Bean 프로퍼티여야 한다
- 제공 하는 기능
  - JSP의 네가지 기본 객체가 제공하는 영역의 속성 사용
  - 자바 클래스 메소드 호출 가능
  - 표현 언어만의 기본 객체 제공
  - 수치, 관계, 논리 연산 제공

### EL 문법

```jsp
${userinfo.zipDto.address}

Map을 사용하는 경우
${<Map>.<Map의 키>}

Java Bean을 사용하는 경우
${<Java Bean>.<Bean 프로퍼티>}
```

### 사용 가능 데이터
1. request, session, (page, application) 기본 객체에 setAttribute 된 값
```
(Servlet.java)
req.setAttribute("bookList", dao.selectAll());

(List.jsp)
<div>${requestScope.bookList}</div>
```
2. JSTL 태그를 이용해 var 등록된 변수

``` JSP
<c:forEach var="i" begin="1" end="9">
    3*${i} = ${i*3} <br>
</c:forEach>
```
3. requset 객체에 들어있는 parameter랑  Cookie
```
(Wirte.jsp)
<input type="text" name="title">
<input type="number" name="price">
```

```
(Servlet.java)
Stirng title = req.getParameter("title");
int price = Integer.parseInt(req.getPrarmeter("price"));
```
```
(WriteSuccess.jsp)
<h3> ${param.title} 책 추가가 완료되었습니다. </h3>
```


html 태그 안에 java 변수나 객체를 넣고 싶은 경우 사용
