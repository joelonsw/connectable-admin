import { createStore } from "vuex";

export default createStore({
  state: {
    isTransparent: "",
    isAbsolute: false,
    showNavs: true,
    showSidenav: true,
    showNavbar: true,
    showMain: true,
    loginStatus: false,
    adminToken: "",
    connectedServer: "PROD",
    backendUrl: "https://api.connectable.fans",
  },
  mutations: {
    navbarMinimize(state) {
      const sidenav_show = document.querySelector(".g-sidenav-show");
      const sidenav = document.getElementById("sidenav-main");

      if (sidenav_show.classList.contains("g-sidenav-pinned")) {
        sidenav_show.classList.remove("g-sidenav-pinned");
        setTimeout(function () {
          sidenav.classList.remove("bg-white");
        }, 100);
        sidenav.classList.remove("bg-transparent");
        state.isPinned = true;
      } else {
        sidenav_show.classList.add("g-sidenav-pinned");
        sidenav.classList.add("bg-white");
        sidenav.classList.remove("bg-transparent");
        state.isPinned = false;
      }
    },
    sidebarType(state, payload) {
      state.isTransparent = payload;
    },
    navbarFixed(state) {
      if (state.isNavFixed === false) {
        state.isNavFixed = true;
      } else {
        state.isNavFixed = false;
      }
    },
    loginAsAdmin(state, token) {
      state.loginStatus = true;
      state.adminToken = token;
    },
    changeBackendUrl(state, api) {
      if (api == "prod") {
        state.backendUrl = "https://api.connectable.fans";
        state.connectedServer = "PROD";
      }
    },
  },
  actions: {
    toggleSidebarColor({ commit }, payload) {
      commit("sidebarType", payload);
    },
  },
  getters: {},
});
