<template>
  <div id="app" class="container">
    <Main msg="Welcome to Your Vue.js App" />
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
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  padding: 10px;
}
</style>
