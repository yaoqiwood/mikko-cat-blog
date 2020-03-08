import NET_CONSTANTS from './NetConstants'
// main Urls
const MAIN_URLS = {
  GET_ALL_MENU_URL: NET_CONSTANTS.PROJECT_NAME_PATH + 'permission/getMenu.action'
}
const LOGIN_URLS = {
  POST_LOGIN_URL: NET_CONSTANTS.PROJECT_NAME_PATH + 'login.action',
  VERIFICATION_CODE_URL: NET_CONSTANTS.PROJECT_NAME_PATH + 'verificationCode.action'
}
export default {
  MAIN_URLS, LOGIN_URLS
}
