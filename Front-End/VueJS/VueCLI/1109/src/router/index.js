import Vue from "vue";
import VueRouter from "vue-router";
import BookList from "@/views/BookList";
import BookCreate from "@/views/BookCreate";
import BookView from "@/views/BookView";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "list",
    component: BookList,
  },
  {
    path: "/create",
    name: "create",
    component: BookCreate,
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
  },
  {
    path: "/view/:isbn",
    name: "view",
    component: BookView,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
