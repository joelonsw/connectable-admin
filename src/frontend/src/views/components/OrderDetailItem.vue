<template>
  <tr class="onHover" @click="showDetailItem()">
    <td>
      <div class="d-flex flex-column justify-content-center">
        <h6 class="m-1 text-sm">{{ id }}</h6>
      </div>
    </td>
    <td>
      <div class="d-flex flex-column justify-content-center">
        <h6 class="mb-0 text-sm">{{ orderId }}</h6>
      </div>
    </td>
    <td>
      <div class="d-flex flex-column justify-content-center">
        <h6 class="mb-0 text-sm">{{ ticketId }}</h6>
      </div>
    </td>
    <td>
      <div class="d-flex flex-column justify-content-center">
        <h6 class="mb-0 text-sm">{{ orderStatus }}</h6>
      </div>
    </td>
    <td>
      <div class="d-flex flex-column justify-content-center">
        <h6 class="mb-0 text-sm">{{ txHash }}</h6>
      </div>
    </td>
    <td>
      <div class="d-flex flex-column justify-content-center">
        <h6 class="mb-0 text-sm">{{ date }}</h6>
      </div>
    </td>
  </tr>
  <order-detail-item-detail
    @detail-updated="this.$emit('item-updated')"
    @detail-modal-close="showDetail = false"
    :orderDetail="orderDetail"
    v-if="showDetail"
  />
</template>

<script>
import OrderDetailItemDetail from "./OrderDetailItemDetail.vue";

export default {
  name: "order-detail-item",
  components: {
    OrderDetailItemDetail,
  },
  props: {
    orderDetail: Object,
  },
  data() {
    return {
      id: this.orderDetail.id,
      orderId: this.orderDetail.orderId,
      ticketId: this.orderDetail.ticketId,
      orderStatus: this.orderDetail.orderStatus,
      txHash: this.orderDetail.txHash,
      date: new Date(this.orderDetail.createdDate),
      showDetail: false,
    };
  },
  methods: {
    showDetailItem() {
      this.showDetail = true;
    },
  },
};
</script>

<style scoped>
.onHover:hover {
  cursor: pointer;
  background-color: ghostwhite;
}
</style>
