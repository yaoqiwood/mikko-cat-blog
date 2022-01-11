import Util from '@/utils/Util'
import UrlConstants from '@/constants/UrlConstants'

export default {
  searchItem (params) {
    return Util.httpPost(UrlConstants.PASSAGES_URLS.POST_SEARCH_ITEMS_URL, params)
  },
  /**
   * 高级搜索适用
   * @param params
   * @returns {Promise | Promise<any>}
   */
  searchPassages (params) {
    return Util.httpPost(UrlConstants.PASSAGES_URLS.POST_ADVANCED_SEARCH_ITEMS_URL, params)
  },
  createItem (params) {
    return Util.httpPost(UrlConstants.PASSAGES_URLS.POST_CREATE_ITEMS_URL, params)
  },
  findById (params) {
    return Util.httpPost(UrlConstants.PASSAGES_URLS.POST_FIND_BY_ID_URL, params)
  },
  findItemTagsById (params) {
    return Util.httpPost(UrlConstants.PASSAGES_URLS.POST_FIND_ITEMS_TAGS_URL, params)
  },
  updateItemById (params) {
    return Util.httpPostJSON(UrlConstants.PASSAGES_URLS.POST_UPDATE_ITEM_BY_ID, params)
  },
  updatePassage (params) {
    return Util.httpPost(UrlConstants.PASSAGES_URLS.POST_UPDATE_PASSAGE, params)
  }

}
