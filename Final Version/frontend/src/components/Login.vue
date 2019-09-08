<template>
  <div class="content-body">
    <div class="login-wrap" v-show="showLogin">
      <h3>登录</h3>
      <p v-show="showTishi">{{tishi}}</p>
      <!--<input type="text" placeholder="请输入用户名" v-model="name">-->
      <!--<input type="password" placeholder="请输入密码" v-model="password">-->
      <input type="text" placeholder="请输入用户名" v-model="name">
      <input type="password" placeholder="请输入密码" v-model="password">
      <button @click="login">登录</button>
      <span @click="ToRegister">没有账号？马上注册</span>
    </div>

    <div class="register-wrap" v-if="showRegister">
      <h3>注册</h3>
      <p v-show="showTishi">{{tishi}}</p>
      <input type="text" placeholder="请输入用户名" v-model="newName">
      <input type="password" placeholder="请输入密码" v-model="newPassword">
      <input type="password" placeholder="请确认密码" v-model="surePassword">
      <input type="email" placeholder="请输入邮箱" v-model="newEmail"></input>
      <!--<input type="text" placeholder="请输入用户名" >-->
      <!--<input type="password" placeholder="请输入密码" >-->
   <!--   <input type="password" placeholder="请确认密码" v-model="surePassword">-->
      <button @click="register">注册</button>
      <span @click="ToLogin">已有账号？马上登录</span>
    </div>
  </div>
</template>

<style>
  input{display:block; width:250px; height:40px; line-height:40px; margin:0 auto; margin-bottom: 10px; outline:none; border:1px solid #888; padding:10px; box-sizing:border-box;}
  p{color:red;}
  button{text-align:center;display:block; width:250px; height:40px;line-height: 20px; margin:0 auto; border:none; background-color: #5f9ea0; color:#fff; font-size:16px; margin-bottom:5px;}
  .login-wrap{text-align:center;}
  input{display:block; width:250px; height:40px; line-height:40px; margin:0 auto; margin-bottom: 10px; outline:none; border:1px solid #888; padding:10px; box-sizing:border-box;}
  span{cursor:pointer;}
  span:hover{color: #5f9ea0;}
</style>

<script>
import {setCookie,getCookie} from "../main";

export default {
  data() {
    return {
      showLogin: true,
      showRegister: false,
      showTishi: false,
      tishi: '',
      name: '',
      password: '',
      newName: '',
      newPassword: '',
      surePassword: '',
      newEmail: ''
    }
  },
  mounted() {
    /*页面挂载获取cookie，如果存在username的cookie，则跳转到主页，不需登录*/
    if (getCookie('name')) {
      this.$router.push('/Home')
    }
  },
  methods: {
    ToRegister() {
      this.showRegister = true
      this.showLogin = false
    },
    ToLogin() {
      this.showRegister = false
      this.showLogin = true
    },
    login() {
      if (this.name == "" || this.password == "") {
        alert("请输入用户名或密码")
      } else {
        let userlog = {'name': this.name, 'password': this.password}
        /*接口请求*/
        let that=this
        this.$axios.post('http://127.0.0.1:8081/user/login',userlog)
          .then(function (res) {
            console.log(res)
            if (res.data === "no") {
              that.tishi = "用户不存在"
              that.showTishi = true
            } else if (res.data === "wrong") {
              that.tishi = "密码输入错误"
              that.showTishi = true
            } else if (res.data === "admin") {
              /*路由跳转this.$router.push*/
              that.$router.push('/Main')
            } else if(res.data==="forbid"){
              that.tishi = "您的账号已被禁用"
              that.showTishi = true
            }else{
              that.tishi = "登录成功"
              that.showTishi = true
              setCookie('name', that.name, 1000 * 60)
              setTimeout(function () {
                that.$router.push('/Home')
              }.bind(that), 1000)
            }
          })
          .catch(function (error) {
            console.log(error)
          })
      }
    },
    register() {
      if (this.newName == "" || this.newPassword == "" ||this.newEmail==""|| this.surePassword=="") {
        alert("请输入完整信息")
      }
      else if(this.newPassword!=this.surePassword){alert("确认密码与设置密码不一致")}
       else {
        console.log(this.newName)
        let user = {'name': this.newName, 'type': 0, 'password': this.newPassword, 'email': this.newEmail, 'alive': 1}
        let that = this
        this.$axios.post('http://127.0.0.1:8081/user/adduser',user)
          .then(function (res) {
            if (res.data === "ok") {
              that.tishi = "注册成功"
              that.showTishi = true
              //       /*注册成功之后再跳回登录页*/
              setTimeout(function () {
                that.showRegister = false
                that.showLogin = true
                that.showTishi = false
              }.bind(this), 1000)
            }
        else if(res.data==="has"){
              that.tishi = "注册失败，请更换注册名"
              that.showTishi = true
              that.name = ''
              setTimeout(function () {
                that.showTishi = false
              }.bind(this), 1000)
            }
          })
          .catch(function (error) {
            console.log(error);
          });
      }
      }
    }
}

</script>

