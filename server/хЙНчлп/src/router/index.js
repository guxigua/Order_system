import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path:'/',
      name:'Index',
      component:()=>import('@/components/Index')
    },
    {
      path:'/ShopCar',
      name:'ShopCar',
      component:()=>import('@/components/ShopCar')
    },
    {
      path:'/Table',
      name:'Table',
      component:()=>import('@/components/Table'),
      children:[
        {
          path:'/Table',
          component:()=>import('@/components/Login')
        },
        {
          path:'/Register',
          component:()=>import('@/components/Register')
        },
      ]
    },
    {
      path:'/Pay',
      name:'Pay',
      component:()=>import('@/components/Pay')
    }
  ]
})
