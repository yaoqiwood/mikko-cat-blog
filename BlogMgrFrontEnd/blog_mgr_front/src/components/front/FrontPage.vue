<template>
  <div>
    <div class="top-frame">
      <div class="top-frame-bar">
        <div class="top-frame-bar-items">
          <div v-for="(item,index) in menuItems"
               :key="index">{{item.name}}
          </div>
        </div>
      </div>
      <div class="top-frame-title">
        <span>{{topFrameTitle}}</span>
      </div>
    </div>
    <div class="content-frame">
      <container-frame :profileImg="profileImg"
                       :frameBg="frameBg"
                       :introduceSentence="introduceSentence"/>
    </div>
    <!-- <live2dComponents/> -->
  </div>
</template>

<script>
import ItemsConstants from './items/ItemsConstants'
// import Live2dComponents from '../widgets/live2d/Live2dComponents'
import ContainerFrame from './widgets/ContainerFrame'
import api from '@/api/front/myInfFrameApi/MyInfFrameApi'
import frontApi from '@/api/front/frontPageApi/FrontPageApi'

export default {
  name: 'frontPage',
  data: () => {
    return {
      menuItems: ItemsConstants.TOP_BAR_ITEMS,
      profileImg: {},
      frameBg: {},
      topFrameTitle: '',
      introduceSentence: ''
    }
  },
  mounted () {
    this.getProfile()
    this.getMyInfWithFrameBg()
  },
  methods: {
    getProfile () {
      api.getProfileByUser().then(resp => {
        let base64Code = 'data:image/png;base64,' + btoa(
          new Uint8Array(resp).reduce((data, byte) => data + String.fromCharCode(byte), '')
        )
        this.profileImg = { 'background-image': 'url(' + base64Code }
      })
    },
    getMyInfWithFrameBg () {
      frontApi.getMyInfWithFrameBg().then(resp => {
        this.frameBg = {'background-image': 'url(data:image/png;base64,' + resp.data.infFrameBackgroundImgBase64Code}
        this.topFrameTitle = resp.data.userBlogTitleWord
        this.introduceSentence = resp.data.userIntroduceWord
      })
    }
  },
  components: {
    // Live2dComponents,
    ContainerFrame
  }
}
</script>

<style lang="less" scoped>
  @import 'css/FrontPage.less';
</style>
