<template>
  <div id="app">
    <div class="header">
      <el-row>
        <el-col style="font-size: 20px">
          用户订餐系统
        </el-col>
      </el-row>
    </div>
    <div id="nav">
      <el-row>
        <el-col :span="6">
      <router-link to="/">点餐</router-link>
        </el-col>
        <el-col :span="6">
          <router-link to="/ShopCar">购物车</router-link>
        </el-col>
        <el-col :span="6">
          <router-link to="/Table">登录注册</router-link>
        </el-col>
        <el-col :span="6">
          <router-link to="/Pay">完成订餐</router-link>
        </el-col>
      </el-row>
    </div>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color:white;
  background-image: linear-gradient(to left top,#d16ba5,#c777b9,#ba83ca,#aa8fd8,#9a9ae1,#8aa7ec,#79b3f4,#69bff8,#52affe,#41dfff,#46eefa,#5ffbf1);
}
.header{
  height: 130px;
  line-height: 5;
}
el-row{
  background-color: blue;
}
</style>
