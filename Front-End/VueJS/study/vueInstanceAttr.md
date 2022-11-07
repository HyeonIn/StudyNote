### Vue Instance 속성

##### Vue Method

- Vue 객체는 생성과 관련된 data 및 method의 정의 기능
- method안에서 data를 "this.데이터이름"으로 접근 가능

```html
<div id="app">
  <div>data : {{message}}</div>
  <div>method kor : {{helloKor()}}</div>
  <div>method eng : {{helloEng()}}</div>
</div>
<script>
  new Vue({
    el: "#app",
    data: {
      message: "Hello",
      name: "최현인",
    },
    methods: {
      helloEng() {
        return "Hello " + this.name;
      },
      helloKor() {
        return "안녕 " + this.name;
      },
    },
  });

  let vm = new Vue({
    data: {
      count: 1,
    },
    methods: {
      incCount() {
        console.log("incCount 호출됨");
        this.count++;
      },
    },
  });
  vm.incCount();
  console.log(vm.count); // 2
</script>
```

##### Vue filter

- 뷰의 필터는 화면에 표시되는 텍스트의 형식을 쉽게 변환해주는 기능
  - ex) 1000000원 => 1,000,000원
- filter를 이용하여 표현식에 **새로운 결과** 형식을 적용
- 중괄호 보간법 **[{{}}]** 또는 **v-bind** 속성에서 사용이 가능

```html
<!-- 데이터 | 필터이름 -->
{{ message | capitalize }}
<!-- 체이닝 가능, | ... | ... | ... 이런식으로 -->

<div v-bind:id="rawId | formatId"></div>
```

- 전역 필터
  - Vue.filter('name', (val) =>{});

```html
<script>
  Vue.filter("count1", (val) => {
    if (val.length == 0) {
      return;
    }
    return `${val} : ${val.length}자`;
  });
</script>
```

- 지역 필터
- vue 객체의 filters 필드

```html
<div id="app">
  <div>
    <input type="text" v-model="msg" />
  </div>
  <div>
    <h2>결과 :</h2>
    <h3>{{ msg | count1 }}</h3>
    <h3>{{ msg | count2('문자를 넣어보세요') }}</h3>
  </div>
</div>

<script>
  new Vue({
    el: "#app",
    data: {
      msg: "",
    },
    filters: {
      count2(val, alternative) {
        if (val.length == 0) {
          return alternative;
        }
        return `${val} : ${val.length}자`;
      },
    },
  });
</script>
```

- 사용 예
- 금액 단위 표기, 전화번호 표기

```html
<div id="app">
  <div>
    금액 : <input type="text" v-model="msg1" /><br />
    전화번호 : <input type="text" v-model="msg2" />
  </div>
  <div>
    <h3>{{ msg1 | price }}</h3>
    <h3>{{ msg2 | mobile }}</h3>
  </div>
</div>
<script>
  // 금액 단위
  Vue.filter("price", (value) => {
    if (!value) return value;
    return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
  });
  // 전화 번호, 정규 표현식 공부하기, maxlength 활용하면 최대 글자 수 제한 가능
  Vue.filter("mobile", (value) => {
    if (!value || !(value.length === 10 || value.length === 11)) return value;
    return value.replace(/^(\d{3})(\d{3,4})(\d{4})/g, "$1-$2-$3");
  });
  new Vue({
    el: "#app",
    data: {
      msg1: "",
      msg2: "",
    },
  });
</script>
```

##### Vue computed 속성

- 특정 **데이터의 변경사항**을 **실시간으로 처리**
- 캐싱을 이용하여 데이터의 변경이 없을 경우 캐싱된 데이터를 반환 >> 값
- Setter와 Getter를 직접 지정할 수 있음
  - Getter는 기본으로 가지고 있음
- 작성은 method 형태로 작성하지만 Vue에서 **proxy 처리하여** **property 처럼** 사용
- 종속적인 데이터가 변경이 되었을 때 호출

##### Vue computed VS method 차이점

```html
<div id="app">
  <input type="text" v-model="message" />
  <p>원본 메시지: "{{ message }}"</p>
  <p>역순으로 표시한 메시지1: "{{ reversedMsg }}"</p>
  <p>역순으로 표시한 메시지2: "{{ reversedMsg }}"</p>
  <p>역순으로 표시한 메시지3: "{{ reversedMsg }}"</p>
</div>
<script>
  var vm = new Vue({
    el: "#app",
    data: {
      message: "안녕하세요 여러분",
    },
    computed: {
      reversedMsg: function () {
        console.log("꺼꾸로 찍기");
        return this.message.split("").reverse().join("");
      },
    },
  });
</script>
```

- Vue 인스턴스가 생성될 때 data의 message값을 받아 reversedMsg를 계산하여 저장해 놓는다. (캐싱)
- 위 코드에서 reversedMsg를 한 번 실행하는 것과 같다.

```html
<div id="app">
  <input type="text" v-model="message" />
  <p>원본 메시지: "{{ message }}"</p>
  <p>역순으로 표시한 메시지1: "{{ reversedMsg() }}"</p>
  <p>역순으로 표시한 메시지2: "{{ reversedMsg() }}"</p>
  <p>역순으로 표시한 메시지3: "{{ reversedMsg() }}"</p>
</div>
<script>
  var vm = new Vue({
    el: "#app",
    data: {
      message: "안녕하세요 싸피여러분",
    },
    methods: {
      reversedMsg: function () {
        console.log("꺼꾸로 찍기");
        return this.message.split("").reverse().join("");
      },
    },
  });
</script>
```

- method는 reversedMsg()를 사용하려고 할 때마다 계산한다
- 위 코드에서는 reversedMsg()를 세 번 실행하는 것과 같다.

##### Vue watch 속성

- Vue Instance의 특정 property가 변경될 때 실행할 콜백 함수 설정
- 디버깅할 때 사용

```html
<div id="app">
  <div>
    <input type="text" v-model="a" />
  </div>
</div>
<script>
  var vm = new Vue({
    el: "#app",
    data: {
      a: 1,
    },
    watch: {
      a: function (val, oldVal) {
        console.log("new: %s, old: %s", val, oldVal);
      },
    },
  });
  console.log(vm.a);
  vm.a = 2; // => new: 2, old: 1
  console.log(vm.a);
</script>
```

- Computed는 종속된 데이터가 변경되었을 경우 그 데이터를 다시 계산하여 캐싱한다
- Watch의 경우는 data가 변경되었을 경우 다른 data를 (변경하는) 작업을 한다

```html
<div id="app">
  <p>원본 메시지: "{{ message }}"</p>
  <p>역순으로 표시한 메시지: "{{ reversedMsg }}"</p>
  <input type="text" v-model="message" />
</div>
<script>
  const app = new Vue({
    el: "#app",
    data: {
      message: "Hello",
      reversedMsg: "",
    },
    watch: {
      message: function (newVal, oldVal) {
        console.log(newVal, oldVal);
        this.reversedMsg = newVal.split("").reverse().join("");
      },
    },
  });
</script>
```