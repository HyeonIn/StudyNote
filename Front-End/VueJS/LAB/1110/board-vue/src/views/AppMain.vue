<template>
  <div class="main">
    <main-content1 class="main-content" :map-info="mapInfo"></main-content1>
    <main-content2 class="main-content" :attraction-info="attractionInfo"></main-content2>
    <main-content3 class="main-content" :plan-info="planInfo"></main-content3>
  </div>
</template>

<script>
import MainContent1 from "@/components/main/MainContent1";
import MainContent2 from "@/components/main/MainContent2";
import MainContent3 from "@/components/main/MainContent3";

export default {
  name: "AppMain",
  components: {
    MainContent1,
    MainContent2,
    MainContent3,
  },
  data() {
    return {
      mapInfo: "지도를 출력할 예정입니다.",
      attractionInfo: "관광지 목록을 출력 할 예정입니다.",
      planInfo: "여행 계획을 출력 할 예정입니다.",
    };
  },
};
</script>

<style scope>
.main-content {
  border: 2px solid black;
  height: 200px;
  width: 80%;
  margin: auto;
  margin-top: 20px;
}
</style>
