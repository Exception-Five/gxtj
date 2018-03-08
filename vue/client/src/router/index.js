import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Index from '@/views/Index'
import Article from '@/views/Article'
import Member from '@/views/Member'
import RegisterSuccess from '@/views/RegisterSuccess'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/index',
      name: 'Index',
      component: Index
    },
    {
      path: '/article/:id',
      name: 'Article',
      component: Article
    },
    {
      path: '/member',
      name: 'Member',
      component: Member
    },
    {
      path: '/success/:code',
      name: 'Success',
      component: RegisterSuccess
    }
  ]
})
