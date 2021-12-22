// 首页
const RIndexMainUrl = '/back-manager/'
const NIndexMain = 'mainPage'
// login
const RLoginUrl = '/login'
const NLogin = 'login'
const MLogin = {
  bread: [
    {name: '首頁', icons: 'ios-home'}
  ]
}
// NIndex
const RChartsUrl = '/back-manager/index-charts'
const NCharts = 'charts'
// NPassagesManager
const RPassagesManagerUrl = RIndexMainUrl + 'passagesManager'
const NPassagesManager = 'passages:manager'
const MPassagesManager = {
  bread: [
    {name: '首頁', url: RIndexMainUrl, icons: 'md-home'},
    {name: '文章管理'}
  ]
}

// NFrontPage
const RFrontPageUrl = '/'
const NFrontPage = 'frontPage'

// 404Page
const P404PageUrl = '*'
// const P404Page = '404NotFound'

export default {
  RIndexMainUrl,
  NIndexMain,
  RLoginUrl,
  NLogin,
  RChartsUrl,
  NCharts,
  RPassagesManagerUrl,
  NPassagesManager,
  MPassagesManager,
  MLogin,
  RFrontPageUrl,
  NFrontPage,
  P404PageUrl
}
