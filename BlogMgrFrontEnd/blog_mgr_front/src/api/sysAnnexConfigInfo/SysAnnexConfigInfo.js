import Util from '@/utils/Util'
import UrlConstants from '@/constants/UrlConstants'
import NetConstants from '@/constants/NetConstants'

export default {
  getMenharaItems () {
    return Util.httpPost(UrlConstants.SYS_ANNEX_CONFIG_INFO_URLS.MENHARAITEMS_ID_LIST_POST)
  },
  downloadImgByIdUrl () {
    return NetConstants.PROJECT_NAME_PATH + UrlConstants.SYS_ANNEX_CONFIG_INFO_URLS.DOWNLOAD_IMG_BY_ID_GET
  },
  uploadImgFile (params) {
    return Util.httpPostFormData(UrlConstants.SYS_ANNEX_CONFIG_INFO_URLS.UPLOAD_IMG_FILE_POST, params)
  },
  uploadImgListFile (params) {
    return Util.httpPostFormData(UrlConstants.SYS_ANNEX_CONFIG_INFO_URLS.UPLOAD_IMG_LIST_FILE, params)
  }

}
