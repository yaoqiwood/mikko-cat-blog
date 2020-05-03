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
    </div>
  </div>
</template>

<script>
import ItemsConstants from './items/ItemsConstants'

export default {
  name: 'frontPage',
  data: () => {
    return {
      menuItems: ItemsConstants.TOP_BAR_ITEMS
    }
  }
}
</script>

<style lang="less" scoped>
  @import 'css/FrontPage.less';
</style>
