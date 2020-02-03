// urls
import Urls from './routersUrl'

// components
// main
import MainIndex from '@/components/main/'
// login
import Login from '@/components/loginPage/Login'

// index
const MainComponent = {
  path: Urls.RIndexMainUrl,
  name: Urls.NIndexMain,
  component: MainIndex
}
// login
const LoginComponent = {
  path: Urls.RLoginUrl,
  name: Urls.NLogin,
  component: Login
}

export default [MainComponent, LoginComponent]
