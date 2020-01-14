<template>
  <div id="app">
    <index-collapse></index-collapse>
    <router-view />
  </div>
</template>

<script>
import IndexCollapse from './components/collapse/app/MainCollapse'
export default {
  name: 'App',
  components: { IndexCollapse }
}
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  /* margin-top: 60px; */
}
</style>
