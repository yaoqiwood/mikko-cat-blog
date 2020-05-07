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
        <span>柴甜橘的博客</span>
      </div>
    </div>
    <div class="content-frame">
      <container-frame/>
    </div>
    <live2dComponents/>
  </div>
</template>

<script>
import ItemsConstants from './items/ItemsConstants'
import Live2dComponents from '../widgets/live2d/Live2dComponents'
import ContainerFrame from './widgets/ContainerFrame'

export default {
  name: 'frontPage',
  data: () => {
    return {
      menuItems: ItemsConstants.TOP_BAR_ITEMS
    }
  },
  components: {
    Live2dComponents,
    ContainerFrame
  }
}
</script>

<style lang="less" scoped>
  @import 'css/FrontPage.less';
</style>
