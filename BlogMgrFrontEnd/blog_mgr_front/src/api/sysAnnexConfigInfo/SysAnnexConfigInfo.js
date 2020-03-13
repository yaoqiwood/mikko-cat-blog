import Util from '@/utils/Util'
import UrlConstants from '@/constants/UrlConstants'

export default {
  getMenharaItems () {
    return Util.httpPost(UrlConstants.SYS_ANNEX_CONFIG_INFO_URLS.MENHARAITEMS_ID_LIST_POST)
  },
  downloadImgByIdUrl () {
    return UrlConstants.SYS_ANNEX_CONFIG_INFO_URLS.DOWNLOAD_IMG_BY_ID_GET
  }
}
