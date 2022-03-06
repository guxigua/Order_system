<template>
  <el-container>
    <div class="container">请输入用户名:<input type="text" placeholder="请输入用户名" v-model="name2"/><br> 请输入密&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="password" placeholder="请输入密码" v-model="pass2"/><br>请输入餐桌号:<input type="text" v-model="table2" placeholder="请输入餐桌号"/><br><button @click="Register()">注册</button></div>
  </el-container>
</template>

<script>
export default {
  name: "Register",
  data(){
    return{
      name2:'',
      pass2:'',
      table2:''
    }
  },
  methods:{
    Register:function (){
      const _this = this
      axios({
        url: 'http://localhost:8848/zhonglongchang/registeruser',
        methods: 'get',
        params: {
          'name':_this._data.name2,
          'pass':_this._data.pass2,
          'address':_this._data.table2
        }
      }).then(res => {
        if(res.data.al=='注册成功'){
          alert('注册成功,请登录')
        }else{
          alert('该用户已存在')
        }
      })
    }
  }
}
</script>

<style scoped>
.container{
  margin:0 auto;
}
input{
  margin-top: 20px;
}
button{
  margin-top: 20px;
}
</style>
