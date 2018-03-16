import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Index from '@/views/Index'
import Article from '@/views/Article'
import Member from '@/views/Member'
import Search from '@/views/Search'
import UserInfo from '@/views/UserInfo'
import UserMod from '@/views/UserMod'
import TypeArticleList from '@/views/TypeArticleList'


import RegisterSuccess from '@/views/RegisterSuccess'
import Test from '@/views/test/Test'
import Test1 from '@/views/test/Test1'

import Page404 from '@/views/Page404'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'home',
      component: Index
    },
    {
      path: '/index',
      name: 'Index',
      component: Index
    },
    {
      path: '/type/:id',
      name: 'typeList',
      component: TypeArticleList
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
      path: '/search',
      name: 'search',
      component: Search
    },
    {
      path: '/userinfo',
      name: 'userinfo',
      component: UserInfo
    },
    {
      path: '/usermod',
      name: 'usermod',
      component: UserMod
    },
    {
      path: '/success/:code',
      name: 'Success',
      component: RegisterSuccess
    },
    {
      path: '/test',
      name: 'Test',
      component: Test
    },
    {
      path: '/test1',
      name: 'Test1',
      component: Test1
    },
    {
      path: '/404',
      name: '404',
      component: Page404
    }
  ]
})
