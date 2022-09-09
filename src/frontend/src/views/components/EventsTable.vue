<template>
  <div class="card">
    <div class="card-header mt-3 pb-0 table-header">
      <h6>이벤트 상세</h6>
      <vsud-button
        class="my-4 m-2"
        variant="gradient"
        color="primary"
        @click="registerEvent"
        >이벤트 등록
      </vsud-button>
    </div>
    <event-register v-if="eventRegister" @new-registered="registerEvent()" />
    <div class="card-body px-0 pt-1 pb-2" v-if="!eventRegister">
      <div class="table-responsive p-1">
        <table class="table align-items-center mb-0" v-if="showTableItem">
          <thead>
            <tr>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                Id
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                Event Name
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                Description
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                Contract Address
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                Contract Name
              </th>
            </tr>
          </thead>
          <tbody>
            <event-item
              v-for="event in allEvents"
              :key="event"
              :event="event"
            />
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
import EventItem from "./EventItem.vue";
import { ref, onMounted } from "vue";
import axios from "axios";
import createStore from "../../store/index.js";
import VsudButton from "@/components/VsudButton.vue";
import EventRegister from "./EventRegister.vue";

export default {
  name: "events-table",
  components: {
    EventItem,
    VsudButton,
    EventRegister,
  },
  setup() {
    let allEvents = ref([]);
    let allEventsOriginal = ref([]);

    function search(e) {
      let searchWord = e.target.value;
      let result = allEventsOriginal.value.filter((vcData) => {
        return vcData.name.toLowerCase().includes(searchWord.toLowerCase());
      });
      this.allEvents = [...result];
    }

    function getEvents() {
      axios
        .get("/events", {
          headers: {
            Authorization: "Bearer " + createStore.state.adminToken,
          },
        })
        .then((response) => {
          allEvents.value = response.data;
          allEventsOriginal.value = [...response.data];
        })
        .catch((response) => alert(response));
    }

    onMounted(() => {
      getEvents();
    });

    return { allEvents, getEvents, search };
  },
  data() {
    return {
      showTableItem: true,
      eventRegister: false,
    };
  },
  methods: {
    showListView() {
      this.showTableItem = true;
      this.getEvents();
    },
    registerEvent() {
      this.eventRegister = !this.eventRegister;
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
