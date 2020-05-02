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

/**
 * 文章管理
 * @type {{POST_FIND_BY_ID_URL: string, POST_UPDATE_PASSAGE: string, POST_FIND_ITEMS_TAGS_URL: string,
 * POST_CREATE_ITEMS_URL: string, POST_SEARCH_ITEMS_URL: string, POST_UPDATE_ITEM_BY_ID: string,
 * POST_ADVANCED_SEARCH_ITEMS_URL: string}}
 */
const PASSAGES_URLS = {
  POST_SEARCH_ITEMS_URL: NET_CONSTANTS.PROJECT_NAME_PATH + 'blog/blog-article/searchItems',
  POST_ADVANCED_SEARCH_ITEMS_URL: NET_CONSTANTS.PROJECT_NAME_PATH + 'blog/blog-article/searchPassages',
  POST_CREATE_ITEMS_URL: NET_CONSTANTS.PROJECT_NAME_PATH + 'blog/blog-article/createPassage',
  POST_FIND_BY_ID_URL: NET_CONSTANTS.PROJECT_NAME_PATH + 'blog/blog-article/findItemById',
  POST_FIND_ITEMS_TAGS_URL: NET_CONSTANTS.PROJECT_NAME_PATH + 'blog/blog-article/findPassageAndTagsById',
  POST_UPDATE_ITEM_BY_ID: NET_CONSTANTS.PROJECT_NAME_PATH + 'blog/blog-article/updateItem',
  POST_UPDATE_PASSAGE: NET_CONSTANTS.PROJECT_NAME_PATH + 'blog/blog-article/updatePassage'
}

/**
 * 文章草稿url
 * @type {{POST_FIND_EDIT_PASSAGE_DRAFT_URL: string, POST_SAVE_ADD_PASSAGE_DRAFT_URL: string, POST_FIND_ADD_PASSAGE_DRAFT_URL: string}}
 */
const PASSAGES_DRAFT_URLS = {
  POST_FIND_ADD_PASSAGE_DRAFT_URL: NET_CONSTANTS.PROJECT_NAME_PATH + 'blog/blog-article-draft/findDraftAddPassage',
  POST_SAVE_ADD_PASSAGE_DRAFT_URL: NET_CONSTANTS.PROJECT_NAME_PATH + 'blog/blog-article-draft/saveAddDraft',
  POST_FIND_EDIT_PASSAGE_DRAFT_URL: NET_CONSTANTS.PROJECT_NAME_PATH + 'blog/blog-article-draft/findDraftOnEdit',
  POST_SAVE_EDIT_PASSAGE_DRAFT_URL: NET_CONSTANTS.PROJECT_NAME_PATH + 'blog/blog-article-draft/saveEditDraft'
}

export default {
  MAIN_URLS,
  LOGIN_URLS,
  SYS_ANNEX_CONFIG_INFO_URLS,
  PASSAGES_URLS,
  PASSAGES_DRAFT_URLS
}
