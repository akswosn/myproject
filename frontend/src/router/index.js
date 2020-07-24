import Vue from 'vue'
import Router from 'vue-router'
import Main from '@/view/Main'
import Login from '@/view/Login'
import Test from '@/components/test/Test'
import ResumeMain from '@/view/resume/Main'
import ResumeRegist from '@/view/resume/Regist'
import ResumeView from '@/view/resume/View'
import BlogMain from '@/view/blog/Main'
import BlogView from '@/view/blog/View'

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
      path: '/resume/regist/:no',
      name: 'ResumeRegist',
      component: ResumeRegist
    },
    {
      path: '/blog',
      name: 'blogMain',
      component: BlogMain
    },    
    {
      path: '/blog/view/:no',
      name: 'BlogView',
      component: BlogView
    },

  ]
})
