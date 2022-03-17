# Html+Css 공부

## HTML(HyperText Markup Language)

웹을 이루는 가장 기초적인 구성 요소로, 웹 콘텐츠의 의미와 구조를 정의할 때 사용한다.

### 구조

![image](https://www.devkuma.com/data/page/115/html_template.png)  
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

일일히 스타일을 지정해줄 수 있지만, 코드가 길어질 때 한번에 변경해야 할 소요가 생기면 비효율적이다. 이때, CSS를 통해서 전체 페이지에 스타일을 적용할 수 있다.

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

## CSS

위에서 적용한 CSS는 효율적인 방법은 아니다.  
CSS에 대해서 더 알아본다.

### CSS 문법


디자인 요소를 의도에 맞게 적용하기 위해서는 여러 종류의 선택자를 잘 혼합해서 사용하는 것이 중요하다.

![image](https://www.devkuma.com/data/page/344/css_syntax2.png)  
출처 : <https://www.devkuma.com/docs/css/css-%EB%AC%B8%EB%B2%95/>

## 공부하기 유용한 사이트

- [w3schools.com](https://w3schools.com)
  - 웹 관련된 공부자료들이 풍부함
  - html, js, css 등등

### 출처

- [유튜브 강의 : 한시간만에 끝내는 HTML+CSS 입문](https://www.youtube.com/watch?v=cb7VlXqFla4)
- [참고서 : 개발자를 위한 웹 기술(Mozilla)](https://developer.mozilla.org/ko/docs/Web/HTML)
