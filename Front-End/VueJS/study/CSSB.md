### CSS class binding

##### class binding

- element의 class와 style을 변경
- v-bind:class는 조건에 따라 class를 적용할 수 있다
- `v-bind:class="{active : true/false }"`
  - active라는 클래스를 적용 할 것인가

```html
<style>
  .active {
    background: rgb(106, 148, 238);
    color: white;
  }

  div {
    width: 200px;
    height: 200px;
    border: 1px solid #444;
  }
</style>

<div id="app">
  <div v-bind:class="{ active: isActive }">VueCSS적용</div>
  <button v-on:click="toggle">VueCSS</button>
</div>
<script type="text/javascript">
  new Vue({
    el: "#app",
    data: {
      isActive: false,
    },
    methods: {
      toggle: function () {
        this.isActive = !this.isActive;
      },
    },
  });
</script>
```

```html
<!-- 스타일 변경 예시 -->
<style type="text/css">
  .completed {
    text-decoration: line-through;
    font-style: italic;
  }
</style>
<div id="app">
  <ul>
    <li :class="{completed: todo.done}" :style="myStyle" v-for="todo, index in todos" :key="index">
      {{todo.msg}}
      <button @click="complete(todo)" class="btn">완료</button>
    </li>
  </ul>
</div>
<script>
  new Vue({
    el: "#app",
    data: {
      todos: [
        {
          msg: "5시간 잠자기",
          done: false,
        },
        {
          msg: "알고리즘 1시간 공부하기",
          done: false,
        },
        {
          msg: "Vue 1시간 공부하기",
          done: false,
        },
      ],
      //스타일 변경
      myStyle: {
        fontSize: "20px",
      },
    },
    methods: {
      complete: function (todo) {
        todo.msg = todo.msg + "완료";
        todo.done = !todo.done;
      },
    },
  });
</script>
```
