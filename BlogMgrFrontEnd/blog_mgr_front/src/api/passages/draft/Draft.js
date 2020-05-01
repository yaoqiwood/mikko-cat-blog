import Util from '@/utils/Util'
import UrlConstants from '@/constants/UrlConstants'

export default {
  findDraftAddPassage () {
    return Util.httpPost(UrlConstants.PASSAGES_DRAFT_URLS.POST_FIND_ADD_PASSAGE_DRAFT_URL)
  },
  saveAddDraft (params) {
    return Util.httpPostJSON(UrlConstants.PASSAGES_DRAFT_URLS.POST_SAVE_ADD_PASSAGE_DRAFT_URL, params)
  }
}
