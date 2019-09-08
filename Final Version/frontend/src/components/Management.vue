<template>
      <div class="content-body">
        <h2>订单管理</h2>
        <el-input v-model="search" style="width: 300px"
                  placeholder="请输入时间" prefix-icon="el-icon-search"/>
        <el-table :data="tableData.filter(data=>!search || data.otime.includes(search))"
                  stripe
                  style="width: 100%;font-size: 18px;">
          <el-table-column>
            <el-table-column prop="orderi" label="订单号" width="150%" sortable></el-table-column>
            <el-table-column prop="obook" label="书籍名称" width="300%"></el-table-column>
            <el-table-column prop="onum" label="数量" width="130%" sortable></el-table-column>
            <el-table-column prop="otime" label="下单时间" width="330%" sortable></el-table-column>
            <el-table-column prop="ostate" label="订单状态" width="230%" sortable></el-table-column>
          </el-table-column>
        </el-table>
      </div>

</template>

<script>
    export default {
        name: "Management",
      data() {
        var that = this;
        var tep=document.cookie.split(";")[1].split("=")[1];
        let uord={'buser':tep}
        console.log(uord)
        this.$axios.post('http://127.0.0.1:8081/orders/uorder',uord)
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
<style scoped>

</style>
