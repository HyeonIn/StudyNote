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
          <tr v-for="(book, index) in books" :key="index">
            <td>{{ index + 1 }}</td>
            <td>{{ book.isbn }}</td>
            <td>
              <a @click="titleClick(book.isbn)">{{ book.title }}</a>
            </td>
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
    // localStorage에서 booklist로 저장된 도서 목록을 얻어온다.
    const booklist = localStorage.getItem("booklist");
    let newBook = {
      books: [],
    };
    if (booklist) {
      // 도서목록이 있을경우 JSON객체로 parsing한다.
      newBook = JSON.parse(booklist);
    } else {
      localStorage.setItem("booklist", JSON.stringify(newBook));
    }
    // 가격순으로 정렬
    newBook.books.sort((a, b) => {
      return -(a.price - b.price);
    });
    // 전역변수 books에 정렬된 도서목록 저장.
    this.books = newBook.books;
  },
  methods: {
    movePage() {
      location.href = "create.html"; //라우터
    },
    numberWithCommas(x) {
      // 숫자의 3자리마다 ',' 찍기
      return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
    titleClick(isbn) {
      this.$emit("setbookinfo", isbn);
    },
  },
};
</script>

<style></style>
