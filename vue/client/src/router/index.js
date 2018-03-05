import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Index from '@/views/Index'
import Article from '@/views/Article'
import Member from '@/views/Member'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Index',
      component: Index
    },
    {
      path: '/article',
      name: 'Article',
      component: Article
    },
    {
      path: '/member',
      name: 'Member',
      component: Member
    }
  ]
})