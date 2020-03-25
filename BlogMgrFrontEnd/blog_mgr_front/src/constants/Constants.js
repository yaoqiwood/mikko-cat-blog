const TOKEN_COOKIE = 'token'
// 当前用户
const CURRENT_USER = 'currentUser'
//  过期天数
const EXPIRE_DAYS = 3
//  过期时间结果
const EXPIRE_TIME = 60 * 60 * 24 * EXPIRE_DAYS
// 主頁菜單按鈕類型
const MAIN_BUTTON_TYPE = {
  LOGOUT: 'logout'
}

export default {
  TOKEN_COOKIE, EXPIRE_TIME, CURRENT_USER, MAIN_BUTTON_TYPE
}
