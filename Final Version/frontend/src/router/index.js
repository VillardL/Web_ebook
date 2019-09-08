import Vue from 'vue'
import Router from 'vue-router'

//Vue.use(Router)
import Home from '@/components/Home'
import Cart from '@/components/Cart'
import Menu from '@/components/Menu'
import Management from "../components/Management";
import orderm from "../components/orderm";
import Login from "../components/Login";
import Main from "@/components/Main";
import userm from "@/components/userm";
import bookm from "@/components/bookm";
import addbook from "@/components/addbook"
Vue.use(Router)

export default new Router({
  mode:'history',
  routes: [
    {
      path: '/Home',
      name: 'Home',
      component: Home
    },
    {
      path: '/Login',
      name: 'Login',
      component: Login
    },
    {
      path: '/Menu',
      name: 'Menu',
      component:Menu,
    },
    {
      path: '/Cart',
      name: 'Cart',
      component: Cart
    },
    {
      path:'/Management',
      name:'Management',
      component:Management
    },
    {
      path:'/Main',
      name:'Main',
      component:Main
    },
    {
      path:'/userm',
      name:'userm',
      component:userm
    },
    {
      path:'/bookm',
      name:'bookm',
      component:bookm
    },
    {
      path:'/orderm',
      name:'orderm',
      component:orderm
    },
    {
      path:'/addbook',
      name:'addbook',
      component:addbook
    }
  ]
})
