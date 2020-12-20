<template>
  <div id="main">
    <transition name="fade">
      <Task-Details
        v-if="showDetails"
        :currentTask="currentTask"
        @clicked="closeDetails"
      />
    </transition>
    <table class="table">
      <thead>
        <tr>
          <th
            v-for="col in columns"
            :key="col"
            scope="col"
            class="cursor-pointer"
            v-on:click="sort(col)"
            v-bind:class="[
              {
                active: correctColNames(col) == currentSort,
                down: down,
                up: up,
              },
            ]"
          >
            {{ col }}
          </th>
          <th scope="col"></th>
          <th scope="col"></th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td v-bind:colspan="columns.length + 2" class="gray-td">
            <button
              data-toggle="modal"
              data-target="#addModal"
              v-on:click="addTask()"
            >
              <i
                class="bi-plus-circle-fill text-indigo-600 hover:text-indigo-700"
                style="font-size: 2.5rem"
              ></i>
            </button>
          </td>
        </tr>
        <tr v-for="element in tasks" :key="element.id">
          <td>
            {{ element.title }}
          </td>
          <td>
            {{ element.description.slice(0, 15) }}...
            <span class="text-blue-400 hover:text-blue-500 cursor-pointer" v-on:click="displayDetails(element)"
              >Show More</span
            >
          </td>
          <td>
            <Status :status="element.status.status" />
          </td>
          <td>{{ element.date }}</td>
          <td>
            <button data-toggle="modal" data-target="#editModal">
              <i
                v-on:click.self="editTask(element)"
                class="bi-pencil-fill text-indigo-600 hover:text-indigo-700"
                style="font-size: 2rem"
              ></i>
            </button>
          </td>
          <td>
            <button v-on:click="deleteTask(element.id)">
              <i
                class="bi-trash text-red-400 hover:text-red-500"
                style="font-size: 2rem"
              ></i>
            </button>
          </td>
        </tr>
      </tbody>
    </table>
    <div v-if="currentTask">
      <EditTask :currentTask="currentTask" @saved="refresh" />
    </div>

    <div v-if="newTask">
      <AddTask @saved="refresh" />
    </div>
  </div>
</template>

<script>
import axios from "axios";
import Status from "./Status.vue";
import EditTask from "./Edit-Task";
import AddTask from "./Add-Task";
import TaskDetails from "./Task-Details.vue";

export default {
  components: { Status, EditTask, AddTask, TaskDetails },
  name: "Main",
  props: {},
  data() {
    return {
      columns: ["Title", "Description", "Status", "Due at"],
      tasks: [],
      currentTask: {},
      modalTitle: "",
      newTask: false,
      showDetails: false,
      currentSort: "",
      currentSortDir: "asc",
      down: false,
      up: false,
    };
  },
  async created() {
    await this.getData();
  },
  methods: {
    async getData() {
      let res = await axios.get("http://localhost:8090/getTasks");
      console.log(res);
      this.tasks = res.data;
      this.sort("date");
    },
    async deleteTask(id) {
      await axios.get(`http://localhost:8090/getTest?id=${id}`);
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
    displayDetails(element) {
      console.log(element);
      this.currentTask = element;
      this.showDetails = true;
    },
    closeDetails() {
      this.currentTask = null;
      this.showDetails = false;
    },
    async refresh() {
      await this.getData();
    },
    sort(s) {
      s = this.correctColNames(s);
      if (s === this.currentSort) {
        this.currentSortDir = this.currentSortDir === "asc" ? "desc" : "asc";
      }
      if (this.currentSortDir == "desc") this.down = true;
      else this.down = false;
      if (this.currentSortDir == "asc") this.up = true;
      else this.up = false;
      this.currentSort = s;
      this.sortedTasks(this.currentSortDir, s);
    },
    sortedTasks(dir, s) {
      this.tasks.sort(function (a, b) {
        if (dir === "desc") {
          if (s == "date") return new Date(a.date) - new Date(b.date);
          else if (s == "status")
            return a.status.status.localeCompare(b.status.status);
          else return ("" + a[s]).localeCompare(b[s]);
        } else {
          if (s == "date") return new Date(b.date) - new Date(a.date);
          else if (s == "status")
            return b.status.status.localeCompare(a.status.status);
          else return ("" + b[s]).localeCompare(a[s]);
        }
      });
    },
    correctColNames(col) {
      switch (col) {
        case "Title":
          return "title";
        case "Status":
          return "status";
        case "Description":
          return "description";
        case "Due at":
          return "date";
      }
    },
  },
};
</script>

<style scoped>
.gray-td {
  background-color: whitesmoke;
  padding: 0;
}
.clickable {
  cursor: pointer;
  color: #0095ff;
}

.active.up::after {
  content: " ";
  position: relative;
  left: 8px;
  top: 15px;
  border: 8px solid transparent;
  border-top-color: silver;
}

.active.down::after {
  content: " ";
  position: relative;
  left: 8px;
  bottom: 12px;
  border: 8px solid transparent;
  border-bottom-color: silver;
}
thead tr {
  border-top: hidden;
}

.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.5s;
}
.fade-enter, .fade-leave-to /* .fade-leave-active below version 2.1.8 */ {
  opacity: 0;
}
</style>

