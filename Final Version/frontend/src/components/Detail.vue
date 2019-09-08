<template>
  <div id="detail">
    <h2 class="title_product padL0">深入理解计算机系统</h2>
    <div>
      <div class="image1" style="float: left" >
        <img src="../img/ics.jpg" width="30%" />
      </div>
      <div class="forBuy" style="float:right" width="60">
        <div class="details">
          <div class="rname">书名：深入理解计算机系统（原书第3版）</div>
          <div>出版社：机械工业出版社</div>
          <div>出版时间：2016-7</div>
          <div>ISBN：9787111544937</div>
          <div>定价：139.00</div>
        </div>
        <div class="count">
          数量:
        </div>
        <div class="stepper">
          <div class="count-input space-bottom">
            <a class="incr-btn" data-action="decrease" href="#">–</a>
            <input class="quantity" readonly="" type="text" name="quantity" value="1">
            <a class="incr-btn" data-action="increase" href="#">+</a>
          </div>
        </div>
        <div>
          <a class="bought"data-action="history" href="#"></a>
        </div>
        <button class="addCart">加入购物车</button>
      </div>
    </div>

  </div>
</template>

<script>
    export default {
        name: "Detail"
    }
</script>

<style scoped>

</style>
