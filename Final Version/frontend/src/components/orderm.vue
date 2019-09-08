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
      <el-input v-model="search" style="width: 300px"
                placeholder="请输入用户名" prefix-icon="el-icon-search"/>
      <el-table :data="tableData.filter(data=>!search || data.ouser.includes(search))"
                stripe
                style="width: 100%;font-size: 18px;">
          <el-table-column>
            <el-table-column prop="orderi" label="订单号" width="150%" sortable></el-table-column>
            <el-table-column prop="ouser" label="购买者" width="200%" sortable></el-table-column>
            <el-table-column prop="obook" label="书籍名称" width="200%"></el-table-column>
            <el-table-column prop="onum" label="数量" width="130%" sortable></el-table-column>
            <el-table-column prop="otim" label="下单时间" width="130%" sortable></el-table-column>
            <el-table-column prop="ostate" label="订单状态" width="130%" sortable></el-table-column>
          </el-table-column>
        </el-table>
      </div>
    </div>
</template>

<script>
    export default {
        name: "orderm",
      data() {
        var that = this;
        this.$axios.get('http://127.0.0.1:8081/orders/morder',{})
          .then(function (response) {
            console.log(response.data)
            that.tableData=response.data;
          })
          .catch(function (error) {
            console.log(error)
          })
        return {
          search: '',
            tableData:[
            ]
          }
      }
    }
</script>
