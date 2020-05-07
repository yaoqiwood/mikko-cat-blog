<template>
  <div class="container-frame">
    <div class="container-frame-inner-box">
      <passages-box/>
    </div>
  </div>
</template>

<script>
import PassagesBox from './PassagesBox'

export default {
  name: 'ContainerFrame',
  components: {
    PassagesBox
  }
}
</script>

<style lang="less" scoped>
  @import "../css/FrontPage.less";
</style>
