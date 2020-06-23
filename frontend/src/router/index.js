import Vue from 'vue'
import Router from 'vue-router'
import Main from '@/components/Main'
import Login from '@/components/Login'
import Test from '@/components/test/Test'
import ResumeView from '@/components/resume/View'
import BlogMain from '@/components/blog/Main'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Main',
      component: Main
    },
    {
      path: '/test',
      name: 'test',
      component: Test
    },
    {
      path: '/login',
      name: 'login',
      component: Login
    },
    {
      path: '/resume',
      name: 'resumeView',
      component: ResumeView
    },
    {
      path: '/blog',
      name: 'blogMain',
      component: BlogMain
    },
  ]
})
