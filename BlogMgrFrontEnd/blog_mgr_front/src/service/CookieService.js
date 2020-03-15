import NetConstants from '@/constants/NetConstants'
import Constants from '@/constants/Constants'
import Vue from 'vue'

export default {
  initCookieConfig () {
    // 过期时间
    Vue.$cookies.config('7d')
  },
  saveCookie (key, value) {
    Vue.$cookies.set(key, value, Constants.EXPIRE_TIME)
  },
  getCookie (key) {
    return Vue.$cookies.get(key)
  },
  getUserToken (token) {
    NetConstants.POST_HEADERS.Authorization = token
    NetConstants.POSTJSON_HEADERS.Authorization = token
  },
  saveUserToken (token) {
    Vue.$cookies.set(Constants.TOKEN_COOKIE, token, Constants.EXPIRE_TIME)
  },
  saveAndGetToken (token) {
    this.saveUserToken(token)
    this.getUserToken(token)
  },
  mountUserToken () {
    if (!Vue.$cookies.isKey(Constants.TOKEN_COOKIE) || !Vue.$cookies.isKey(Constants.CURRENT_USER)) {
      throw new Error(Constants.TOKEN_COOKIE() + '||' + Constants.CURRENT_USER + '不存在 ')
    }
    this.getUserToken(Vue.$cookies.get(Constants.TOKEN_COOKIE))
  },
  isUserTokenKeyExist (cookieKey) {
    return Vue.$cookies.isKey(cookieKey)
  },
  userLogout () {
    Vue.$cookies.remove(Constants.TOKEN_COOKIE)
    this.getUserToken('')
  }
}
