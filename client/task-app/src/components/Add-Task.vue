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
            <form>
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
                <label for="descInput">Description</label>
                <textarea
                  v-model="currentTask.description"
                  type="text"
                  class="form-control"
                  id="descInput"
                  placeholder="Check the new..."
                />
              </div>
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
                  type="text"
                  class="form-control"
                  id="contactInput"
                  placeholder="Mustermann "
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
            </form>
          </div>
          <div class="modal-footer">
            <button
              type="button"
              data-dismiss="modal"
              class="btn btn-secondary"
            >
              Close
            </button>
            <button v-on:click="save" type="button" class="btn btn-primary">Save changes</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>


export default {
  name: "Add-Task",
  props: {},
  data() {
    return {
      currentTask: {
        title: "",
        status: "",
        date: "",
        contact: { email: "" },
        reference: { url: "" },
      },
    };
  },
  methods: {
    save() {
      this.$emit("saved");
    },
  },
};
</script>


