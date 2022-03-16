# Html+Css 공부

## HTML(HyperText Markup Language)

웹을 이루는 가장 기초적인 구성 요소로, 웹 콘텐츠의 의미와 구조를 정의할 때 사용한다.

## Element(요소)

```
<태그이름>컨텐츠</태그이름> //HTML Element
<head>, <title>, <body>, <header>, <footer>, <article>, <section>, <p>, <div>, <span>, <img>, <aside>, <audio>, <canvas>, <datalist>, <details>, <embed>, <nav>, <output>, <progress>, <video>, <ul>, <ol>, <li> etc..
```
HTML은 Element의 조합이다.

## Attribute
Attribute는 HTML Element의 추가적인 속성을 관리하기 위한 요소. Element별로 사용가능한 Attribute가 다르다.
```
<img width = "400px" src="link"> //이 경우엔 width와 src가 Attribute가 된다.
```

## style


```
<p style="color: red;">I'm red</p>
<p style="color: blue;">I'm blue</p>
<p style="font-size: 50px;">I'm blue</p>
```

일일히 스타일을 지정해줄 수 있지만, 코드가 길어질 때 한번에 변경해야 할 소요가 생기면 비효율적이다. 이때, CSS를 통해서 전체 페이지에 스타일을 적용할 수 있다.

```
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
```
// style.css
.color-primary{
    color: rgb(190, 74, 74);
}
.font-50{
    font-size: 50px;
}

// index.html
...
<link rel="stylesheet" href="style.css">

<p class="color-primary">I'm red</p>
<p class="color-primary">I'm blue</p>
<p class="color-primary font-50">I'm big</p>
...

```
- 위와 같이 style element를 css 파일로 따로 저장해서 사용할 수도 있다.
- 개발자가 css파일을 직접 작성해도 되고 디자이너들이 미리 만들어놓은 css파일을 다운받아서 사용할 수도 있다.

## event
클릭, 스크롤 다운을 할 때 이벤트가 발생된다. 이런 사용자의 행위를 인식하는 것을 event Element라고 한다.
```
<button type="button" onclick="javascript:alert('click button!!');">click!</button>
```
- 가장 간단한 버튼 클릭 이벤트다. 사용자가 버튼을 누르면 알람창이 뜬다.

### body


출처 
- [유튜브 강의 : 한시간만에 끝내는 HTML+CSS 입문](https://www.youtube.com/watch?v=cb7VlXqFla4)
- [참고서 : 개발자를 위한 웹 기술(Mozilla)](https://developer.mozilla.org/ko/docs/Web/HTML)