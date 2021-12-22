import UrlConstants from '@/constants/UrlConstants'
import Util from '@/utils/Util'

let getMyInfWithFrameBg = () => Util.httpGet(UrlConstants.MY_INF_FRAME_URL.GET_USER_INF_WITH_IMG)
const install = {
  getMyInfWithFrameBg
}

export default install
