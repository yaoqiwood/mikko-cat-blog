<template>
  <div>
    <Collapse v-model="key">
      <Panel :name="'true'">
        <div class="backImgDiv"
             slot="content"></div>
      </Panel>
    </Collapse>
  </div>
</template>
<script>
export default {
  data: () => {
    return {
      key: 'false'
    }
  }
}
</script>
<style lang="less" scoped>
@import url("./less/MainCollapse");
</style>
