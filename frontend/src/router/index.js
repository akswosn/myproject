import Vue from 'vue'
import Router from 'vue-router'
import Main from '@/components/Main'
import Login from '@/components/Login'
import Test from '@/components/test/Test'
import ResumeMain from '@/components/resume/Main'
import ResumeRegist from '@/components/resume/Regist'
import ResumeView from '@/components/resume/view'
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
      name: 'ResumeMain',
      component: ResumeMain
    },{
      path: '/resume/view/:no',
      name: 'ResumeView',
      component: ResumeView
    },{
      path: '/resume/list',
      name: 'ResumeMain',
      component: ResumeMain
    },{
      path: '/resume/regist',
      name: 'ResumeRegist',
      component: ResumeRegist
    },{
      path: '/resume/regist/:no+',
      name: 'ResumeRegist',
      component: ResumeRegist
    },
    {
      path: '/blog',
      name: 'blogMain',
      component: BlogMain
    },
  ]
})
