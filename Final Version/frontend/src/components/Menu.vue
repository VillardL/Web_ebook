<template>
<div class="content-body">
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
      <el-table-column prop="stocknum" label="库存" width="200%" sortable></el-table-column>
      <el-table-column fixed="right" label="购买" width="100%">
        <template scope="scope">
          <el-button class="opt" @click="buythis(scope.$index,scope.row)" type="text" size="large">加入购物车</el-button>
        </template>
      </el-table-column>
    </el-table-column>
  </el-table>
  <router-view></router-view>
</div>
</template>

<script>
  export default {
    name: "Menu",
    data() {
      var that = this;
      // 向后端发请求，返回所有book信息
      // let that = this;
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
      opendetails(row)
      {
        this.$router.push('/Bookscan/Bookdetails')
      },
      buythis:function(index,rows){
        let vara=rows.bookname;
        let varb=rows.price;
        console.log(document.cookie)
        var tem=document.cookie.split(";")[1].split("=")[1];
        console.log(tem)
        // let uname = getCookie('name')
        // /*如果cookie不存在，则跳转到登录页*/
        if(tem === ""){
          this.$router.push('/Login')}
        else{
        let varc= {'busername':tem,'bookname': vara,'price':varb}
        this.$axios.post('http://127.0.0.1:8081/cartm/addcart',varc)
          .then(function (res) {
            console.log(res)
            if(res.data==="ok"){
              alert("成功")
            }
          })
        }
      }
    }

  }
</script>

<style scoped>

</style>
