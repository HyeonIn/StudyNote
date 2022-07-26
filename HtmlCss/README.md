# Html+Css 공부

## HTML(HyperText Markup Language)

웹을 이루는 가장 기초적인 구성 요소로, 웹 콘텐츠의 의미와 구조를 정의할 때 사용한다.

### 구조

![html 구조](https://github.com/HyeonIn/StudyNote/blob/main/HtmlCss/html_template.png)  
출처 : <devkuma.com/docs/html/html-기본-구조/>

### Element(요소)

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

```html
<select>
    <option>Seoul</option>
    <option>Jeju</option>
</select>
```

- 사용자의 선택을 입력받는 요소
  
#### table

```css
.tb-head>tr>td{
    border : 1px solid #000;
    font-size: 14px;
    font-weight: bold;
    color: red;
}

.tb-body>tr>td{
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
<img width = "400px" src="link"> 
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

``` html
<style>
    .color-primary{
        color: red;
    }
    .font-50{
        font-size: 50px;
    }
</style>

<p class="color-primary">I'm red</p>
<p class="color-primary">I'm blue</p>
<p class="color-primary font-50">I'm big</p>
```

- 위처럼 html 스크립트 안에 클래스 형식으로 style을 선언해주면 style 변경 소요가 발생할 때 style 내부만 수정해주면 된다.

``` css
.color-primary{
    color: rgb(190, 74, 74);
}
.font-50{
    font-size: 50px;
}
```

```html
...
<link rel="stylesheet" href="style.css">

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

.class1{
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
.font-50{
    font-size: 50px;
}/*font 크기를 50px로 지정하는 클래스*/
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
