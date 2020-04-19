// 首页
const RIndexMainUrl = '/back-manager/'
const NIndexMain = 'mainPage'
// login
const RLoginUrl = '/login'
const NLogin = 'login'
const MLogin = {
  bread: [
    { name: '首頁', icons: 'md-home' }
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
    { name: '首頁', url: RIndexMainUrl, icons: 'md-home' },
    { name: '文章管理' }
  ]
}
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
  MLogin
}
