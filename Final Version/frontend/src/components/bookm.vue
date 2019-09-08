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
      <button> <router-link to="/addbook" class="tab">添加新书</router-link></button>
        <el-input v-model="search" style="width: 300px"
                  placeholder="请输入书名" prefix-icon="el-icon-search"/>
        <el-table :data="tableData.filter(data=>!search || data.bookname.includes(search))"
                  stripe
                  style="width: 100%;font-size: 18px;">
        <el-table-column>
          <el-table-column prop="bookid" label="ID" width="50%" sortable></el-table-column>
          <el-table-column prop="bookname" label="书名" width="200%" sortable></el-table-column>
          <el-table-column prop="pic" label="封面" width="200%"></el-table-column>
          <el-table-column prop="author" label="作者" width="130%" sortable></el-table-column>
          <el-table-column prop="isbn" label="ISBN"width="200%"  sortable></el-table-column>
          <el-table-column prop="price" label="价格" width="100%" sortable></el-table-column>
          <el-table-column prop="stocknum" label="库存" width="100%" sortable></el-table-column>
          <el-table-column fixed="right" label="操作" width="100">
            <template scope="scope">
              <el-button class="opt" @click="manbook(scope.$index,scope.row)" type="text" size="large">编辑</el-button>
              <el-button class="opt" @click="delebook(scope.$index,scope.row)" type="text" size="large">删除</el-button>
            </template>
          </el-table-column>
        </el-table-column>
      </el-table>
      </div>
  </div>

</template>

<script>
    export default {
        name: "bookm",
      data() {
        var that = this;
        this.$axios.get('http://127.0.0.1:8081/books/showbook',{})
          .then(function (response) {
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
      },
      methods:{
        manbook:function(index,rows){
            console.log(rows)

          },
        delebook:function(index,rows){
          console.log(rows)
          let deleid= {'bookid': rows.bookid}
          this.$axios.post('http://127.0.0.1:8081/books/delebook',deleid)
            .then(function (res) {
              console.log(res)
              if(res.data==="ok"){alert("删除成功")}
              that.$router.push('/bookm')
            })
        }
      }
    }
</script>

<style scoped>

</style>

