import Vue from "vue";
import VueRouter from "vue-router";
import Contacts from "@/views/Contacts";
import Modal from "@/components/Modal";
import home from "@/views/home";

Vue.use(VueRouter);

const routes = [

  {
    // path: "/contacts",
    path: "/",
    name: "Contacts",
    component: Contacts,
  },
  {
    path: "/modal",
    name: "Modal",
    component: Modal,
  },
    // 登入畫面未與 spring security 結合
  {
    path: "/login",
    name: "home",
    component: home,
  },
  {
    path: "/about",
    name: "About",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue"),
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
