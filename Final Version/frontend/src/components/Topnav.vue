<template>
  <div class="Topnav">
    <ul class="leftmenu">
      <li class="menulist"> <router-link to="/Home" class="tab">首页</router-link></li>
      <li class="menulist"><router-link to="/Menu" class="tab">图书浏览</router-link></li>
      <li class="menulist"><router-link to="/Cart" class="tab">购物车</router-link></li>
      <li class="menulist"> <router-link to="/Management" class="tab">订单管理</router-link></li>
      <li class="menulist"> <router-link to="/Login" class="tab">登录/注册</router-link></li>
    </ul>
  </div>
</template>

<script>
    export default {
        name: "Topnav"
    }
</script>

<style scoped>

</style>
