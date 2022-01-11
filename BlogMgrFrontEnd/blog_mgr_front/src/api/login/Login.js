import Util from '@/utils/Util'
import UrlConstants from '@/constants/UrlConstants'
import NetConstants from '@/constants/NetConstants'

export default {
  getVerificationCodeImgSrc () {
    return NetConstants.PROJECT_NAME_PATH + UrlConstants.LOGIN_URLS.VERIFICATION_CODE_URL + '?' + Math.random()
  },
  login (params) {
    return Util.httpPostJSON(UrlConstants.LOGIN_URLS.POST_LOGIN_URL, params)
  },
  logout () {
    return Util.httpPost(UrlConstants.LOGIN_URLS.POST_LOGOUT_URL)
  }
}
