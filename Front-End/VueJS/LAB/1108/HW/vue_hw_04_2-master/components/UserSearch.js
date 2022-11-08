export default {
  template: `
  <div class="container">
    <div class="text-center">
      <input
        class="view"
        type="text"
        v-model="search"
        placeholder="이름을 입력하세요."
      />
      <button class="btn">검색</button>
    </div>
    <br />
    <hr />
    <div>
      <h2>검색 결과</h2>
      <div v-if="users"></div>
      <div v-else>검색 결과가 없습니다.</div>
    </div>
    <br />
  </div>
  `,
  data() {
    return {
      search: "",
      users: null,
    };
  },
};
