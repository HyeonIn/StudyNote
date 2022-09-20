## HTML(HyperText Markup Language)

웹을 이루는 가장 기초적인 구성 요소로, 웹 콘텐츠의 의미와 구조를 정의할 때 사용한다.

### HTML 개요

- 1990년도 이후 웹에서 사용하는 문서 양식
- 문서에 하이퍼텍스트, 표, 목록, 비디오 등을 포함할 수 있는 tag를 사용
- 문서를 Web Browser에 표현할 때 tag를 사용

### 개발 배경

- 수 많은 플러그인드롤 인한 Browser 간의 부작용을 막기 위해 개발
- HTML5의 탄생 목적은 기존의 Web Browser에 많은 플러그인이 설치되면서 많은 문제점이 발생했고, 이를 해결하기 위한 방안으로 W3C에서 Web Application1.0을 HTML5로 수용. 2014년에 정식으로 배포되었으며, 계속 업그레이드되고 있다.

### 웹 표준이란?

- 모든 브라우저에서 웹서비스가 정상적으로 보여질 수 있도록 하는 것
- W3C(World Wide Web Consortium)
  - 월드 와이드 웹의 창시자인 팀 버너스 리를 중심으로 창립된 월드 와이드웹 컨소시엄
- W3C에서 HTML5를 웹 표준으로 권고하고 웹 브라우저는 이를 따름

### HTML5의 특징

- HTML5는 지금도 개발 중에 있고, 다양한 기능이 추가됨
- 멀티미디어 요소 재생
  - 과거 브라우저는 멀티미디어를 재생하기 위해 별도의 외부 플러그인을 사용해야 했으나, HTML5에서는 멀티미디어 요소를 별도의 플러그인 없이도 재생가능
- 서버와 통신
  - 서버와 클라이언트 사이에 소켓 통신이 가능
- Sematic tag 추가
  - 웹사이트를 검색엔진이 좀 더 빠르게 검색할 수 있도록 하기 위해 특정 tag에 의미를 부여하는 방식
  - 예를 들어 header tag는 문서의 주제를 나타내는 tag로써 header tag가 사용된 웹 문서의 경우 검색 엔진은 웹 문서의 모든 내용을 검색하는 것이 아닌 header tag의 내용만을 검색해서 보다 빠르게 검색을 진행할 수 있다.

### HTML 문서 구조

- 시작 태그와 종료 태그가 있으며, 태그 사이에 문서 내용을 정의
- 각 태그는 고유의 의미를 가지고 있으며, 웹 브라우저는 이 의미에 따라 문서를 화면에 표시

### Web & HTML 작동원리

- 서버는 클라이언트의 요청 내용을 분서하여 결과값을 HTML로 전송
- 서버는 결과값을 전송한 후 클라이언트와 연결 종료
- 클라이언트는 서버로부터 전달받은 HTML을 Web Browser에 표시
- 각 Web Browser는 부라우저 엔진이 내장되어 있고, 이 엔진이 tag를 해석하여 화면에 표현

### tag와 속성

- HTML 문서는 tag로 만들어진다
- HTML 문서의 전체 구성은 html, head, body tag로 구성된다
- tag는 시작 tag와 종료 tag로 쌍을 이루거나 시작 tag만 존재하는 tag도 있다
- 시작 tag와 종료 tag는 '/'로 구분하며 중첩되지 않도록 한다
- 각각의 tag는 속성과 속성의 값이 존재한다
- HTML tag에는 어느 tag에나 넣어서 사용할 수 있는 글로벌 속성(global attribute)이 있다.
  - class, dir, id, style, title

### 주석

- 주석의 내용은 브라우저에 출력되지 않는다
- HTML tag의 내용을 설명하기 위한 용도

### Root 요소

- html tag는 HTML 문서 전체를 정의
- Head와 Body로 구성

### Head 요소

#### 머리글(head), 제목(title)

- head 태그는 브라우저에게 HTML 문서의 머리 부분임을 인식
- title, meta, style, script, link 태그를 포함 가능
- title 태그는 문서의 제목을 의미, 브라우저에서 제목 표시줄에 태그 내용이 나타남
- title 태그 이외의 다른 태그로 표현한 정보는 화면에 출력 X

#### 메타 데이터(meta)

- 문서의 작성자, 날짜, 키워드 등 브라우저의 본문에 나타나지 않는 일반 정보를 나타냄
- name과 content 속성을 이용하여 다양한 정보를 나타냄
- http-equiv 속성을 이용하여 인코딩 설정 및 문서 이동, 새로 고침이 가능
- charset 속성을 이용하여 문서의 인코딩 정보를 설정

### Body 요소

#### body

