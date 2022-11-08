export default {
  template: `
    <div class="container">
        <h2>로그인</h2>
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
        <button class="btn" @click="login">로그인</button>
        </fieldset>
    </div>
    `,
  data() {
    return {
      id: "",
      password: "",
    };
  },
  methods: {
    login() {
      let user = {
        id: this.id,
        password: this.password,
      };

      this.$emit("login", user);
    },
  },
};
