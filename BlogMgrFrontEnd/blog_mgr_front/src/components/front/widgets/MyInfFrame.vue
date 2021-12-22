<template>
  <div>
    <div class="my-inf-frame-outer">
      <div class="my-inf-frame" :style="frameBg"/>
      <div class="my-inf-frame-inner-head-img"
          :style="profileImg"/>
      <span class="my-inf-frame-inner-span">{{introduceSentence}}</span>
      <!--      <span class="my-inf-frame-inner-span">一个在前端工程师里写Java最厉害，后端工程师里写前端最厉害的程序员</span>-->
    </div>
  </div>
</template>

<script>

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
  name: 'MyInfFrame',
  mounted () {
    // this.getProfile()
  },
  data: () => {
    return {
      // profileImg: {}
    }
  },
  methods: {
  }
}
</script>

<style lang="less" scoped>
  @import "../css/PassagesBox";
</style>
