<template>
  <div class="passages-classify-frame">
    <div class="passages-classify-frame-inner-box">
      <Tabs value="newPassages">
        <TabPane label="最新文章" name="newPassages">
          <div v-for="(item,index) in 5"
               :key="index">
            <Icon type="ios-book"/>
            <a href="javascript:void(0)">新文章</a>
            <hr class="hr-line-style"/>
          </div>
        </TabPane>
        <TabPane label="热点文章" name="hotPassages">标签二的内容</TabPane>
        <TabPane label="随机文章" name="randomPassages">标签三的内容</TabPane>
      </Tabs>
    </div>
  </div>
</template>

<script>
export default {
  name: 'PassageClassifyBox'
}
</script>

<style lang="less" scoped>
  @import "../css/PassagesClassifyBox";
</style>
