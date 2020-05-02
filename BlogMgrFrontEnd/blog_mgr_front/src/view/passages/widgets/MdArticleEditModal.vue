<template>
  <div>
    <Modal v-model="isOpen"
           title="编辑博文"
           draggable
           :closable="false"
           :styles="{top: '35px'}"
           :z-index="999"
           :width="1300">
      <div style="height:500px;overflow-y:auto">
        <Form :model="dataModel">
          <FormItem label="标题："
                    prop="baTitle"
                    :label-width="60">
            <Input v-model="dataModel.baTitle"/>
          </FormItem>
        </Form>
        <mavon-editor v-model="dataModel.baContent"
                      @save="onDraftManualSave"
                      style="min-height:440px"/>
      </div>
      <div slot="footer">
        <Button @click="onCancel">取消</Button>
        <Button @click="onOk"
                type="primary">下一步
        </Button>
      </div>
    </Modal>
    <passage-update-confirm-modal ref="passageUpdateConfirmModal"
                                  @onPassageUpdateConfirm="onPassageUpdateConfirm"/>
  </div>
</template>

<script>
import PassageUpdateConfirmModal from './PassageUpdateConfirmModal'
import ENUM from '@/constants/Enum'

export default {
  name: 'MdArticleEditModal',
  data: () => {
    return {
      isOpen: false,
      dataModel: {
        baTitle: '',
        baContent: '',
        tagList: []
      }
    }
  },
  methods: {
    onOk () {
      if (!this.dataModel.baTitle) {
        this.$Message.warning({content: '博客标题不可为空'})
        return
      } else if (this.dataModel.baTitle.length >= 30) {
        this.$Message.warning({content: '标题文字字符不可多余20'})
        return
      } else if (!this.dataModel.baContent) {
        this.$Message.warning({content: '内容不可为空'})
        return
      }
      this.nextStep()
    },
    onCancel () {
      this.openModal(false)
      this.clearTagList()
      this.cleanFormItem()
    },
    clearTagList () {
      this.$refs['passageUpdateConfirmModal'].clearTagList()
    },
    cleanFormItem () {
      this.dataModel = {
        baTitle: '',
        baContent: ''
      }
    },
    openModal (val) {
      this.isOpen = val
    },
    nextStep () {
      this.$refs['passageUpdateConfirmModal'].isOpen = true
    },
    onPassageUpdateConfirm (formItem) {
      let passageJSON = JSON.stringify({
        id: this.dataModel.articleId,
        baTitle: this.dataModel.baTitle,
        baContent: this.dataModel.baContent,
        baBlockComment: formItem.baBlockComment ? ENUM.ENUM_BLOCK_COMMENT.YES.code : ENUM.ENUM_BLOCK_COMMENT.NO.code,
        baStatus: formItem.baStatus ? ENUM.ENUM_BLOCK_COMMENT.YES.code : ENUM.ENUM_BLOCK_COMMENT.NO.code
      })
      let tagsJSON = JSON.stringify(formItem.tagList)
      this.$emit('onPassageUpdateConfirm', {passageJSON: passageJSON, tagsJSON: tagsJSON})
    },
    onConfirmSucThenClose () {
      this.$refs['passageUpdateConfirmModal'].onCancel()
      this.dataModel.baTitle = ''
      this.dataModel.baContent = ''
      this.onCancel()
    },
    onDraftManualSave () {
      this.$Modal.confirm({
        title: '提示',
        content: '确认保存？',
        onOk: () => {
          let json = {
            id: this.dataModel.draftId,
            badBlogArticleId: this.dataModel.articleId,
            badTitle: this.dataModel.baTitle,
            badContent: this.dataModel.baContent
          }
          this.$emit('saveEditDraft', json)
        }
      })
    },
    loadEditTags () {
      this.$refs['passageUpdateConfirmModal'].formItem.tagList = this.dataModel.tagList
      this.$refs['passageUpdateConfirmModal'].formItem.baStatus = this.dataModel.baStatus === ENUM.TRUE_OR_FALSE.YES.code
      this.$refs['passageUpdateConfirmModal'].formItem.baBlockComment = this.dataModel.baBlockComment === ENUM.TRUE_OR_FALSE.YES.code
    }
  },
  components: {
    PassageUpdateConfirmModal
  }
}
</script>

<style lang="less" scoped>
  .vertical-center-modal {
    display: flex;
    align-items: center;
    justify-content: center;

    .ivu-modal {
      top: 0;
    }

  }
</style>
