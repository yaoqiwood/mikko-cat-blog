<template>
  <div class="container-frame">
    <div>
      <Row type="flex">
        <Col :xs="{span:24,offset:0,order:2}" :sm={span:20,offset:2,order:2} :md={span:12,offset:2,order:1}>
          <passages-box/>
        </Col>
        <Col :xs="{span:24,offset:0,order:1}" :sm="{span:20,offset:2,order:1}" :md="{span:7,offset:1,order:2}">
          <my-inf-frame :profileImg="profileImg"
                        :frameBg="frameBg"
                        :introduceSentence="introduceSentence"/>
          <passages-classify-box/>
          <comments-frame/>
        </Col>
      </Row>
    </div>
  </div>
</template>

<script>
import PassagesBox from './PassagesBox'
import MyInfFrame from './MyInfFrame'
import PassagesClassifyBox from './PassagesClassifyBox'
import CommentsFrame from './CommentsFrame'

export default {
  props: {
    profileImg: {
      type: Object,
      default: () => {}
    },
    frameBg: {
      type: Object,
      default: () => {}
    },
    introduceSentence: {
      type: String,
      default: ''
    }
  },
  name: 'ContainerFrame',
  components: {
    PassagesBox,
    MyInfFrame,
    PassagesClassifyBox,
    CommentsFrame
  }
}
</script>

<style lang="less" scoped>
  @import "../css/FrontPage.less";
  @import "../css/PassagesBox";
</style>
