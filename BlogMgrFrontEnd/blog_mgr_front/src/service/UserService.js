import CookieService from './CookieService'
import LoginApi from '@/api/login/Login'
import MD5Util from '@/utils/MD5Util'
import Constants from '@/constants/SystemConstants'
import TokenConstants from '@/constants/Constants'
import RouterUtil from '@/router/routersUtil'
import RouterUrls from '@/router/routersUrl'

export default {
  login (params) {
    return new Promise(resolve => {
      let jsonParams = Object.assign({}, params)
      let md5First = MD5Util.genMD5(params.password).toUpperCase() + Constants.SUFFIX
      let password = MD5Util.genMD5(md5First).toUpperCase()
      jsonParams.password = password
      LoginApi.login(jsonParams).then(resp => {
        resolve(resp)
      })
    })
  },
  isLoginCheck () {
    return CookieService.isUserTokenKeyExist(TokenConstants.TOKEN_COOKIE)
  },
  getLoginStatus () {
    CookieService.mountUserToken()
  },
  initUserInf () {
    return CookieService.getCookie(TokenConstants.CURRENT_USER)
  },
  userLogout () {
    // 清除所有相关Cookies
    CookieService.userLogout()
    // 跳转登录页面
    RouterUtil.routerReplace(RouterUrls.NLogin)
  }
}
