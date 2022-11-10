<template>
  <div class="regist">
    <h1 class="underline">SSAFY 글 상세보기</h1>
    <div class="regist_form">
      <label> 글번호</label>
      <div class="view">{{ article.articleno }}</div>
      <label> 글제목</label>
      <div class="view">{{ article.subject }}</div>
      <label> 작성자</label>
      <div class="view">{{ article.userid }}</div>
      <label> 조회수</label>
      <div class="view">{{ article.hit }}</div>
      <label> 작성시간</label>
      <div class="view">{{ article.regtime }}</div>
      <label> 내용</label>
      <div class="view">{{ article.content }}</div>

      <div style="padding-top: 15px">
        <router-link :to="{ name: 'boardmodify', params: { articleno: article.articleno } }" class="btn"
          >수정
        </router-link>
        <router-link :to="{ name: 'boarddelete', params: { articleno: article.articleno } }" class="btn"
          >삭제
        </router-link>
        <router-link to="/board/list" class="btn">목록</router-link>
      </div>
    </div>
  </div>
</template>

<script>
import http from "@/util/http-common";
export default {
  name: "BoardView",
  data() {
    return {
      article: Object,
    };
  },
  created() {
    // 비동기
    // TODO : 글번호에 해당하는 글정보 얻기.
    http.get(`/board/${this.$route.params.articleno}`).then(({ data }) => {
      this.article = data;
    });
  },
};
</script>

<style></style>
