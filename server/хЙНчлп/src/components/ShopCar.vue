<template>
<div class="all">
  <el-container>
    <el-header>
      <el-row>
        <el-col class="none">请在下面确认点餐信息</el-col>
      </el-row>
    </el-header>
      <el-main>
        <el-row type="flex" justify="center">
          <el-col :span="3">编号</el-col>
          <el-col :span="4">菜名</el-col>
          <el-col :span="3">单价</el-col>
          <el-col :span="4">数量</el-col>
        </el-row>
        <el-row type="flex" justify="center" v-for="(item,index) in vegetable">
          <el-col :span="3">{{item.goodsID}}</el-col>
          <el-col :span="4">{{item.goodsName}}</el-col>
          <el-col :span="3">{{item.goodsPrice}}</el-col>
          <el-col :span="4" class="lastcol"><input type="text" v-model="number[index]"/><button class="btn" @click="del(item.goodsID)">删除</button></el-col>
        </el-row>
          <el-row type="flex" justify="center">
            <el-col :span="3"></el-col>
            <el-col :span="4"><button @click="clear()">删除全部餐品</button></el-col>
            <el-col :span="3"></el-col>
            <el-col :span="4"><button @click="">修改数量</button></el-col>
          </el-row>
        <el-row type="flex" justify="center">
          <el-col :span="14"><span>您的订餐费总共为:&yen;{{this.allprice}}</span></el-col>
        </el-row>
        <el-row  type="flex" justify="center">
          <el-col :span="14"><span>用户订餐系统欢迎您</span></el-col>
        </el-row>
      </el-main>
  </el-container>
</div>
</template>

<script>
export default {
  name: "ShopCar",
  data(){
    return{
      number:[],
      allprice:'',
      vegetable:[]
    }
  },
  created() {
    const _this=this
    axios({
      url: 'http://localhost:8848/zhonglongchang/ShoppingClServlet',
      methods: 'get',
      params:{
        'type':'show'
      }
    }).then(res => {
      _this.vegetable=res.data.al
      _this.number=res.data.num
      _this.allprice=res.data.allPrice
      console.log(res.data)
    })
  },
  methods:{
    del:function (goodsId){
      const _this=this
      axios({
        url: 'http://localhost:8848/zhonglongchang/ShoppingClServlet',
        methods: 'get',
        params:{
          'type':'delGoods',
          'goodsId':goodsId
        }
      }).then(res => {
        _this.vegetable=res.data.al
        _this.number=res.data.num
        _this.allprice=res.data.allPrice
      })
    },
    clear:function (){
      axios({
        url: 'http://localhost:8848/zhonglongchang/ShoppingClServlet',
        methods: 'get',
        params:{
          'type':'clear',
        }
      }).then(res => {
        _this.vegetable=res.data.al
        _this.number=res.data.num
        _this.allprice=res.data.allPrice
      })
    }
  }
}
</script>

<style scoped>
.el-container{
  height: 610px;
}
.el-main{
}
.el-header{
  line-height: 3;
}
.el-footer{
  height: 10px;
  line-height: 3;
}
.el-col{
  height: 25px;
  border: 1px solid silver;
}
.none{
  border: none;
}
.el-button{
  height: 10px;
}
input[type="text"]{
width: 50px;
}
.lastcol{
  text-align: left;
  padding-left: 50px;
}
a{
  margin-left: 20px;
}
.btn{
  margin-left: 20px;
}
</style>
