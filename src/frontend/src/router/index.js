import { createRouter, createWebHistory } from "vue-router";
import OrderDetails from "@/views/OrderDetails.vue";
import Login from "@/views/Login.vue";
import Events from "@/views/Events.vue";
import createStore from "../store/index.js";

const routes = [
  {
    path: "/",
    name: "/",
    component: Login,
  },
  {
    path: "/orders",
    name: "Order Details",
    component: OrderDetails,
    beforeEnter: () => {
      if (createStore.state.loginStatus == false) {
        return "/";
      }
    },
  },
  {
    path: "/events",
    name: "Events",
    component: Events,
    beforeEnter: () => {
      if (createStore.state.loginStatus == false) {
        return "/";
      }
    },
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
  linkActiveClass: "active",
});

export default router;
