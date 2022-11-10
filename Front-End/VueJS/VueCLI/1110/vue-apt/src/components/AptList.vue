<template>
  <div>
    <h2>아파트 목록</h2>
    <input type="number" v-model="lawdCd" />
    <input type="number" v-model="dealYmd" />
    <button @click="getAptList">아파트 목록 얻기</button>
    <table>
      <colgroup>
        <col style="width: 10%" />
        <col style="width: 30%" />
        <col style="width: 20%" />
        <col style="width: 10%" />
        <col style="width: 30%" />
      </colgroup>
      <tr>
        <td>일련번호</td>
        <td>아파트 명</td>
        <td>법정동</td>
        <td>층</td>
        <td>매매가격</td>
      </tr>
      <tbody>
        <apt-list-item v-for="(apt, index) in apts" :key="index" :apt="apt"></apt-list-item>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from "axios";
import AptListItem from "@/components/AptListItem.vue";

export default {
  name: "AptList",
  components: {
    AptListItem,
  },
  data() {
    return {
      lawdCd: "",
      dealYmd: "",
      apts: [],
    };
  },
  methods: {
    getAptList() {
      //   const serviceKey =
      //     "fz6dMFbEunwMw6sjvR6lyfVvs9bn55sVzz2jLaGUd3Dxd2wxQoe4SxxlFoevqNMO%2FVUDszqwdFZhqq2Jzgdg%2Bw%3D%3D";
      //   const url = `http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev?serviceKey=${serviceKey}&pageNo=1&numOfRows=10&LAWD_CD=${this.lawdCd}&DEAL_YMD=${this.dealYmd}`;
      const url = `http://localhost:9999/vue/map/aptlist/${this.lawdCd}/${this.dealYmd}`;
      axios.get(url).then((response) => (this.apts = response.data.response.body.items.item));
    },
  },
};
</script>

<style>
td {
  border-bottom: 1px solid black;
}
</style>
