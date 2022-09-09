<template>
  <div class="card h-100">
    <div class="p-5 pb-0 w-50 card-header">
      <span>contractName</span>
      <input
        type="text"
        class="mb-3 form-control"
        v-model="contractName"
        placeholder="알파벳, 숫자, 하이픈 허용"
      />
      <span>contractSymbol</span>
      <input
        type="text"
        class="mb-3 form-control"
        v-model="contractSymbol"
        placeholder="대문자 3-4개"
      />
      <span>contractAlias</span>
      <input
        type="text"
        class="mb-3 form-control"
        v-model="contractAlias"
        placeholder="알파벳 소문자, 숫자, 하이픈 허용. 첫 문자는 알파벳 소문자로"
      />
      <hr />
      <hr />
      <span>EventName</span>
      <input type="text" class="mb-3 form-control" v-model="eventName" />
      <span>EventDescription</span>
      <input type="text" class="mb-3 form-control" v-model="eventDescription" />
      <span>eventImage</span>
      <input type="text" class="mb-3 form-control" v-model="eventImage" />
      <span>eventTwitterUrl</span>
      <input type="text" class="mb-3 form-control" v-model="eventTwitterUrl" />
      <span>eventInstagramUrl</span>
      <input
        type="text"
        class="mb-3 form-control"
        v-model="eventInstagramUrl"
      />
      <span>eventWebpageUrl</span>
      <input type="text" class="mb-3 form-control" v-model="eventWebpageUrl" />
      <span>eventLocation</span>
      <input type="text" class="mb-3 form-control" v-model="eventLocation" />
      <span>eventArtistId</span>
      <input type="text" class="mb-3 form-control" v-model="eventArtistId" />
      <span>eventSalesFrom</span>
      <input
        type="text"
        class="mb-3 form-control"
        v-model="eventSalesFrom"
        placeholder="2022-08-31T00:00:00 형식"
      />
      <span>eventSalesTo</span>
      <input
        type="text"
        class="mb-3 form-control"
        v-model="eventSalesTo"
        placeholder="2022-08-31T00:00:00 형식"
      />
      <span>eventStartTime</span>
      <input
        type="text"
        class="mb-3 form-control"
        v-model="eventStartTime"
        placeholder="2022-08-31T00:00:00 형식"
      />
      <span>eventEndTime</span>
      <input
        type="text"
        class="mb-3 form-control"
        v-model="eventEndTime"
        placeholder="2022-08-31T00:00:00 형식"
      />
    </div>
    <div class="buttons p-5">
      <vsud-button variant="gradient" color="dark" @click="registerEvent"
        >개별 프로젝트 등록
      </vsud-button>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import createStore from "../../store/index.js";
import VsudButton from "@/components/VsudButton.vue";
export default {
  name: "event-register",
  components: {
    VsudButton,
  },
  data() {
    return {
      contractName: "",
      contractSymbol: "",
      contractAlias: "",
      eventName: "",
      eventDescription: "",
      eventImage: "",
      eventTwitterUrl: "",
      eventInstagramUrl: "",
      eventWebpageUrl: "",
      eventLocation: "",
      eventArtistId: "",
      eventSalesFrom: "",
      eventSalesTo: "",
      eventStartTime: "",
      eventEndTime: "",
    };
  },
  methods: {
    registerEvent() {
      if (confirm(this.contractName + " 이벤트를 등록합니까?")) {
        let data = {
          contractName: this.contractName,
          contractSymbol: this.contractSymbol,
          contractAlias: this.contractAlias,
          eventName: this.eventName,
          eventDescription: this.eventDescription,
          eventImage: this.eventImage,
          eventTwitterUrl: this.eventTwitterUrl,
          eventInstagramUrl: this.eventInstagramUrl,
          eventWebpageUrl: this.eventWebpageUrl,
          eventLocation: this.eventLocation,
          eventArtistId: this.eventArtistId,
          eventSalesFrom: this.eventSalesFrom,
          eventSalesTo: this.eventSalesTo,
          eventStartTime: this.eventStartTime,
          eventEndTime: this.eventEndTime,
        };
        axios
          .post(
            createStore.state.backendUrl + "/admin/deploy-event/",
            JSON.stringify(data),
            {
              headers: {
                Authorization: "Bearer " + createStore.state.adminToken,
                "Content-Type": `application/json`,
              },
            }
          )
          .then(() => {
            alert(this.contractName + " 프로젝트가 등록되었습니다.");
            this.$emit("new-registered");
          });
      }
    },
  },
};
</script>
