import Util from '@/utils/Util'
import UrlConstants from '@/constants/UrlConstants'

export default {
  searchItem (params) {
    return Util.httpPost(UrlConstants.PASSAGES_URLS.POST_SEARCH_ITEMS_URL, params)
  },
  createItem (params) {
    return Util.httpPost(UrlConstants.PASSAGES_URLS.POST_CREATE_TIEMS_URL, params)
  }
}
