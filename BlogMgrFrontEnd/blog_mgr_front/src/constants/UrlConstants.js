// main Urls
const MAIN_URLS = {
  GET_ALL_MENU_URL: 'permission/getMenu.action'
}

const LOGIN_URLS = {
  POST_LOGIN_URL: 'login.action',
  VERIFICATION_CODE_URL: 'verificationCode.action',
  POST_LOGOUT_URL: 'logout.action'
}

// 附件
const SYS_ANNEX_CONFIG_INFO_URLS = {
  // 附件MenharaItems 获取
  MENHARAITEMS_ID_LIST_POST: 'sysAnnexConfigInfo/getMenharaItems.action',
  // downloadImgById 获取Id
  DOWNLOAD_IMG_BY_ID_GET: 'sysAnnexConfigInfo/downloadImgById.action?id='
}

/**
 * 文章管理
 * @type {{POST_FIND_BY_ID_URL: string, POST_UPDATE_PASSAGE: string, POST_FIND_ITEMS_TAGS_URL: string,
 * POST_CREATE_ITEMS_URL: string, POST_SEARCH_ITEMS_URL: string, POST_UPDATE_ITEM_BY_ID: string,
 * POST_ADVANCED_SEARCH_ITEMS_URL: string}}
 */
const PASSAGES_URLS = {
  POST_SEARCH_ITEMS_URL: 'blog/blog-article/searchItems',
  POST_ADVANCED_SEARCH_ITEMS_URL: 'blog/blog-article/searchPassages',
  POST_CREATE_ITEMS_URL: 'blog/blog-article/createPassage',
  POST_FIND_BY_ID_URL: 'blog/blog-article/findItemById',
  POST_FIND_ITEMS_TAGS_URL: 'blog/blog-article/findPassageAndTagsById',
  POST_UPDATE_ITEM_BY_ID: 'blog/blog-article/updateItem',
  POST_UPDATE_PASSAGE: 'blog/blog-article/updatePassage'
}

/**
 * 文章草稿url
 * @type {{POST_FIND_EDIT_PASSAGE_DRAFT_URL: string, POST_SAVE_ADD_PASSAGE_DRAFT_URL: string, POST_FIND_ADD_PASSAGE_DRAFT_URL: string}}
 */
const PASSAGES_DRAFT_URLS = {
  POST_FIND_ADD_PASSAGE_DRAFT_URL: 'blog/blog-article-draft/findDraftAddPassage',
  POST_SAVE_ADD_PASSAGE_DRAFT_URL: 'blog/blog-article-draft/saveAddDraft',
  POST_FIND_EDIT_PASSAGE_DRAFT_URL: 'blog/blog-article-draft/findDraftOnEdit',
  POST_SAVE_EDIT_PASSAGE_DRAFT_URL: 'blog/blog-article-draft/saveEditDraft'
}

/**
 * 我的信息Url
 */
const MY_INF_FRAME_URL = {
  GET_PROFILE_BY_USER_TOKEN_URL: 'user/reviewUserProfile',
  GET_PROFILE_URL: 'user/reviewProfile',
  GET_USER_INF_WITH_IMG: 'user-inf/loadUserInfWithImg'
}

export default {
  MAIN_URLS,
  LOGIN_URLS,
  SYS_ANNEX_CONFIG_INFO_URLS,
  PASSAGES_URLS,
  PASSAGES_DRAFT_URLS,
  MY_INF_FRAME_URL
}
