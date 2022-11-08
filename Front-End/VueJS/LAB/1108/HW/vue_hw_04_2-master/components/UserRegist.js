export default {
  template: `
    <div class="container">
      <h2>회원 가입</h2>
      <fieldset class="text-center">
        <label for="id">아이디</label>
        <input type="text" id="id" v-model="id" class="view" /><br />
        <label for="password">비밀번호</label>
        <input
          type="password"
          id="password"
          v-model="password"
          class="view"
        /><br />
        <label for="name">이름</label>
        <input type="text" id="name" v-model="name" class="view" /><br />
        <label for="email">이메일</label>
        <input type="email" id="email" v-model="email" class="view" /><br />
        <label for="age">나이</label>
        <input type="number" id="age" v-model="age" class="view" /><br />
        <button class="btn" @click="regist">등록</button>
      </fieldset>
    </div>
    `,
  data() {
    return {
      id: "",
      password: "",
      name: "",
      email: "",
      age: 0,
    };
  },
  methods: {
    regist() {
      if (
        this.id === "" ||
        this.password === "" ||
        this.name === "" ||
        this.email === ""
      ) {
        alert("모든 내용을 입력해주세요");
        return;
      }

      let user = {
        id: this.id,
        password: this.password,
        name: this.name,
        email: this.email,
        age: this.age,
      };

      this.$emit("regist", user);
    },
  },
};
