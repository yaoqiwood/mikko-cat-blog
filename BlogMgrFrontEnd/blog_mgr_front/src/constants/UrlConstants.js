import NET_CONSTANTS from './NetConstants'

// main Urls
const MAIN_URLS = {
  GET_ALL_MENU_URL: NET_CONSTANTS.PROJECT_NAME_PATH + 'permission/getMenu.action'
}

const LOGIN_URLS = {
  POST_LOGIN_URL: NET_CONSTANTS.PROJECT_NAME_PATH + 'login.action',
  VERIFICATION_CODE_URL: NET_CONSTANTS.PROJECT_NAME_PATH + 'verificationCode.action',
  POST_LOGOUT_URL: NET_CONSTANTS.PROJECT_NAME_PATH + 'logout.action'
}

// 附件
const SYS_ANNEX_CONFIG_INFO_URLS = {
  // 附件MenharaItems 获取
  MENHARAITEMS_ID_LIST_POST: NET_CONSTANTS.PROJECT_NAME_PATH + 'sysAnnexConfigInfo/getMenharaItems.action',
  // downloadImgById 获取Id
  DOWNLOAD_IMG_BY_ID_GET: NET_CONSTANTS.PROJECT_NAME_PATH + 'sysAnnexConfigInfo/downloadImgById.action?id='
}

// 文章管理
const PASSAGES_URLS = {
  POST_SEARCH_ITEMS_URL: NET_CONSTANTS.PROJECT_NAME_PATH + 'blogManager/blog-article/searchItems'
}

export default {
  MAIN_URLS,
  LOGIN_URLS,
  SYS_ANNEX_CONFIG_INFO_URLS,
  PASSAGES_URLS
}
