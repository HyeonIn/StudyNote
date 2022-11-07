### 보간법(Interpolation)

##### 문자열

- 데이터 바인딩의 가장 기본 형태는 "Mustache(콧수염)" 구문(이중 중괄호)을 사용한 텍스트 보간
  - `{{속성명}}`
- v-once 디렉티브를 사용하여 데이터 변경 시 업데이트 되지 않는 일회성 보간을 수행

```html
<span>메세지 : {{ msg }}</span>

<span v-once> 다시는 변경하지 않습니다 : {{ msg }}</span>
```

##### 원시 HTML

- 이중 중괄호는 HTML이 아닌 일반 텍스트로 데이터를 해석
- 실제 HTML을 출력하려면 v-html 디렉티브를 사용

```html
<p>Using mustaches: {{rawHtml}}</p>

<p>Using v-html directive: <span v-html="rawHtml"></span></p>
```

##### JavaScript 표현식 사용

- Vue.js는 모든 데이터 바인딩 내에서 JavaScript 표현식의 모든 기능을 지원

```html
{{ number + 1 }} {{ ok ? 'YES' : 'NO'}} {{ message.split('').reverse().join('') }}

<div v-bind:id="'list-' + id"></div>
```

- 한 가지 제한사항은 각 바인딩에 하나의 단일 표현식만 포함될 수 있으므로 아래처럼 작성하면 안됨

```html
<!-- 아래는 구문입니다, 표현식이 아닙니다. -->
{{ var a = 1}}
<!-- 조건문은 작동하지 않습니다. 삼항 연산자를 사용해야 합니다. -->
{{ if (ok) {return message } }}
```