<template>
  <aside
    class="my-3 overflow-auto border-0 sidenav navbar navbar-vertical navbar-expand-xs border-radius-xl ms-3"
    id="sidenav-main"
  >
    <div class="sidenav-header">
      <i
        class="top-0 p-3 cursor-pointer fas fa-times text-secondary opacity-5 position-absolute end-0 d-none d-xl-none"
        aria-hidden="true"
        id="iconSidenav"
      ></i>
      <a class="mb-2 navbar-brand" href="/">
        <h6>Connectable 어드민</h6>
        <h6>[ {{ this.$store.state.connectedServer }} ]</h6>
      </a>
    </div>
    <hr class="mt-3 horizontal dark" />
    <sidenav-list :cardBg="custom_class" />
  </aside>
</template>
<script>
import SidenavList from "./SidenavList.vue";
import logo from "@/assets/img/logo.png";

export default {
  name: "index",
  components: {
    SidenavList,
  },
  data() {
    return {
      logo,
    };
  },
  props: ["custom_class"],
};
</script>

<style scoped>
.logoImage {
  max-height: 2em !important;
}
</style>
