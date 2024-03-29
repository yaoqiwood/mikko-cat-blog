import NET_CONSTANTS from '@/constants/NetConstants'
import CookieService from '@/service/CookieService'

const install = (Vue) => {
  let $vm = new Vue()

  Vue.http.interceptors.push((request, next) => {
    request.headers.set('Authorization', CookieService.getToken())
    request.url = NET_CONSTANTS.PROJECT_NAME_PATH + request.url// 此处this为请求所在页面的Vue实例
    $vm.$Spin.show()
    // console.log(request)
    // modify request
    // request.method = 'POST'// 在请求之前可以进行一些预处理和配置 // continue to next interceptor
    next((response) => { // 在响应之后传给then之前对response进行修改和逻辑判断。对于token时候已过期的判断，就添加在此处，页面中任何一次http请求都会先调用此处方法 response.body = '...'; return response;
      $vm.$Spin.hide()
    })
  })
}

export default install
