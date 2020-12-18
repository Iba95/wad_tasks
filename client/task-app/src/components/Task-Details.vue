<template>
  <div id="task-details">
    <div class="card fixed-top" style="width: 18rem">
      <div class="card-body">
        <h5 class="card-title row justify-content-center">{{ currentTask.title }}</h5>

        <h6 class="card-subtitle mb-2 text-muted row justify-content-center">
          {{ currentTask.description }}
        </h6>

        <div>
          <hr />
          <p>{{ currentTask.longDescription }}</p>
          <hr />
        </div>

        <div class="row justify-content-center mb-2">
          <Status :status="currentTask.status.status" />
        </div>
        <div class=" mb-2 bg-gray-50">
          Due at: {{ currentTask.date }}
        </div>
        <div class=" mb-2">
          Contact: {{ currentTask.contact.email }}
        </div>

        <div class=" mb-2 bg-gray-50">
          Reference:
          <a v-bind:href="currentTask.reference.url" class="card-link pl-1">
            {{ currentTask.reference.url }}</a
          >
        </div>
        <div class="row justify-content-center mt-3">
          <button v-on:click="close" type="button" class="btn btn-light">
            <i class="bi-x" style="font-size: 2rem; color: black"></i>
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Status from "./Status.vue";
export default {
  components: { Status },
  name: "Task-Details",
  props: {
    currentTask: {},
  },
  methods: {
    close() {
      this.$emit("clicked");
    },
  },
};
</script>

<style scoped>
.card {
  margin-left: auto;
  margin-right: auto;
  margin-top: 20px;
  width: 500px !important;
  text-align: left;
}
</style>


