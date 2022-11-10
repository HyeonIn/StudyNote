<template>
  <tr>
    <td>{{ article.articleno }}</td>
    <td>
      <router-link :to="`/board/view/${article.articleno}`">
        {{ article.subject }}
      </router-link>
    </td>
    <td>{{ article.userid }}</td>
    <td>{{ article.hit }}</td>
    <td>{{ article.regtime }}</td>
  </tr>
</template>

<script>
export default {
  name: "BoardListItem",
  props: {
    article: Object,
  },
};
</script>

<style></style>
