<template>
<div class="content-body">
    <h3>欢迎 {{name}}</h3>
    <a href="#" @click="quit">注销登录</a>
    <div class="page-header">
      <h2>热销书目推荐</h2>
    </div>
    <div class="row">

      <div class="mainfavor">
        <div class="thumbnail" style="display:inline-block;height: 360px;">

            <img class="lazy" :src="ppp" width="210" height="270">
          <div class="caption">
            <p>深入理解计算机系统</p>

          </div>
        </div>
        <div class="thumbnail" style="display:inline-block;height: 360px;">
            <img class="lazy" src="../assets/2.jpg" width="210" height="270">
          <div class="caption">
            <p>Web程序设计</p>
          </div>
        </div>
        <div class="thumbnail" style="display:inline-block;height: 360px;">
            <img class="lazy" src="../assets/3.jpg" width="210" height="270">
          <div class="caption">
            <p>阿斯托尔福的郊游</p>
          </div>
        </div>
        <div class="thumbnail" style="display:inline-block;height: 360px;">
            <img class="lazy" src="../assets/4.jpg" width="210" height="270">
          <div class="caption">
            <p>阿福和他(?)的朋友们</p>
          </div>
        </div>
  </div>
    </div>
  <button @click="showpic">显示来自MongoDB的图片</button>

  </div>
</template>

<script>
import {setCookie,getCookie,delCookie} from "../main";


export default {
    name: "Home",
  data(){
    return{
      name: '',
      ppp:''
    }
  },
  mounted(){
    /*页面挂载获取保存的cookie值，渲染到页面上*/
    let uname = getCookie('name')
    this.name = uname
    /*如果cookie不存在，则跳转到登录页*/
    if(uname == ""){
      this.$router.push('/Login')
    }
  },
  methods:{
    quit(){
      /*删除cookie*/
      delCookie('name')
    },
    showpic(){
      var that = this;
      this.$axios.get('http://127.0.0.1:8081/showpic',{})
        .then(function (response) {
          that.ppp=response.data;
        })
        .catch(function (error) {
          console.log(error)
        })
    }
  }
}
</script>

<style scoped>

</style>
