export default {
  template: `
    <header>
    <nav class="header-nav">
      <div>
        <a href="index.html" class="logo">SSAFY USERS</a>
      </div>
      <div>
        <a href="#" v-if="getUser" @click="logout">로그아웃</a>
        <a href="login.html" v-else>로그인</a>
        <a href="regist.html" >회원가입</a>
        <a href="list.html">사용자목록</a>
      </div>
    </nav>
  </header>
  `,
  methods: {
    logout() {
      localStorage.removeItem("loginUser");
      location.href = "index.html";
    },
  },
  computed: {
    getUser() {
      if (localStorage.getItem("loginUser")) {
        return true;
      } else {
        return false;
      }
    },
  },
};