- Web Browser에 보여질 문서의 내용을 작성
- head tag 다음에 위치하고 head 내부에 위치하는 tag와 html을 제외한 모든 tag
- id 속성을 이용하여 문서 내에서 tag를 유일하게 식별 가능 (id 속성은 중복 X)
- class 속성을 이용하여 여러 tag에 공통적인 특성(CSS)을 부여 (class 속성은 중복 O)

#### heading

- 문단의 제목을 지정할 때 사용
  - h1부터 h6까지 구분, 숫자가 커질수록 글자는 작아짐
- section 태그를 이용하면 같은 태그를 서로 다르게 표현
- 문서 구조를 section 태그를 이용하여 구분하면 각 문단의 제목을 하나의 tag로 작성 가능

### 특수문자

- &nbsp, &lt, &gt, &amp, &quot, &copy, &reg 등



#### Element(요소)

```html
<Element>Contents</Element>

<head>, <title>, <body>, <header>, <footer>, <article>, <section>, <p>, <div>, <span>, <img>, <aside>, <audio>, <canvas>, <datalist>, <details>, <embed>, <nav>, <output>, <progress>, <video>, <ul>, <ol>, <li> etc..
```

- HTML은 Element의 조합이다.

### 자주 사용되는 Element들

#### input

```html
<input type="text" />
```

- 사용자의 입력을 받는 요소
- type을 지정할 수 있다. (number, text 등)
- 닫는 형식이 없다

#### select

#### semantic
- 의미론적인 코드

```html
<select>
  <option>Seoul</option>
  <option>Jeju</option>
</select>
```

- 사용자의 선택을 입력받는 요소

#### table

```css
.tb-head > tr > td {
  border: 1px solid #000;
  font-size: 14px;
  font-weight: bold;
  color: red;
}

.tb-body > tr > td {
  border: 1px solid #000;
}
```

```html
<table>
  <thead class="tb-head">
    <tr>
      <td>이름</td>
      <td>지역</td>
      <td>전화번호</td>
    </tr>
  </thead>
  <tbody class="tb-body">
    <tr>
      <td>홍길동</td>
      <td>서울</td>
      <td>010-111-1111</td>
    </tr>
  </tbody>
</table>
```

- thead : 행의 첫 줄, 즉 컬럼명
- tbody : 행 데이터
- 테이블 역시 스타일 지정이 가능하고 css로 해준 모습이다.

#### a

```html
<a href="https://www.naver.com">네이버</a>
```

- 주로 링크 명시할때 사용
- href 속성 지정으로 링크 지정가능
- target 속성으로 새 창을 어디에 띄울건지 조정가능

### Attribute

Attribute는 HTML Element의 추가적인 속성을 관리하기 위한 요소.  
Element별로 사용가능한 Attribute가 다르다.

```html
<img width="400px" src="link" />
```

- 이 경우엔 **width**와 **src**가 **img** Element의 Attribute가 된다.

### style

#### 스타일은 HTML을 꾸미는 역할

```html
<p style="color: red;">I'm red</p>
<p style="color: blue;">I'm blue</p>
<p style="font-size: 50px;">I'm blue</p>
```

일일히 스타일을 지정해줄 수 있지만, 코드가 길어질 때 한번에 변경해야 할 소요가 생기면 비효율적이다.  
이때, CSS를 통해서 전체 페이지에 스타일을 적용할 수 있다.

```html
<style>
  .color-primary {
    color: red;
  }
  .font-50 {
    font-size: 50px;
  }
</style>

<p class="color-primary">I'm red</p>
<p class="color-primary">I'm blue</p>
<p class="color-primary font-50">I'm big</p>
```

- 위처럼 html 스크립트 안에 클래스 형식으로 style을 선언해주면 style 변경 소요가 발생할 때 style 내부만 수정해주면 된다.

```css
.color-primary {
  color: rgb(190, 74, 74);
}
.font-50 {
  font-size: 50px;
}
```

```html
...
<link rel="stylesheet" href="style.css" />

<p class="color-primary">I'm red</p>
<p class="color-primary">I'm blue</p>
<p class="color-primary font-50">I'm big</p>
```

- 위와 같이 style element를 css 파일로 따로 저장해서 사용할 수도 있다.
- 개발자가 css파일을 직접 작성해도 되고 디자이너들이 미리 만들어놓은 css파일을 다운받아서 사용할 수도 있다.

### event

클릭, 스크롤 다운을 할 때 이벤트가 발생된다. 이런 사용자의 행위를 인식하는 것을 event Element라고 한다.

```html
<button type="button" onclick="javascript:alert('click button!!');">click!</button>
```

- 많이 사용되는 버튼 클릭 이벤트다. 사용자가 버튼을 누르면 알람창이 뜬다.

### HTML 주석

```html
<!-- 주석은 이렇게 작성한다 -->
```

