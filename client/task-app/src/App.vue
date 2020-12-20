<template>
  <div id="app" class="container">
    <h1 class="mb-6">Winner Winner Tasking Dinner</h1>
    <Main />
  </div>
</template>

<script>
import Main from "./components/Main.vue";
import "./assets/css/tailwind.css";

export default {
  name: "App",
  components: {
    Main,
  },
};
</script>

<style>
#app {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  padding: 10px;
  padding-top: 30px;
}
button:focus {
  outline: 1px dotted;
  outline: none !important;
}
</style>
