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
    import news from '@/views/modules/news/list'
    import yuangong from '@/views/modules/yuangong/list'
    import yuangonggongzi from '@/views/modules/yuangonggongzi/list'
    import gongzuohuibao from '@/views/modules/gongzuohuibao/list'
    import richenganpai from '@/views/modules/richenganpai/list'
    import renwufenpei from '@/views/modules/renwufenpei/list'
    import yuangongqingjia from '@/views/modules/yuangongqingjia/list'
    import zhuguan from '@/views/modules/zhuguan/list'
    import gongzuorizhi from '@/views/modules/gongzuorizhi/list'
    import zhuguangongzi from '@/views/modules/zhuguangongzi/list'
    import bumen from '@/views/modules/bumen/list'
    import zaixianliuyan from '@/views/modules/zaixianliuyan/list'
    import kaoqinxinxi from '@/views/modules/kaoqinxinxi/list'
    import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
    path: '/',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center', affix: true}
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
	path: '/news',
        name: '通知公告',
        component: news
      }
      ,{
	path: '/yuangong',
        name: '技术部门员工',
        component: yuangong
      }
      ,{
	path: '/yuangonggongzi',
        name: '技术部门员工工资',
        component: yuangonggongzi
      }
      ,{
	path: '/gongzuohuibao',
        name: '工作汇报',
        component: gongzuohuibao
      }
      ,{
	path: '/richenganpai',
        name: '日程安排',
        component: richenganpai
      }
      ,{
	path: '/renwufenpei',
        name: '任务分配',
        component: renwufenpei
      }
      ,{
	path: '/yuangongqingjia',
        name: '技术部门员工业务申请',
        component: yuangongqingjia
      }
      ,{
	path: '/zhuguan',
        name: '技术部门经理',
        component: zhuguan
      }
      ,{
	path: '/gongzuorizhi',
        name: '工作日志',
        component: gongzuorizhi
      }
      ,{
	path: '/zhuguangongzi',
        name: '技术部门经理工资',
        component: zhuguangongzi
      }
      ,{
	path: '/bumen',
        name: '部门',
        component: bumen
      }
      ,{
	path: '/zaixianliuyan',
        name: '在线留言',
        component: zaixianliuyan
      }
      ,{
	path: '/kaoqinxinxi',
        name: '考勤信息',
        component: kaoqinxinxi
      }
      ,{
	path: '/newstype',
        name: '通知公告分类',
        component: newstype
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
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
