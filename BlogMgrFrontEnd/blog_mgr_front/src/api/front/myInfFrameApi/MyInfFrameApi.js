import UrlConstants from '@/constants/UrlConstants'
import NetConstants from '@/constants/NetConstants'
import Util from '@/utils/Util'

let getProfileByUser = () => Util.httpGetWithHeader(UrlConstants.MY_INF_FRAME_URL.GET_PROFILE_URL, NetConstants.RESPONSE_TYPE_BUFFER_ARRAY)
const install = {
  getProfileByUser
}

export default install