- 주석은 웹 페이지에 나타나지 않는다. 주석을 보고 싶으면 웹 브라우저의 페이지 소스보기 등을 통해 확인 할 수 있다.

### AJAX (Asynchronous JavaScript XML) 

- 언어나 프레임워크가 아닌 구현하는 방식을 의미
- 웹에서 화면을 갱신하지 않고 데이터를 서버로부터 가져와 처리하는 방법
- 객체로 데이터를 전달하고 비동기 방식으로 결과를 조회
- 화면 갱신이 없으므로 사용자 입장에서는 편리하지만 동적으로 DOM을 구성해야 하므로 구현이 복잡

#### 서버와 클라이언트의 상호작용
- 웹 화면을 구성하는 방식은 서버 중심의 상호작용 방식(SSR)과 클라이언트 중심의 상호작용 방식(CSR)으로 구분
- 서버 중심의 개발방식은 화면 구성이 서버에서 이루어진다 (JSP, PHP, ASP)
- 클라이언트 중심의 개발방식은 클라이언트에서 화면을 구성한다
- AJAX는 클라이언트 중심의 개발방식이며 비동기 요청보다는 동적 화면구성이 관건임
  - 서버에서는 화면 구성을 위한 데이터만 만들어준다

#### AJAX 사용 방식

```JavaScript
var ajax = new XMLHttpRequest()
ajax.onreadystatechange = function () {
  if (this.readyState == 4){
    console.log(ajax.responseText);
    console.log(ajax.responseXML)
  }
}
ajax.open("GET/POST", "호출 URL", true(동기/비동기));
```
## CSS(Cascading Style Sheets)

위에서 예시로 짧게 적용한 CSS는 효율적인 방법은 아니다.  
CSS에 대해서 더 알아본다.

### CSS 구조

![html 구조](https://github.com/HyeonIn/StudyNote/blob/main/HtmlCss/css_template.png)  
출처 : <https://www.devkuma.com/docs/css/css-%EB%AC%B8%EB%B2%95/>

- 디자인 요소를 의도에 맞게 적용하기 위해서는 여러 종류의 선택자를 잘 혼합해서 사용하는 것이 중요하다.

### 선택자

선택자란 CSS 스타일을 적용할 요소를 접근법이다.

#### \* : 전체선택자

- 전체적인 스타일 적용가능

#### p : 태그 선택자

- 원하는 태그를 선택해서 해당 태그가 달린 모든 값들에 스타일을 적용한다.

#### .class : 클래스 선택자

- 사용자가 클래스명을 지정해서 해당 클래스가 적용된 값에만 스타일을 지정가능하다.
- 클래스명 앞에 "." 을 꼭 명시하자

#### #id : 아이디 선택자

- 이때 html에서 명시한 ID는 모든 필드에 유일한 값이어야 됨

#### div ul : 하위 선택자

- 하위에 있는 값을 직접 입력해서 찾아가는 선택자
- 이때 div 값은 태그 선택자가 될 수도 있고 아이디 선택자도 될 수 있다.
- 결국 하위 태그를 찾고자 하는 상위 태그 값을 입력해 주면된다.
- div 안에 ul을 전부 스타일 적용해주겠다.

#### div>ul : 자식 선택자

- 자식 경로를 하나하나 찾아가는 개념
- 하위 선택자와 다른 점은 하위 선택자는 찾고자 하는 태그 값을 하위 태그에서 전부 찾아 내지만, 자식 선택자는 찾고자 하는 깊이까지만 직접 찾아간다.

#### 이 외에도 특성 선택자나 그룹 선택자 같은 개념도 있다

```css
p {
  background: yellowgreen;
}

.class1 {
  color: green;
}
```

```html
<p class="class1">Hi</p>
```

- 위 경우 처럼 선택자가 겹친 경우 서로 다른 내용의 스타일이면 중첩되어 적용된다.
  - 위의 경우에선 **background**, **color**가 적용된 Hi가 출력 될 것.

### Property

- css에서 속성은 property라고 부른다.
- 속성 값은 property-value

### CSS 주석

```css
.font-50 {
  font-size: 50px;
} /*font 크기를 50px로 지정하는 클래스*/
```

- 위와 같이 css 안에도 주석을 작성할 수 있다.
- css 코드가 간단하다면 크게 필요 없지만 복잡한 css 구문을 작성할 때엔 주석을 사용해야 할 것이다.

### 공부하기 유용한 사이트

- [w3schools.com](https://w3schools.com)
  - 웹 관련된 공부자료들이 풍부함
  - html, js, css 등등

#### 출처

- [유튜브 강의 : 한시간만에 끝내는 HTML+CSS 입문](https://www.youtube.com/watch?v=cb7VlXqFla4)
- [참고서 : 개발자를 위한 웹 기술(Mozilla)](https://developer.mozilla.org/ko/docs/Web/HTML)
