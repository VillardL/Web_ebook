<template>
  <div id="app">
    <div class="nav-header">
      <h1>E-BOOK</h1></div>
    <div class="header">
      <div class="header-content clearfix">
        <div class="header-left"></div>
        <div class="header-right"></div>
      </div>
    </div>
 <Topnav></Topnav>
    <router-view/>
  </div>
</template>

<script>
  import Topnav from "./components/Topnav";
export default {
  name: 'App',
  components:
    {
      Topnav
    }
}
</script>

<style>
  @import "css/blue.css";
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
