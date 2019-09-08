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
      <el-table :data="list.tableData.filter(data=>!search || data.bookName.includes(search))"
                style="width: 90%; font-size: 20px; padding-top: 20px; padding-bottom:50px; margin: 0px auto">
        <el-table-column>
          <el-table-column prop="name" label="用户名" width="300%" sortable></el-table-column>
          <el-table-column prop="email" label="邮箱" width="400%" sortable></el-table-column>
          <el-table-column prop="alive" label="活跃" width="100%" sortable></el-table-column>
          <el-table-column fixed="right" label="操作" width="180%">
            <template scope="scope">
              <el-button class="opt" @click="forb(scope.$index,scope.row)"type="text">禁用 </el-button>
              <el-button class="opt" @click="rele(scope.$index,scope.row)" type="text">解禁</el-button>
            </template>
          </el-table-column>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
  export default {
    name: "userm",
    data() {
      var that = this;
      this.$axios.get('http://127.0.0.1:8081/userm/showuser',{})
        .then(function (response) {
          that.list.tableData=response.data;
        })
        .catch(function (error) {
          console.log(error)
        })
      return {
        search: '',
        list:{
          tableData:[
          ]
        }
      }
    },
    methods:{
      forb:function(index,rows){
        let name1=rows.name
        let itemname= {'name': rows.name}
        this.$axios.post('http://127.0.0.1:8081/userm/forbuser',itemname)
          .then(function (res) {
            console.log(res)
         })
      },
      rele:function(index,rows){
        let name1=rows.name
        console.log(rows.alive)
        console.log(index)
        console.log(rows.name)
        let itemneme= {'name': rows.name}
        this.$axios.post('http://127.0.0.1:8081/userm/releuser',itemneme)
          .then(function (res) {
            console.log(res)
          })
      }

    }
  }

</script>

<style scoped>

</style>
