<template>
<el-container>
  <el-header>以下是您的订餐信息，请确认</el-header>
  <el-row type="flex" justify="center"><el-col :span="4">订单号</el-col><el-col :span="4">用户ID</el-col><el-col :span="4">是否支付</el-col><el-col :span="4">总价</el-col></el-row>
  <el-row type="flex" justify="center"><el-col :span="4">1</el-col><el-col :span="4">2</el-col><el-col :span="4">否</el-col><el-col :span="4">69</el-col></el-row>
  <el-row type="flex" justify="center"><el-col :span="16">账单信息已发送至后厨,请耐心等待</el-col></el-row>
</el-container>
</template>

<script>
export default {
  name: "Pay",
  created() {
    const _this = this
    axios('http://localhost:8848/zhonglongchang/OrderClServlet').then(function (res){
      console.log(res)
    })
  }
}
</script>

<style scoped>
.el-header{
 margin-top: 10px;
  margin-bottom: 20px;
}
.el-container{
  height: 610px;
}
.el-col{
  border: 1px solid silver;
  height: 25px;
}
</style>
