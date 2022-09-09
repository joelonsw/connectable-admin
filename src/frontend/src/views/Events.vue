<template>
  <div class="py-4 container-fluid">
    <div class="row">
      <div class="col-12">
        <events-table />
      </div>
    </div>
  </div>
</template>

<script>
import EventsTable from "./components/EventsTable.vue";

export default {
  name: "events",
  components: {
    EventsTable,
  },
};
</script>
