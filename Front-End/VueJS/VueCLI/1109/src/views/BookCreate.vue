<template>
  <div class="regist">
    <h1 class="underline">SSAFY 도서 등록</h1>
    <div class="regist_form">
      <label for="isbn">도서번호</label>
      <input type="text" v-model="isbn" ref="isbn" /><br />
      <label for="title">도서명</label>
      <input type="text" v-model="title" ref="title" /><br />
      <label for="author">저자</label>
      <input type="text" v-model="author" ref="author" /><br />
      <label for="price">가격</label>
      <input type="number" v-model="price" ref="price" /><br />
      <label for="content">설명</label>
      <br /><textarea
        v-model="content"
        ref="content"
        cols="35"
        rows="5"
      ></textarea
      ><br />
      <button @click="checkValue">등록</button>
      <button @click="moveList">목록</button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      isbn: "",
      title: "",
      author: "",
      price: "",
      content: "",
    };
  },
  methods: {
    checkValue() {
      // 사용자 입력값 체크하기
      // isbn, 제목, 저자, 가격, 설명이 없을 경우 각 항목에 맞는 메세지를 출력
      let err = true;
      let msg = "";
      !this.isbn &&
        ((msg = "isbn 입력해주세요"), (err = false), this.$refs.isbn.focus());
      err &&
        !this.title &&
        ((msg = "제목 입력해주세요"), (err = false), this.$refs.title.focus());
      err &&
        !this.author &&
        ((msg = "저자 입력해주세요"), (err = false), this.$refs.author.focus());
      err &&
        !this.price &&
        ((msg = "가격 입력해주세요"), (err = false), this.$refs.price.focus());
      err &&
        !this.content &&
        ((msg = "내용 입력해주세요"),
        (err = false),
        this.$refs.content.focus());

      if (!err) alert(msg);
      // 만약, 내용이 다 입력되어 있다면 registBook 호출
      else this.registBook();
    },

    registBook() {
      fetch("http://localhost:9999/vuews/book", {
        method: "POST",

        body: JSON.stringify({
          isbn: this.isbn,
          title: this.title,
          author: this.author,
          price: this.price,
          content: this.content,
        }),

        headers: {
          "Content-Type": "application/json",
        },
      });
      alert("도서 등록 성공!");
      this.$router.push({ path: "/" });
    },
    moveList() {
      location.href = "/";
    },
  },
};
</script>

<style></style>
