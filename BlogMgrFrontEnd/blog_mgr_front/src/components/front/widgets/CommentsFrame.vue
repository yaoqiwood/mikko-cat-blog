<template>
  <div class="comments-frame">
    <div class="comments-frame-box">
      <span class="comments-frame-box-title">最新评论</span>
      <hr class="hr-line-style">
      <div class="comments-frame-box-inner-frame">
        <div class="comments-frame-box-inner-frame-box">
          <div>
            <a href="javascript:void(0)">评论</a>
            <br/>
            <div>
              <span>最新评论</span>
            </div>
            <div style="text-align: right">
              <span>--ll1231231323ll</span>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'CommentsFrame'
}
</script>

<style lang="less" scoped>
  @import "../css/CommentsFrame";
</style>
