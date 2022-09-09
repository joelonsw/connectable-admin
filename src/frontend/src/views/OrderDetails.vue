<template>
  <div class="py-4 container-fluid">
    <div class="row">
      <div class="col-12">
        <order-details-table />
      </div>
    </div>
  </div>
</template>

<script>
import OrderDetailsTable from "./components/OrderDetailsTable.vue";

export default {
  name: "order-details",
  components: {
    OrderDetailsTable,
  },
};
</script>
