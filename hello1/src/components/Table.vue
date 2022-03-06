<template>
  <div>
   <el-header>请在下面输入您的餐桌信息，同时为保证账单安全请登录或注册</el-header>
   <div><el-row type="flex" justify="center"><el-col :span="4"><router-link to="/Table">用户登录</router-link></el-col><el-col :span="4"><router-link to="/Register">用户注册</router-link></el-col></el-row></div>
   <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: "Table",
  data(){
    return{
      'name1':'',
      'pass1':''
    }
  }
}
</script>

<style scoped>
.el-container{
  height: 530px;
}
.el-header{
  line-height: 4;
}
.pass{
  margin-top: 15px;
  margin-bottom: 30px;
}
</style>
