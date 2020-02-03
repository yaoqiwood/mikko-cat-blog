// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
// router
import routes from './router'
// iview vue router
// import VueRouter from 'vue-router'
import ViewUI from 'view-design'
import 'view-design/dist/styles/iview.css'

// vue Resource
import VueResource from 'vue-resource'
// vue locale 国际化
import Locale from 'view-design/dist/locale/en-US'
// vue-particles
import VueParticles from 'vue-particles'

Vue.config.productionTip = false
Vue.use(ViewUI)
Vue.use(VueResource)
Vue.use(Locale)
Vue.use(VueParticles)

// const RouterConfig = {
//   routes: Routers
// }

// const router = new VueRouter(RouterConfig)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router: routes,
  // components: {
  //   App
  // },
  render: h => h(App)
  // template: '<App/>'
})
