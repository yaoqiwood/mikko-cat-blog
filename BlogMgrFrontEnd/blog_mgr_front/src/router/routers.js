// urls
import Urls from './routersUrl'
import RoutersComponents from './routersComponents'

// index
const MainComponent = {
  path: Urls.RIndexMainUrl,
  name: Urls.NIndexMain,
  component: RoutersComponents.MainIndex,
  meta: Urls.MLogin,
  children: [
    {
      path: Urls.RChartsUrl,
      name: Urls.NCharts,
      component: RoutersComponents.ChartsIndexPage
    },
    {
      path: Urls.RPassagesManagerUrl,
      name: Urls.NPassagesManager,
      component: RoutersComponents.PassagesManager,
      meta: Urls.MPassagesManager
    }
  ]
}
// login
const LoginComponent = {
  path: Urls.RLoginUrl,
  name: Urls.NLogin,
  component: RoutersComponents.Login
}

const FrontPageComponent = {
  path: Urls.RFrontPageUrl,
  name: Urls.NFrontPage,
  component: RoutersComponents.FrontPage
}

const P404PageComponent = {
  path: Urls.P404PageUrl,
  component: RoutersComponents.P404Page
}

export default [MainComponent, LoginComponent, FrontPageComponent, P404PageComponent]
