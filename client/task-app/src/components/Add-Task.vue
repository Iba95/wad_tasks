<template>
  <div id="add-task">
    <div
      class="modal fade"
      id="addModal"
      tabindex="-1"
      role="dialog"
      aria-labelledby="addModalLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="addModalLabel">Add Task</h5>
            <button
              type="button"
              class="close"
              data-dismiss="modal"
              aria-label="Close"
            >
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body text-left">
            <form autocomplete="on">
              <div class="form-group">
                <label for="titelInput">Task Title</label>
                <input
                  v-model="currentTask.title"
                  type="text"
                  class="form-control"
                  id="titelInput"
                  placeholder="task 1"
                />
              </div>

              <div class="form-group">
                <label for="selectStatus">Status</label>
                <select
                  v-model="currentTask.status.status"
                  class="form-control"
                  id="selectStatus"
                >
                  <option>Doing</option>
                  <option>Idea</option>
                  <option>In Review</option>
                  <option>ToDo Next</option>
                  <option>Done</option>
                </select>
              </div>
              <div class="form-group">
                <label for="descInput">Description</label>
                <textarea
                  v-model="currentTask.description"
                  type="text"
                  class="form-control"
                  id="descInput"
                  placeholder="Check the new..."
                />
              </div>
              <!-- <div class="form-group">
                <label for="longDescInput">Long Description</label>
                <textarea
                  v-model="currentTask.longDescription"
                  type="text"
                  class="form-control"
                  id="longDescInput"
                  placeholder="So in Detail we have...."
                />
              </div> -->
              <div class="form-group">
                <label for="dateInput">Due til</label>
                <input
                  v-model="currentTask.date"
                  type="text"
                  class="form-control"
                  id="dateInput"
                  placeholder="YYYY-MM-DD HH:MM:SS"
                />
              </div>
              <div class="form-group">
                <label for="contactInput">Contact</label>
                <input
                  v-model="currentTask.contact.email"
                  type="email"
                  class="form-control"
                  id="contactInput"
                  placeholder="max@example.com"
                />
              </div>
              <div class="form-group">
                <label for="referenceInput">Reference</label>
                <input
                  v-model="currentTask.reference.url"
                  type="text"
                  class="form-control"
                  id="referenceInput"
                  placeholder="url"
                />
              </div>
              <div v-if="currentTask.reference" class="form-group">
                <label for="select">Reference Type</label>
                <select
                  v-model="currentTask.reference.type"
                  class="form-control"
                  id="select"
                >
                  <option>document</option>
                  <option>paper</option>
                  <option>reference</option>
                </select>
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <button
              type="button"
              data-dismiss="modal"
              class="btn btn-light rounded-md border border-gray-300"
            >
              Close
            </button>
            <button
              v-on:click="save"
              type="submit"
              class="inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"
            >
              Save changes
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "Add-Task",
  props: {},
  data() {
    return {
      currentTask: {
        title: "",
        status: { status: "" },
        description: "",
        date: new Date(),
        contact: { email: "" },
        reference: { url: "", type: "" },
      },
    };
  },
  methods: {
    async save() {
      try {
        await axios.post("http://localhost:8090/addTask", this.currentTask);
        this.emitEvent();
      } catch (error) {
        console.log(error);
      }
    },
    emitEvent() {
      this.$emit("saved");
    },
  },
};
</script>

<style>
.modal-footer {
  border-top: 0 !important;
  background-color: #f3f3f3;
}
.modal-header {
  border-bottom: 0 !important;
}
.modal-content {
  border: 0 !important;
}
</style>


