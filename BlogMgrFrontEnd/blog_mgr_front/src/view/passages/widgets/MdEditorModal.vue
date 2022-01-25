<template>
  <div>
    <Modal v-model="isOpen"
           title="写博客"
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
                      ref="md"
                      @imgAdd="$imgAdd"
                      @imgDel="$imgDel"
                      :transition="true"
                      toolbarsBackground="#8570b3"
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
    <passages-confirm-modal ref="passagesConfirmModal"
                            @onPassagesConfirm="onPassagesConfirm"/>
  </div>
</template>

<script>
import PassagesConfirmModal from './PassagesConfirmModal'
import ENUM from '@/constants/Enum'
export default {
  data: () => {
    return {
      isOpen: false,
      dataModel: {
        baTitle: '',
        baContent: ''
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
      this.clearEditorForm()
      this.clearTagList()
    },
    clearTagList () {
      this.$refs['passagesConfirmModal'].clearTagList()
    },
    openModal (val) {
      this.isOpen = val
    },
    nextStep () {
      this.$refs['passagesConfirmModal'].isOpen = true
    },
    onPassagesConfirm (formItem) {
      let passageJSON = JSON.stringify({
        baTitle: this.dataModel.baTitle,
        baContent: this.dataModel.baContent,
        baBlockComment: formItem.baBlockComment ? ENUM.ENUM_BLOCK_COMMENT.YES.code : ENUM.ENUM_BLOCK_COMMENT.NO.code,
        baStatus: formItem.baStatus ? ENUM.ENUM_BLOCK_COMMENT.YES.code : ENUM.ENUM_BLOCK_COMMENT.NO.code
      })
      let tagsJSON = JSON.stringify(formItem.tagList)
      // 获取图片上传队列
      // console.log(this.$refs['md'].getUploadImgList())
      var formData = new FormData()
      let uploadImgList = this.$refs['md'].getUploadImgList()
      for (const key in uploadImgList) {
        formData.append('imgFiles', uploadImgList[key][1])
      }
      console.log(formData.get('imgFiles'))
      this.$emit('onPassagesConfirm', {passageJSON: passageJSON, tagsJSON: tagsJSON}, formData)
    },
    onConfirmSucThenClose () {
      this.$refs['passagesConfirmModal'].onCancel()
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
            badTitle: this.dataModel.baTitle,
            badContent: this.dataModel.baContent
          }
          this.$emit('onDraftManualSave', json)
        }
      })
    },
    clearEditorForm () {
      this.dataModel = {}
    },
    $imgAdd (pos, $file) {
      // console.log($file)
      // var formData = new FormData()
      // formData.append('imgFile', $file)
      // console.log(formData.get('imgFile'))
      // this.$emit('imgAdd', formData)
    },
    $imgDel () {
      console.log('del')
    }
  },
  components: {
    PassagesConfirmModal
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

  /deep/ .v-note-wrapper .v-note-op .v-left-item .op-icon, .v-note-wrapper .v-note-op .v-right-item .op-icon{
    color: #000000 !important;
  }

  /deep/ .v-right-item transition{
    button{
      color: #000000;
    }
  }

</style>
