<template>
  <div>
    <Modal v-model="isOpen"
           title="确认发布？"
           :z-index="1000"
           :closable="false"
           :mask-closable="false">
      <div style="padding-top:20px;padding-left:10px">
        <Form label-position="right"
              :label-width="110">
          <FormItem label="文章是否可见：">
            <i-switch v-model="formItem.baStatus"
                      @on-change="onBaStatusChange"
                      size="large">
              <span slot="open">On</span>
              <span slot="close">Off</span>
            </i-switch>
          </FormItem>
          <FormItem label="是否允许评论："
                    v-if="formItem.baStatus">
            <i-switch v-model="formItem.baBlockComment"
                      size="large">
              <span slot="open">On</span>
              <span slot="close">Off</span>
            </i-switch>
          </FormItem>
          <FormItem label="标签：">
            <span v-if="!formItem.tagList.length">暂无标签</span>
            <Tag v-for="(item,index) in formItem.tagList"
                 :key="index"
                 closable
                 type="border"
                 :name="item.btTagName"
                 @on-close="handleCloseTag"
                 :color="item.btTagColor">
              {{item.btTagName}}
            </Tag>
          </FormItem>
          <FormItem>
            <Input type="text"
                   style="width:180px;margin-right:5px"
                   @on-change="onInputTagNameChange"
                   v-model="inputTagName"/>
            <Button @click="addTag">添加新标签</Button>
            <div>
              <span style="color:#ff0000">{{warningText.tagWarningText}}</span>
            </div>
          </FormItem>
        </Form>
      </div>
      <div slot="footer">
        <Button @click="onCancel">取消</Button>
        <Button type="primary"
                @click="onOk">确定
        </Button>
      </div>
    </Modal>
  </div>
</template>

<script>
import Util from '@/utils/Util'

export default {
  data: () => {
    return {
      isOpen: false,
      formItem: {
        baStatus: true,
        baBlockComment: true,
        tagList: []
      },
      inputTagName: '',
      warningText: {
        tagWarningText: ''
      },
      isBlockTag: false
    }
  },
  methods: {
    openModal (val) {
      this.isOpen = val
    },
    onBaStatusChange (val) {
      if (!val) {
        this.formItem.baBlockComment = true
      }
    },
    addTag () {
      if (this.isBlockTag || this.inputTagName.length === 0) {
        return
      }
      if (!this.checkTagName(this.inputTagName)) {
        this.warningText.tagWarningText = '标签名不可重复'
        return
      }
      this.formItem.tagList.push({btTagName: this.inputTagName, btTagColor: Util.colorRandom().COLOR_VALUE})
      this.inputTagName = ''
    },
    onCancel () {
      this.inputTagName = ''
      this.isOpen = false
      this.clearTagName()
    },
    clearTagList () {
      this.formItem.tagList = []
    },
    onInputTagNameChange () {
      if (this.inputTagName.length > 5) {
        this.warningText.tagWarningText = '标签文字不可超过5个字符'
        this.isBlockTag = true
      } else {
        this.clearTagName()
      }
    },
    clearTagName () {
      this.warningText.tagWarningText = ''
      this.isBlockTag = false
    },
    // 检测是否有重复的tagName
    checkTagName (val) {
      let ret = true
      this.formItem.tagList.forEach(item => {
        if (val === item.btTagName) {
          ret = false
        }
      })
      return ret
    },
    onOk () {
      this.$emit('onPassagesConfirm', this.formItem)
    },
    handleCloseTag (event, name) {
      let index = this.formItem.tagList.findIndex(item => item.btTagName === name)
      this.formItem.tagList.splice(index, 1)
    }
  }
}
</script>

<style lang="less" scoped>
</style>
