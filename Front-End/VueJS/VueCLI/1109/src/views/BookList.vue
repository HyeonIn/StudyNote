<template>
  <div>
    <h1 class="underline">도서 목록</h1>
    <div style="text-align: right">
      <button @click="movePage">도서 등록</button>
    </div>
    <div v-if="books.length">
      <table id="book-list">
        <colgroup>
          <col style="width: 5%" />
          <col style="width: 20%" />
          <col style="width: 40%" />
          <col style="width: 20%" />
          <col style="width: 15%" />
        </colgroup>
        <thead>
          <tr>
            <th>번호</th>
            <th>ISBN</th>
            <th>제목</th>
            <th>저자</th>
            <th>가격</th>
          </tr>
        </thead>
        <tbody>
          <tr
            v-for="(book, index) in books"
            :key="index"
            @click="titleClick(book.isbn)"
          >
            <td>{{ index + 1 }}</td>
            <td>{{ book.isbn }}</td>
            <td>{{ book.title }}</td>
            <td>{{ book.author }}</td>
            <td>{{ numberWithCommas(book.price) }}원</td>
          </tr>
        </tbody>
      </table>
    </div>
    <div v-else class="text-center">게시글이 없습니다.</div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      // 도서목록을 저장할 배열
      books: [],
    };
  },
  created() {
    let _this = this;
    fetch("http://localhost:9999/vuews/book", {})
      .then((resp) => resp.json())
      .then((data) => {
        console.log(data);
        _this.books = data;
      });
  },
  methods: {
    movePage() {
      // this.$router.push({ name: "create" }); //라우터
      this.$router.push({ path: "/create" });
    },
    numberWithCommas(x) {
      // 숫자의 3자리마다 ',' 찍기
      return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
    titleClick(isbn) {
      // 1. params로 데이터 보내는 방법
      // this.$router.push({ name: "view", params: { isbn } });
      // 2. query로 데이터 보내는 방법
      // this.$router.push({ name: "view", query: { isbn } });
      // 3. path Variable 로 보내는 방법
      this.$router.push({ path: `./view/` + isbn });
    },
  },
};
</script>

<style></style>
