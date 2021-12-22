import Vue from 'vue'
import VueRouter from 'vue-router'
import Routers from './routers'
import SystemConstants from '@/constants/SystemConstants'

// import HelloWorld from '@/components/HelloWorld'

Vue.use(VueRouter)

const router = new VueRouter({
  routes: Routers,
  mode: SystemConstants.ROUTER_METHOD.HISTORY
})

export default router
// export default new VueRouter({
//   routes: [{
//     path: '/',
//     name: 'HelloWorld',
//     component: HelloWorld
//   }]
// })
