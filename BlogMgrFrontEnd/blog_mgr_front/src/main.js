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
import '@/assets/icons/iconfont.css'
import './assets/my-theme/my-theme-custom.less'

// vue Resource
import VueResource from 'vue-resource'
// vue locale 国际化
import Locale from 'view-design/dist/locale/en-US'
// vue-particles
import VueParticles from 'vue-particles'

// vue-cookies
import VueCookies from 'vue-cookies'

// mavonEditor
import MavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'

// mikko-util
import MikkoUtil from '../mikko-util'

// interceptor
import httpInterceptor from './utils//Http.interceptor'

Vue.config.productionTip = false
Vue.use(ViewUI)
Vue.use(VueResource)
Vue.use(Locale)
Vue.use(VueParticles)
Vue.use(VueCookies)
Vue.use(MavonEditor)
Vue.use(MikkoUtil)
Vue.use(httpInterceptor)

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
  // ...App
  render: h => h(App)
  // template: '<App/>'
})

// Vue.use(MikkoApi, app)
