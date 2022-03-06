<template>
  <el-container>
  <div class="container">请输入用户名:<input type="text" v-model="name1" placeholder="请输入用户名"/><br> 请输入密&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="password" v-model="pass1" placeholder="请输入密码"/><br><button @click="login()">登录</button></div>
  </el-container>
</template>

<script>
export default {
  name: "Login",
  data(){
    return{
        name1:'',
        pass1:''
    }
  },
  methods:{
    login:function(){
      const _this = this
      axios({
        url: 'http://localhost:8848/zhonglongchang/LoginCl',
        methods: 'get',
        params: {
          'name':_this._data.name1,
          'pass':_this._data.pass1
        }
      }).then(res => {
        if(res.data.al=='用户名或密码错误'){
          alert('用户名或密码错误')
        }else{
          this.$router.push({
            //name表示跳转之后的资源前端访问路径，query用于存储待使用数据，其中page是本页面name,
            name: 'Pay',
        })
          console.log(res)
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
