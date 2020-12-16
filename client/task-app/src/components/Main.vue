<template>
  <div id="main">
    <!-- <div class="flex flex-col">
      <div class="-my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
        <div class="py-2 align-middle inline-block min-w-full sm:px-6 lg:px-8">
          <div
            class="shadow overflow-hidden border-b border-gray-200 sm:rounded-lg"
          >
            <table v-if="showTable" class="min-w-full divide-y divide-gray-200">
              <thead class="bg-gray-50">
                <tr>
                  <th
                    v-for="col in columns"
                    :key="col"
                    scope="col"
                    class="px-6 py-3 text-xs font-medium text-gray-500 uppercase tracking-wider"
                  >
                    {{ col }}
                  </th>
                  <th scope="col" class="relative px-6 py-3">
                    <span class="sr-only">Edit</span>
                  </th>
                  <th scope="col" class="relative px-6 py-3">
                    <span class="sr-only">Delete</span>
                  </th>
                </tr>
              </thead>
              <tbody class="bg-white divide-y divide-gray-200">
                <tr>
                  <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                    <button>
                      <i
                        class="bi-plus-circle-fill"
                        style="font-size: 2.5rem; color: teal"
                      ></i>
                    </button>
                  </td>
                </tr>
                <tr v-for="element in data" :key="element.id">
                  <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                    {{ element.title }}
                  </td>
                  <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                    {{ element.description }}
                  </td>
                  <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                    <span
                      class="px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-green-100 text-green-800"
                    >
                      {{ element.status.status }}
                    </span>
                  </td>
                  <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                    {{ element.date }}
                  </td>

                  <td
                    class="px-6 py-4 whitespace-nowrap text-right text-sm font-medium"
                  >
                    <a
                      href="#"
                      class="text-indigo-600 hover:text-indigo-900"
                      data-toggle="modal"
                      data-target="#editModal"
                      >Edit</a
                    >
                  </td>

                  <td
                    class="px-6 py-4 whitespace-nowrap text-right text-sm font-medium"
                  >
                    <button>
                      <i class="bi-x" style="font-size: 2rem; color: red"></i>
                    </button>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div> -->

    <table class="table">
      <thead>
        <tr>
          <th v-for="col in columns" :key="col" scope="col">{{ col }}</th>
          <th scope="col"></th>
          <th scope="col"></th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td v-bind:colspan="columns.length + 2" class="gray-td">
            <button
              v-on:click="addTask()"
              data-toggle="modal"
              data-target="#addModal"
            >
              <i
                class="bi-plus-circle-fill"
                style="font-size: 2.5rem; color: teal"
              ></i>
            </button>
          </td>
        </tr>
        <tr v-for="element in tasks" :key="element.id">
          <th>{{ element.title }}</th>
          <th>{{ element.description }}</th>
          <th>
            <Status :status="element.status.status" />
          </th>
          <th>{{ element.date }}</th>
          <td>
            <button
              v-on:click="editTask(element)"
              data-toggle="modal"
              data-target="#editModal"
            >
              <i
                class="bi-pencil-fill"
                style="font-size: 2rem; color: #0095ff"
              ></i>
            </button>
          </td>
          <td>
            <button v-on:click="deleteTask(element.id)">
              <i class="bi-x" style="font-size: 2rem; color: red"></i>
            </button>
          </td>
        </tr>
      </tbody>
    </table>

    <div v-if="currentTask">
      <EditTask :currentTask="currentTask" />
    </div>

    <div v-if="newTask">
      <AddTask />
    </div>
  </div>
</template>

<script>
import axios from "axios";
import Status from "./Status.vue";
import EditTask from "./Edit-Task";
import AddTask from "./Add-Task";

export default {
  components: { Status, EditTask, AddTask },
  name: "Main",
  props: {},
  data() {
    return {
      columns: ["Title", "Description", "Status", "Due at"],
      tasks: [],
      currentTask: {},
      modalTitle: "",
      newTask: false,
    };
  },
  async created() {
    await this.getData();
  },
  methods: {
    async getData() {
      let res = await axios.get("http://localhost:8090/getTasks");
      this.tasks = res.data;
    },
    deleteTask(id) {
      this.tasks = this.tasks.filter((el) => el.id != id);
    },
    editTask(task) {
      this.currentTask = task;
      console.log(this.currentTask);
    },
    addTask() {
      this.currentTask = {};
      this.newTask = true;
      console.log(this.currentTask);
    },
  },
};
</script>

<style scoped>
.gray-td {
  background-color: whitesmoke;
  padding: 0;
}
</style>

