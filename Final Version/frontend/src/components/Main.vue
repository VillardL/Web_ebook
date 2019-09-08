<template>
<div>
      <div class="Topnav">
        <ul class="leftmenu">
      <li class="menulist"> <router-link to="/userm" class="tab">用户管理</router-link></li>
      <li class="menulist"><router-link to="/bookm" class="tab">图书管理</router-link></li>
      <li class="menulist"> <router-link to="/orderm" class="tab">订单管理</router-link></li>
          <li class="menulist"> <router-link to="/Login" class="tab">退出管理员身份</router-link></li>
        </ul>
      </div>
  <div class="content-body">
      <h3>管理页面</h3>
    </div>
</div>
</template>

<script>
    export default {
        name: "Main"
      //,
      // data() {
      //   var that = this;
      //   this.$axios.get('http://127.0.0.1:8081/showuser',{})
      //     .then(function (response) {
      //       that.list.tableData=response.data;
      //     })
      //     .catch(function (error) {
      //       console.log(error)
      //     })
      //   return {
      //     search: '',
      //     list:{
      //       tableData:[
      //
      //       ]
      //     }
      //   }
      // }
    }
</script>

<style scoped>

</style>
