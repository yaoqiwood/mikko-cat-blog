import Util from '@/utils/Util'
import UrlConstants from '@/constants/UrlConstants'

export default {
  getVerificationCodeImgSrc () {
    return UrlConstants.LOGIN_URLS.VERIFICATION_CODE_URL + '?' + Math.random()
  },
  login (params) {
    return Util.httPost(UrlConstants.LOGIN_URLS.POST_LOGIN_URL, params)
  }
}
