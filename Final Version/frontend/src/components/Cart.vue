<template>
  <div class="content-body">
  <div  id="cart" v-cloak>
        <template v-if="itemlis.length">
          <table><thead>
            <tr>
              <th>#</th><th>商品名称</th><th>商品单价</th><th>购买数量</th><th>操作</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for=" (item,index) in itemlis" :key="index">
              <td>
                {{index+1}}</td><td>{{item.aname}}</td><td>{{item.aprice}}
            </td>
              <td><button @click="handleAdd(index)">+</button>{{item.anum}}
                <button @click="handleReduce(index)" :disabled="item.anum ===1">-</button>
              </td>
              <td>
                <button @click="handleRemove(index)" >移除</button>
              </td>
            </tr>
            </tbody>
          </table>
          <!--<div class="total" style="padding-top: 50px">总价：¥{{totalPrice}}</div>-->
          <button @click="buyall">结算</button>
        </template>
        <div v-else>购物车为空</div>
      </div>
  </div>
</template>

<script>
  import Vue from 'vue'
  import VueResource from 'vue-resource'
  Vue.use(VueResource)
  export default {
    data () {
      return {
        itemlis: [
          // {
          //   name: '深入理解计算机系统',
          //   price:129,
          //   count: 1
          // },
          // {
          //   name:'Java',
          //   price: 56,
          //   count:1
          // }
        ]
      }
    },
    computed: {
      //计算并获取总价
      totalPrice () {
        let total = 0
        for (let i = 0; i < this.itemlis.length; i++) {
          let item = this.itemlis[i]
          total += item.price * item.anum
          var ntotal=total.toFixed(2)
        }
        return ntotal.toString().replace(/\B(?=(\d{3})+$)/g, ',')
      }
    },
    methods: {
      //获取商品列表
      getGoodList () {
        var that = this;
        var tem=document.cookie.split(";")[1].split("=")[1];
        let tam={'cuser':tem}
        this.$axios.post('http://127.0.0.1:8081/cartm/showcart',tam)
          .then(function (response) {
            that.itemlis=response.data;
            console.log(data)
          })
          .catch(function (error) {
            console.log(error)
          })
      },
      //减少商品数量
      handleReduce (index) {
        if (this.itemlis[index].anum === 1) return
        this.itemlis[index].anum--
      },
      //增加商品数量
      handleAdd (index) {
        this.itemlis[index].anum++
      },
      //从购物车中移除该商品
      handleRemove (index) {
        this.itemlis.splice(index, 1)
      },
      buyall(){
        var that = this;
        var tep=document.cookie.split(";")[1].split("=")[1];
        let bam={'buser':tep}
        console.log(bam)
        this.$axios.post('http://127.0.0.1:8081/cartm/buyall',bam)
          .then(function (response) {
            if(response==="okk"){ alert("购买成功")}
          })
          .catch(function (error) {
            console.log(error)
          })
      }
    },
    mounted () {
      //获取商品
      this.getGoodList()
    }
  }

</script>

<style scoped>

</style>
