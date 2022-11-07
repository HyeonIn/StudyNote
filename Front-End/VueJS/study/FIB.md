### form input binding

##### 폼 입력 바인딩

- v-modle directive를 사용하여 폼 input과 textarea element에 양방향 데이터 바인딩을 생성할 수 있다
  - text와 textarea 태그는 value속성과 input이벤트를 사용한다
  - 체크박스들과 라디오 버튼들은 checked 속성과 change 이벤트를 사용한다
  - Select 태그는 value를 prop으로, change를 이벤트로 사용한다

##### form - text, textarea

- 문자열 (text)
- 여러줄을 가진 문장 (textarea)
  - 텍스트 영역의 보간은 작동하지 않는다
    - v-model을 사용

```html
<div id="app">
  <div>
    아이디 :
    <input v-model.trim="id" placeholder="아이디를 입력하세요" />
    <!-- v-model은 기본적으로 모든 key stroke가 발생할 때마다 값을 업데이트 시킨다.
           .lazy 수식어를 추가하여 change 이벤트 이후에 동기화 할 수 있습니다. -->
    <input v-model.lazy="id" placeholder="아이디를 입력하세요" />
  </div>
  <div>
    메세지 :
    <textarea v-model="message" placeholder="내용을 입력하세요"></textarea>
  </div>
  <p>{{ id }} 님에게 보내는 메세지 : {{ message }}</p>
</div>
<script>
  new Vue({
    el: "#app",
    data: {
      id: "",
      message: "",
    },
  });
</script>
```

##### form - checkbox

- 하나의 체크박스는 단일 boolean 값을 갖는다

```html
<div id="app">
  <div>
    <p>
      이메일 수신
      <input type="checkbox" id="emailYN" v-model="email" />
      <label for="emailYN">{{ email }}</label>
    </p>
  </div>
  <div>
    <p>
      SMS 수신
      <input type="checkbox" id="smsYN" v-model="sms" true-value="Y" false-value="N" />
      <label for="smsYN">{{ sms }}</label>
    </p>
  </div>
</div>
<script>
  new Vue({
    el: "#app",
    data: {
      email: false,
      sms: "Y",
    },
  });
</script>
```

- 여러 개의 체크박스는 같은 배열을 바인딩 할 수 있다
- 배열의 값과 checkbox의 value 속성이 같을 경우 체크 처리됨

```html
<div id="app">
  <div>당신이 가고 싶은 지역을 선택하시오</div>
  <input type="checkbox" id="buk" value="부울경" v-model="checkedAreas" />
  <label for="buk">부울경</label>
  <input type="checkbox" id="gwangju" value="광주" v-model="checkedAreas" />
  <label for="gwangju">광주</label>
  <input type="checkbox" id="gumi" value="구미" v-model="checkedAreas" />
  <label for="gumi">구미</label>
  <input type="checkbox" id="daejeon" value="대전" v-model="checkedAreas" />
  <label for="daejeon">대전</label>
  <input type="checkbox" id="seoul" value="서울" v-model="checkedAreas" />
  <label for="seoul">서울</label>
  <br />
  <span>체크한 이름: {{ checkedAreas }}</span>
</div>
<script>
  new Vue({
    el: "#app",
    data: {
      checkedAreas: [],
    },
  });
</script>
```

##### form - radio

- radio의 경우 선택된 항목의 value 속성의 값을 관리

```html
<div id="app">
  <div>수업을 듣는 지역을 선택하시오</div>
  <div>
    <input type="radio" id="buk" value="부울경" v-model="ckArea" />
    <label for="buk">부울경</label>
    <input type="radio" id="gwangju" value="광주" v-model="ckArea" />
    <label for="gwangju">광주</label>
    <input type="radio" id="gumi" value="구미" v-model="ckArea" />
    <label for="gumi">구미</label>
    <input type="radio" id="daejeon" value="대전" v-model="ckArea" />
    <label for="daejeon">대전</label>
    <input type="radio" id="seoul" value="서울" v-model="ckArea" />
    <label for="seoul">서울</label>
  </div>
  <span>선택한 지역 : {{ ckArea }}</span>
</div>
<script>
  new Vue({
    el: "#app",
    data: {
      ckArea: "광주",
    },
  });
</script>
```

##### form - select

- select box일 경우 선택된 항목의 value 속성의 값을 관리
- v-model 표현식의 초기 값이 어떤 옵션에도 없으면, `<select>` element는 선택없음 상태로 렌더링 된다

```html
<div id="app">
  <div>
    <p>수업을 듣는 지역을 선택하시오</p>
    <!-- 다중 선택도 가능 -->
    <!-- <select v-model="selectedArea" multiple> -->
    <select v-model="selectedArea">
      <option disabled value="">선택하세요</option>
      <option value="buk">부울경</option>
      <option value="gwangju">광주</option>
      <option value="gumi">구미</option>
      <option value="daejeon">대전</option>
      <option value="seoul">서울</option>
    </select>
  </div>
  <span>선택한 지역 : {{ selectedArea }}</span><br />
</div>
<script>
  new Vue({
    el: "#app",
    data: {
      selectedArea: "",
    },
  });
</script>
```

- v-for를 이용한 동적 option 렌더링

```html
<div id="app">
  <div>
    <select>
      <option value="1">1</option>
      <option value="2" selected>2</option>
      <option value="3">3</option>
    </select>
    <p>수업을 듣는 지역을 선택하시오</p>
    <select v-model="selectedArea">
      <option v-for="option in options" v-bind:value="option.value">{{ option.text }}</option>
    </select>
  </div>
  <span>선택한 지역 : {{ selectedArea }}</span>
</div>
<script>
  new Vue({
    el: "#app",
    data: {
      selectedArea: "",
      options: [
        { text: "서울", value: "seoul" },
        { text: "광주", value: "gwangju" },
        { text: "대전", value: "daejeon" },
        { text: "구미", value: "gumi" },
        { text: "부울경", value: "buk" },
      ],
    },
    created() {
      param = "gwangju";
      this.selectedArea = param;
    },
  });
</script>
```

##### form - 수식어 (Modifier) .

- .lazy
  - change 이벤트 이후에 동기화
- .number
  - 자동으로 숫자로 형변환
- .trim
  - 공백 제거


