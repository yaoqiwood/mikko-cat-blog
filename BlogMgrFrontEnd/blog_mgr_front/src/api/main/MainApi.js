import Util from '@/utils/Util'
import UrlConstants from '@/constants/UrlConstants'
export default {
  getAllMenuItem () {
    return Util.httpPost(UrlConstants.MAIN_URLS.GET_ALL_MENU_URL, {})
  }
}
