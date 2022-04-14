import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import schoolNotice from '@/views/modules/schoolNotice/list'
    import parent from '@/views/modules/parent/list'
    import cadre from '@/views/modules/cadre/list'
    import clazzNotice from '@/views/modules/clazzNotice/list'
    import discussSchoolNotice from '@/views/modules/discussSchoolNotice/list'
    import scoreRank from '@/views/modules/scoreRank/list'
    import student from '@/views/modules/student/list'
    import clazz from '@/views/modules/clazz/list'
    import teacher from '@/views/modules/teacher/list'
    import score from '@/views/modules/score/list'
    import course from '@/views/modules/course/list'
    import config from '@/views/modules/config/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/schoolNotice',
        name: '学校公告',
        component: schoolNotice
      }
      ,{
	path: '/parent',
        name: '家长',
        component: parent
      }
      ,{
	path: '/cadre',
        name: '班干部',
        component: cadre
      }
      ,{
	path: '/clazzNotice',
        name: '班级公告',
        component: clazzNotice
      }
      ,{
	path: '/discussSchoolNotice',
        name: '学校公告评论',
        component: discussSchoolNotice
      }
      ,{
	path: '/scoreRank',
        name: '成绩排名',
        component: scoreRank
      }
      ,{
	path: '/student',
        name: '学生信息',
        component: student
      }
      ,{
	path: '/clazz',
        name: '班级信息',
        component: clazz
      }
      ,{
	path: '/teacher',
        name: '教师',
        component: teacher
      }
      ,{
	path: '/score',
        name: '学生成绩',
        component: score
      }
      ,{
	path: '/course',
        name: '课程信息',
        component: course
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
