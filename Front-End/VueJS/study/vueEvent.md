### Vue Event

##### Vue event

- DOM Event를 청취하기 위해 **v-on** directive 사용
- inline event handling
- method를 이용한 event handling

##### Vue event 청취 : v-on

- v-on directive를 사용하여 DOM 이벤트를 듣고 트리거 될 때, javaScript를 실행 할 수 있다.

```html
<button v-on:click="counter+=1">클릭</button>
<!-- 생략 -->
new Vue({ el: '#app', data:{ counter:0, } })
```

##### method event handler

- 이벤트 발생시 처리 로직을 v-on에 넣기 힘들다
- v-on에서는 이벤트 발생시 처리해야 하는 method의 이름을 받아서 처리한다.

```html
<div id="app">
  <button v-on:click="greet">Greet</button>
</div>
<script>
  var vm = new Vue({
    el: "#app",
    data: {
      name: "SSAFY",
    },
    methods: {
      greet: function (event) {
        alert("Hello " + this.name + "!");
        console.dir(event.target);
      },
    },
  });

  // 또한 JavaScript를 이용해서 메소드를 호출할 수 있습니다.
  //vm.greet(); // => 'Hello Vue.js!'
</script>
```

##### Inline method handler

- 메소드 이름을 직접 바인딩 하는 대신 인라인 JavaScript 구문에 메소드를 사용할 수 도 있다.
- 원본 DOM 이벤트에 엑세스 해야 하는 경우 특별한 $event 변수를 사용해 메소드에 전달할 수도 있다.

```html
<div id="app">
  <form action="http://www.naver.com">
    <button v-on:click="greet1('SSAFY')">Greet</button>
    <button v-on:click="greet2($event, 'Ssafy')">Greet</button>
  </form>
</div>
<script>
  new Vue({
    el: "#app",
    methods: {
      greet1: function (msg) {
        alert("Hello " + msg + "!");
        console.dir(event.target);
      },
      greet2: function (e, msg) {
        if (e) e.preventDefault();
        alert("Hello " + msg + "!");
        console.dir(e.target);
      },
    },
  });
</script>
```

##### 이벤트 수식어 (Event Modifier)

- method는 DOM의 이벤트를 처리하는 것 보다 data 처리를 위한 로직만 작업하는 것이 좋음
- 이 문제를 해결하기 위해, Vue는 v-on 이벤트에 이벤트 수식어를 제공한다
- 수식어는 점으로 표시된 접미사이다.
  - .stop
  - .prevent

```html
<div id="app">
  <h2>페이지 이동</h2>

  <a href="test29.html" @click="sendMsg1">페이지 이동 막기1</a><br />
  <a href="test29.html" @click="sendMsg2">페이지 이동 막기2</a><br />
  <a href="test29.html" @click.prevent="sendMsg1">페이지 이동 막기3</a><br />
</div>
<script>
  new Vue({
    el: "#app",
    methods: {
      sendMsg1() {
        alert("이동할까요?");
      },
      sendMsg2(e) {
        e.preventDefault();
        alert("이동막기");
      },
    },
  });
</script>
```

##### 키 수식어(Key Modifier)

- Vue는 키 이벤트를 수신할 대 v-on에 대한 키 수식어를 추가할 수 있다.
- key code .
  - enter
  - tab
  - delete
  - esc
  - space
  - up
  - down
  - left
  - right

```html
<div id="app">
  아이디 :<br />
  <input placeholder="검색할 아이디를 입력하세요" v-model="id" @keyup="sendId" /><br />
  <input placeholder="검색할 아이디를 입력하세요" v-model="id" @keyup.enter="sendId" /><br />
  <input placeholder="검색할 아이디를 입력하세요" v-model="id" @keyup.13="sendId" /><br />
  <button @click.once="sendId">검색</button>
</div>
<script>
  new Vue({
    el: "#app",
    data: {
      id: "",
    },
    methods: {
      sendId() {
        alert(this.id);
      },
    },
  });
</script>
```

##### ref, $refs

- 뷰에서는 $refs 속성을 이용해 DOM에 접근할 수 있다
- 단, 뷰의 가장 중요한 목적 중 하나는 개발자가 DOM을 다루지 않게 하는 것이므로, 되도록 ref를 사용하는 것을 피하는 것이 좋다

```html
<style>
  .success {
    color: dodgerblue;
  }

  .fail {
    color: darkred;
  }
</style>
<!-- 생략 -->
<div id="app">
  <h2>엘리먼트 참조하기</h2>
  <!-- 아이디 : <input type="text" v-model="id"> -->
  아이디 : <input type="text" v-model="id" ref="id" @keyup="idCheck" />
  <button @click="idCheck">아이디 중복 체크</button>
  <div
    v-bind:class="{success : isSuccess, fail : isFail}"
    v-bind:style="myStyle"
    v-html="msg"
  ></div>
</div>
<script>
  new Vue({
    el: "#app",
    data: {
      id: "",
      msg: "",
      isSuccess: false,
      isFail: false,
      myStyle: {
        fontSize: "25px",
      },
    },
    methods: {
      idCheck() {
        if (this.id.length < 5 || this.id.length > 12) {
          this.msg = `아이디는 5자이상 12자리 이하입니다.`;
          this.$refs.id.focus();
          console.dir(this.$refs.id);
          this.isSuccess = false;
          this.isFail = false;
          return;
        } else {
          if (this.id === "ssafy") {
            this.msg = `<b>${this.id}</b>는 사용할 수 없습니다.`;
            this.isSuccess = false;
            this.isFail = true;
          } else {
            this.msg = `<b>${this.id}</b>는 사용할 수 있습니다.`;
            this.isSuccess = true;
            this.isFail = false;
          }
        }
        console.log(this.$refs.id.value);
      },
    },
  });
</script>
```
