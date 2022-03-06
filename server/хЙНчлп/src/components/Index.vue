<template>
  <div class="all">
<el-container>
 <el-header class="header1">
   <el-row>
     <el-col>请在下面进行点餐</el-col>
   </el-row>
 </el-header>
  <el-container>
    <el-aside class="aside1">
      <el-row class="top">
        <el-col>今日热点</el-col>
      </el-row>
      <el-row class="lun">
        <ul>
          <li class="li"><img src="../assets/5.jpg"></li>
          <li class="l1"><img src="../assets/1.jpg"></li>
          <li class="l2"><img src="../assets/2.jpg"></li>
          <li class="l3"><img src="../assets/3.jpg"></li>
          <li class="l4"><img src="../assets/4.jpg"></li>
          <li class="l5"><img src="../assets/5.jpg"></li>
        </ul>
      </el-row>
      <el-row class="move">
        <el-col>
          完成点餐后请前往购物车
        </el-col>
      </el-row>
    </el-aside>
    <el-main class="main1">
      <div class="main">
        <div class="left" v-for="item in vegetable">
             <el-container class="introall">
             <div class="img"><img :src="item.photo"></div>
             <div  class="intro"><el-row class="row">简单介绍:</el-row><el-row class="row">{{item.goodsIntro}}</el-row><el-row><button class="btn" @click="buy(item.goodsID)">购买</button></el-row></div>
             </el-container>
        </div>
        <div class="number"><button @click="query(1)">1</button><button @click="query(2)">2</button><button @click="query(3)">3</button></div>
      </div>
    </el-main>
  </el-container>
  <el-footer class="footer1">
    <el-row>
      <el-col>用户订餐系统欢迎您</el-col>
    </el-row>
  </el-footer>
</el-container>
  </div>
</template>

<script>
export default {
  name: "Index",
  data(){
    return{
      vegetable:[],
      id:"",
    }
  },
  created() {
    const _this = this
     axios('http://localhost:8848/zhonglongchang/ShowGoodsPageServlet').then(function (res){
             _this.vegetable=res.data.al
       })
  },
  methods:{
    query:function (number){
      const _this = this
      const number1=number.toString()
      axios({
        url: 'http://localhost:8848/zhonglongchang/ShowGoodsPageServlet',
        methods: 'get',
        params: {
          'pageNow': number
        }
      }).then(res => {
        _this.vegetable=res.data.al
        console.log(res.data.al)
      })
    },
    buy:function (id){
      this.id=id
      const id1=id.toString()
      axios({
        url: 'http://localhost:8848/zhonglongchang/ShoppingClServlet',
        methods: 'get',
        params: {
          'goodsId': id1
        }
      }).then(res => {
         if(res.data!=null){
           alert("成功加入购物车")
         }
      })
    }
  }
}
</script>

<style scoped>
.main1{
  height: 490px;
}
.header1{
  line-height: 3;
}
.footer1{
  height: 10px;
  line-height: 3;
}
.aside1{
  height: 490px;
}
.intro{
  width: 200px;
  height: 100%;
}
.top{
  margin-top: 80px;
}
ul li{
  list-style: none;
}
.lun{
  position: relative;
  margin-top: 40px;
}
.lun ul li{
  position: absolute;
}
.lun ul li img{
  width: 220px;
  height: 220px;
}
.move{
  margin-top: 240px;
  color: red;
}
.l1{
  animation: l1 20s ease-in-out infinite;
}
@keyframes l1{
  0%{clip-path: polygon(0 0,0 0,0 100%,0 100%)}
  20%{clip-path: polygon(0 0,100% 0,100% 100%,0 100%)}
}
.l2{
  animation: l2 20s ease-in-out infinite;
}
@keyframes l2{
  0%{clip-path: polygon(0 0,0 0,100% 0,100% 0)}
  20%{clip-path: polygon(0 0,0 0,100% 0,100% 0)}
  40%{clip-path: polygon(0 0,100% 0,100% 100%,0 100%)}
}
.l3{
  animation: l3 20s ease-in-out infinite;
}
@keyframes l3{
  0%{clip-path: polygon(0 0,0 0,0 0,0 0)}
  40%{clip-path: polygon(0 0,0 0,0 0,0 0)}
  60%{clip-path: polygon(0 0,100% 0,100% 100%,0 100%)}
}
.l4{
  animation: l4 20s ease-in-out infinite;
}
@keyframes l4{
  0%{clip-path: polygon(100% 0,100% 0,0 100%,0 100%)}
  60%{clip-path: polygon(100% 0,100% 0,0 100%,0 100%)}
  80%{clip-path: polygon(0 0,100% 0,100% 100%,0 100%)}
}
.l5{
  animation: l5 20s ease-in-out infinite;
}
@keyframes l5{
  0%{clip-path: polygon(50% 50%,50% 50%,50% 50%,50% 50%)}
  80%{clip-path: polygon(50% 50%,50% 50%,50% 50%,50% 50%)}
  100%{clip-path: polygon(0 0,100% 0,100% 100%,0 100%)}
}
.main{
  width: 100%;
  height: 100%;
  overflow: hidden;
}
.main .left{
  width: 30%;
  height: 45%;
  margin-left: 10px;
  float: left;
}
.left:nth-child(4),.left:nth-child(5),.left:nth-child(6){
  margin-top: 30px;
}
.img{
  width: 200px;
  height: 220px;
  text-align: left;
  float: left;
}
.img img{
  height: 200px;
  width: 200px;
}
.introall{
  width: 100%;
  height: 100%;
  overflow: hidden;
}
.intro{
  width: 200px;
  height: 100%;
  float: left;
}
.row{
  width: 100px;
  text-align: right;
  margin-top: 40px;
}
.btn{
  margin-top: 20px;
}
.number{
  line-height: 27;
}
.number button:nth-child(2),
.number button:nth-child(3){
  margin-left: 5px;
}
</style>
