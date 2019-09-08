// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import Element from  'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios'
import qs from 'qs'
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';

Vue.prototype.$axios = axios    //全局注册，使用方法为:this.$axios
Vue.prototype.qs = qs           //全局注册，使用方法为:this.qs

Vue.use(Element)
Vue.config.productionTip = false


/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})


export function setCookie(c_name,value,expire) {
  var date=new Date()
  date.setSeconds(date.getSeconds()+expire)
  document.cookie=c_name+ "="+escape(value)+"; expires="+date.toGMTString()
  console.log(document.cookie)
}

/*获取cookie*/
export function getCookie(c_name){
  if (document.cookie.length>0){
    let c_start=document.cookie.indexOf(c_name + "=")
    if (c_start!=-1){
      c_start=c_start + c_name.length+1
      let c_end=document.cookie.indexOf(";",c_start)
      if (c_end==-1) c_end=document.cookie.length
      return unescape(document.cookie.substring(c_start,c_end))
    }
  }
  return ""
}

/*删除cookie*/
export function delCookie(c_name){
  setCookie(c_name, "", -1)
}

