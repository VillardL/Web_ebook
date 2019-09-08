<template>
  <div>
  <div class="Topnav">
    <ul class="leftmenu">
      <li class="menulist"> <router-link to="/userm" class="tab">用户管理</router-link></li>
      <li class="menulist"><router-link to="/bookm" class="tab">图书管理</router-link></li>
      <li class="menulist"> <router-link to="/orderm" class="tab">订单管理</router-link></li>
    </ul>
  </div>
  <div class="content-body">
    <input type="number" placeholder="编号" v-model="newId">
  <input type="text" placeholder="书名" v-model="newBookname">
  <input type="number" placeholder="价格" v-model="newPrice">
  <input type="number" placeholder="库存" v-model="newStocknum">
  <input type="text" placeholder="图片" v-model="newPic"></input>
  <input type="text" placeholder="作者" v-model="newAuthor"></input>
  <input type="text" placeholder="ISBN" v-model="newISBN"></input>
  <input type="text" placeholder="请添加描述" v-model="newDes" style="height: 10em;"></input>
  <button @click="addb">确认添加</button>
  </div>
  </div>
</template>

<script>
    export default {
        name: "addbook",
      data(){
          return{
            newId:'',
          newBookname: '',
          newPrice: '',
          newStocknum: '',
          newPic:'',
          newAuthor:'',
          newISBN:'',
          newDes:''
          }
      },
      methods:{
          addb(){
      if (
        this.newBookname == "" || this.newPrice == "" ||this.newStocknum=="") {
        alert("请输入完整信息")
      }
      else{
        console.log(this.newBookname)
        let book = {'id':this.newId,'bookname': this.newBookname,'price':this.newPrice,'stocknum':this.newStocknum,'pic':this.newPic,'author':this.newAuthor,'isbn':this.newISBN,'describes':this.newDes }
        let that = this
        console.log(book)
        this.$axios.post('http://127.0.0.1:8081/books/addb',book)
          .then(function (res) {
            if (res.data === "ok") {
              alert( "添加成功")
              that.$router.push('/bookm')
            }
            else{
              alert("ID不可用")
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

<style scoped>
  input{display:block; width:250px; height:40px; line-height:40px; margin:0 auto; margin-bottom: 10px; outline:none; border:1px solid #888; padding:10px; box-sizing:border-box;}
  p{color:red;}
  input{display:block; width:250px; height:40px; line-height:40px; margin:0 auto; margin-bottom: 10px; outline:none; border:1px solid #888; padding:10px; box-sizing:border-box;}
  span{cursor:pointer;}
  span:hover{color: #5f9ea0;}
</style>
