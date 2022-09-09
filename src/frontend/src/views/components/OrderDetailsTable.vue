<template>
  <div class="card">
    <div class="card-header mt-3 pb-0 table-header">
      <h6>주문 상세</h6>
    </div>
    <div class="card-body px-0 pt-1 pb-2">
      <div class="table-responsive p-1">
        <table class="table align-items-center mb-0" v-if="showTableItem">
          <thead>
            <tr>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                Order Detail Id
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                Order Id
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                Ticket Id
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                결제 Status
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                Tx Hash
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                Date
              </th>
            </tr>
          </thead>
          <tbody>
            <order-detail-item
              @item-updated="showListView()"
              v-for="orderDetail in allOrderDetails"
              :key="orderDetail"
              :orderDetail="orderDetail"
            />
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
import OrderDetailItem from "./OrderDetailItem.vue";
import { ref, onMounted } from "vue";
import axios from "axios";
import createStore from "../../store/index.js";

export default {
  name: "order-details-table",
  components: {
    OrderDetailItem,
  },
  setup() {
    let allOrderDetails = ref([]);
    let allOrderDetailsOriginal = ref([]);

    function search(e) {
      let searchWord = e.target.value;
      let result = allOrderDetailsOriginal.value.filter((vcData) => {
        return vcData.name.toLowerCase().includes(searchWord.toLowerCase());
      });
      this.allOrderDetails = [...result];
    }

    function getOrderDetails() {
      axios
        .get("/order-details", {
          headers: {
            Authorization: "Bearer " + createStore.state.adminToken,
          },
        })
        .then((response) => {
          allOrderDetails.value = response.data;
          allOrderDetailsOriginal.value = [...response.data];
        })
        .catch((response) => alert(response));
    }

    onMounted(() => {
      getOrderDetails();
    });

    return { allOrderDetails, getOrderDetails, search };
  },
  data() {
    return {
      showTableItem: true,
    };
  },
  methods: {
    showListView() {
      this.showTableItem = true;
      this.getOrderDetails();
    },
  },
};
</script>

<style scoped>
.table-header {
  display: flex;
  align-items: baseline;
  justify-content: space-around;
  padding-bottom: 1rem !important;
  padding-top: 0.5rem !important;
}
</style>
