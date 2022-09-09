<template>
  <div class="container top-0 position-sticky z-index-sticky">
    <div class="row">
      <div class="col-12"></div>
    </div>
  </div>
  <main class="mt-0 main-content main-content-bg">
    <section>
      <div class="page-header min-vh-75">
        <div class="container">
          <div class="row">
            <div class="mx-auto col-xl-4 col-lg-5 col-md-6 d-flex flex-column">
              <div class="mt-8 card card-plain">
                <div class="pb-0 card-header text-start">
                  <h3 class="font-weight-bolder text-info text-gradient">
                    Connectable ADMIN
                  </h3>
                  <p class="mb-0">Connectable 어드민 페이지</p>
                </div>
                <div class="card-body">
                  <select v-model="selectedApi" class="form-select mb-4">
                    <option value="prod">PROD</option>
                  </select>
                  <form
                    @submit.prevent="loginRequest"
                    role="form"
                    class="text-start"
                  >
                    <input
                      v-model="id"
                      placeholder="ID"
                      type="text"
                      class="form-control mb-2"
                    />
                    <input
                      v-model="password"
                      placeholder="PW"
                      type="password"
                      class="form-control"
                      autocomplete="off"
                    />
                    <div class="text-center">
                      <vsud-button
                        class="my-4 mb-2"
                        variant="gradient"
                        color="info"
                        fullWidth
                        >로그인
                      </vsud-button>
                    </div>
                  </form>
                </div>
              </div>
            </div>
            <div class="col-md-6">
              <div
                class="top-0 oblique position-absolute h-100 d-md-block d-none me-n8"
              ></div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </main>

  <div class="loginFailedModal" v-if="loginFailedModalShow == true">
    <h5>ID, PW가 일치하지 않습니다.</h5>
    <p>잠시후에 다시 시도해주세요</p>
    <vsud-button
      @click="loginFailedModalClose"
      class="my-4 mb-2"
      variant="gradient"
      color="info"
      fullWidth
      >확인
    </vsud-button>
  </div>
</template>

<script>
import VsudButton from "@/components/VsudButton.vue";
import axios from "axios";
const body = document.getElementsByTagName("body")[0];

export default {
  name: "login",
  components: {
    VsudButton,
  },
  beforeMount() {
    this.$store.state.showNavbar = false;
    this.$store.state.showSidenav = false;
    body.classList.remove("bg-gray-100");
  },
  beforeUnmount() {
    this.$store.state.showNavbar = true;
    this.$store.state.showSidenav = true;
    body.classList.add("bg-gray-100");
  },
  data() {
    return {
      id: "",
      password: "",
      loginFailedModalShow: false,
      selectedApi: "prod",
    };
  },
  watch: {
    selectedApi() {
      this.$store.commit("changeBackendUrl", this.selectedApi);
    },
  },
  methods: {
    loginRequest() {
      axios
        .post("/login", {
          id: this.id,
          password: this.password,
        })
        .then((result) => {
          let adminToken = result.data.token;
          this.$store.commit("loginAsAdmin", adminToken);
          this.$router.push("/orders");
        })
        .catch(() => {
          this.loginFailed();
        });
    },
    loginFailed() {
      this.loginFailedModalShow = true;
    },
    loginFailedModalClose() {
      this.loginFailedModalShow = false;
    },
  },
};
</script>

<style>
.loginFailedModal {
  position: absolute;
  z-index: 100;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  background-color: lightskyblue;
  border-radius: 10px;
  padding: 30px;
  color: white;
  width: 350px;
}

.loginWindow {
  position: absolute;
  top: 40%;
  left: 50%;
  transform: translate(-50%, -50%);
}
</style>
