<template>
  <tr class="onHover" @click="showDetailItem()">
    <td>
      <div class="d-flex flex-column justify-content-center">
        <h6 class="m-1 text-sm">{{ id }}</h6>
      </div>
    </td>
    <td>
      <div class="d-flex flex-column justify-content-center">
        <h6 class="mb-0 text-sm">{{ eventName }}</h6>
      </div>
    </td>
    <td>
      <div class="d-flex flex-column justify-content-center">
        <h6 class="mb-0 text-sm">{{ description }}</h6>
      </div>
    </td>
    <td>
      <div class="d-flex flex-column justify-content-center">
        <h6 class="mb-0 text-sm">{{ contractAddress }}</h6>
      </div>
    </td>
    <td>
      <div class="d-flex flex-column justify-content-center">
        <h6 class="mb-0 text-sm">{{ contractName }}</h6>
      </div>
    </td>
    <vsud-button
      class="m-2"
      variant="gradient"
      color="info"
      @click="showMintToken"
      >토큰(티켓) 발행
    </vsud-button>
  </tr>
  <div class="p-5 minting-box" v-if="mintTokenOption">
    <span>contractAddress</span>
    <h6 class="mb-0 text-sm">{{ contractAddress }}</h6>
    <span>startTokenId</span>
    <input type="text" class="mb-3 form-control" v-model="startTokenId" />
    <span>endTokenId</span>
    <input type="text" class="mb-3 form-control" v-model="endTokenId" />
    <span>tokenUri</span>
    <input type="text" class="mb-3 form-control" v-model="tokenUri" />
    <span>price</span>
    <input type="text" class="mb-3 form-control" v-model="price" />
    <div class="buttons p-5">
      <vsud-button variant="gradient" color="dark" @click="mintToken"
        >토큰 발행하기
      </vsud-button>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import createStore from "../../store/index.js";
import VsudButton from "@/components/VsudButton.vue";

export default {
  name: "event-item",
  components: {
    VsudButton,
  },
  props: {
    event: Object,
  },
  data() {
    return {
      id: this.event.id,
      eventName: this.shorten(this.event.eventName),
      description: this.shorten(this.event.description),
      contractAddress: this.event.contractAddress,
      contractName: this.event.contractName,
      mintTokenOption: false,
      startTokenId: "",
      endTokenId: "",
      tokenUri: "",
      price: "",
    };
  },
  methods: {
    shorten(text) {
      let textMaxLength = 25;
      if (text.length > textMaxLength) {
        return text.substring(0, textMaxLength) + "...";
      }
      return text;
    },
    showMintToken() {
      this.mintTokenOption = !this.mintTokenOption;
    },
    mintToken() {
      if (confirm(this.contractAddress + " 토큰을 민팅합니까?")) {
        let data = {
          contractAddress: this.contractAddress,
          startTokenId: this.startTokenId,
          endTokenId: this.endTokenId,
          tokenUri: this.tokenUri,
          price: this.price,
        };
        axios
          .post(
            createStore.state.backendUrl + "/admin/mint-tokens/",
            JSON.stringify(data),
            {
              headers: {
                Authorization: "Bearer " + createStore.state.adminToken,
                "Content-Type": `application/json`,
              },
            }
          )
          .then(() => {
            alert(this.contractAddress + " 토큰 발행 완료");
            this.showMintToken();
          });
      }
    },
  },
};
</script>

<style scoped>
.onHover:hover {
  cursor: pointer;
  background-color: ghostwhite;
}

.minting-box {
  border: 2px solid grey;
}
</style>
