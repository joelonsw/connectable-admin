<template>
  <div class="detailModal">
    <vsud-button
      class="my-4 m-2"
      variant="gradient"
      color="light"
      @click="this.$emit('detail-modal-close')"
      >❌
    </vsud-button>
    <div>
      <div class="p-3 pb-0 card-header">
        <h6>[주문 정보]</h6>
        <p>주문자 이름 : {{ order.ordererName }}</p>
        <p>주문자 번호 : {{ order.ordererPhoneNumber }}</p>
        <p>주문 상태 : {{ orderStatus }}</p>
        <p>주문 날짜 : {{ date }}</p>
        <p>주문 트랜잭션 : {{ txHash }}</p>
      </div>
      <div class="p-3 pb-0 card-header">
        <h6>[유저 정보]</h6>
        <vsud-button
          variant="gradient"
          color="dark"
          v-if="!userInfo"
          @click="getUserInfo"
        >
          유저 정보 확인
        </vsud-button>
        <p v-if="userInfo">유저 닉네임 : {{ nickname }}</p>
        <p v-if="userInfo">유저 번호 : {{ phoneNumber }}</p>
        <p v-if="userInfo">유저 클레이튼 주소 : {{ klaytnAddress }}</p>
      </div>
      <div class="p-3 pb-0 card-header">
        <h6>[티켓 정보]</h6>
        <vsud-button
          variant="gradient"
          color="dark"
          v-if="!ticketInfo"
          @click="getTicketInfo"
        >
          티켓 정보 확인
        </vsud-button>
        <p v-if="ticketInfo">티켓 Id : {{ ticketJson.id }}</p>
        <p v-if="ticketInfo">티켓 가격 : {{ ticketJson.price }}</p>
        <p v-if="ticketInfo">
          티켓 판매 상태 : {{ ticketJson.ticketSalesStatus }}
        </p>
        <p v-if="ticketInfo">토큰 Id : {{ ticketJson.tokenId }}</p>
        <p v-if="ticketInfo">토큰 URI : {{ ticketJson.tokenUri }}</p>
        <p v-if="ticketInfo">토큰 메타데이터 : {{ ticketJson.metadata }}</p>
        <p v-if="ticketInfo">이벤트 Id : {{ ticketJson.eventId }}</p>
      </div>
      <hr />
      <div class="buttons">
        <vsud-button
          class="my-4 m-2"
          variant="gradient"
          color="info"
          @click="depositConfirm"
          v-if="orderStatus === 'REQUESTED'"
          >입금 확인
        </vsud-button>
        <vsud-button
          class="my-4 m-2"
          variant="gradient"
          color="primary"
          @click="depositFail"
          v-if="orderStatus === 'REQUESTED'"
          >입금 안 됨
        </vsud-button>
        <vsud-button
          class="my-4 m-2"
          variant="gradient"
          color="warning"
          @click="refund"
          v-if="orderStatus === 'REQUESTED'"
          >환불 처리
        </vsud-button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import createStore from "../../store/index.js";
import VsudButton from "@/components/VsudButton.vue";

export default {
  name: "order-detail-item-detail",
  props: {
    orderDetail: Object,
  },
  components: {
    VsudButton,
  },
  data() {
    return {
      id: this.orderDetail.id,
      order: this.orderDetail.order,
      ticketId: this.orderDetail.ticketId,
      orderStatus: this.orderDetail.orderStatus,
      txHash: this.orderDetail.txHash,
      date: new Date(this.orderDetail.createdDate),
      userInfo: false,
      nickname: "",
      phoneNumber: "",
      klaytnAddress: "",
      ticketInfo: false,
      ticketJson: "",
    };
  },
  methods: {
    getUserInfo() {
      axios
        .get("/users/" + this.order.userId, {
          headers: {
            Authorization: "Bearer " + createStore.state.adminToken,
          },
        })
        .then((value) => {
          this.nickname = value.data.nickname;
          this.phoneNumber = value.data.phoneNumber;
          this.klaytnAddress = value.data.klaytnAddress;
          this.userInfo = true;
        });
    },

    getTicketInfo() {
      axios
        .get("/tickets/" + this.ticketId, {
          headers: {
            Authorization: "Bearer " + createStore.state.adminToken,
          },
        })
        .then((value) => {
          this.ticketJson = value.data;
          this.ticketInfo = true;
        });
    },

    depositConfirm() {
      if (confirm("입금이 되어 PAID로 상태를 변경합니다.")) {
        axios
          .patch(
            createStore.state.backendUrl +
              "/admin/order-details/" +
              this.id +
              "/paid",
            {},
            {
              headers: {
                Authorization: "Bearer " + createStore.state.adminToken,
              },
            }
          )
          .then(() => {
            this.$emit("detail-updated");
          });
      }
    },

    depositFail() {
      if (confirm("입금이 되지 않아 UNPAID로 상태를 변경합니다.")) {
        axios
          .patch(
            createStore.state.backendUrl +
              "/admin/order-details/" +
              this.id +
              "/unpaid",
            {},
            {
              headers: {
                Authorization: "Bearer " + createStore.state.adminToken,
              },
            }
          )
          .then(() => {
            this.$emit("detail-updated");
          });
      }
    },

    refund() {
      if (confirm("이미 판매된 티켓이라 REFUND로 상태를 변경합니다.")) {
        axios
          .patch(
            createStore.state.backendUrl +
              "/admin/order-details/" +
              this.id +
              "/refund",
            {},
            {
              headers: {
                Authorization: "Bearer " + createStore.state.adminToken,
              },
            }
          )
          .then(() => {
            this.$emit("detail-updated");
          });
      }
    },
  },
};
</script>

<style>
.detailModal {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 100;
  border-radius: 10px;
  padding: 40px;
  width: 55%;
  height: 85%;
  overflow: hidden;
  overflow-y: scroll;
  border: 1px solid darkgray;
  box-shadow: 5px 5px 5px;
  background-color: white;
}
</style>
