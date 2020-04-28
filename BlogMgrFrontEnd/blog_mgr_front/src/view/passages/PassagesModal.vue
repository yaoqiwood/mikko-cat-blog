<template>
  <div>
    <Modal v-model="isOpen"
           :width="modalWidth"
           @on-visible-change="onVisibleChange">
      <div>
        <Tabs v-model="tabName"
              @on-click="onTabClick">
          <TabPane label="文章内容"
                   name="passagesContent">
            <div class="passage-title">
              <div>
                <span>{{dataModel.baTitle}}</span>
              </div>
              <mavon-editor :toolbarsFlag="false"
                            :subfield="false"
                            :boxShadow="false"
                            defaultOpen="preview"
                            v-model="dataModel.baContent"/>
            </div>
          </TabPane>
          <TabPane label="其他信息"
                   name="passageInf">
            <view-inf-form :dataModel="dataModel"
                           class="view-form"/>
          </TabPane>
        </Tabs>
      </div>
      <div slot="footer">
        <Button @click="cancel">返回</Button>
      </div>
    </Modal>
  </div>
</template>
<script>
import ViewInfForm from './widgets/form/ViewInfForm'

export default {
  name: 'passagesModal',
  props: {
    dataModel: {
      type: Object,
      default: () => {
        return {
          tagList: []
        }
      }
    }
  },
  data: () => {
    return {
      isOpen: false,
      modalWidth: 1200,
      tabName: 'passagesContent'
    }
  },
  methods: {
    openModal () {
      this.isOpen = true
    },
    closeModal () {
      this.isOpen = false
    },
    cancel () {
      this.closeModal()
    },
    onVisibleChange (val) {
      // 当窗口不可见时运行
      if (!val) {
        this.$emit('cleanViewDataModel')
        this.tabName = 'passagesContent'
      }
    },
    onTabClick (val) {
      if (val === 'passageInf') {
        this.modalWidth = 1000
      } else {
        this.modalWidth = 1200
      }
    }
  },
  components: {
    ViewInfForm
  }
}

</script>

<style lang="less" scoped>
  .passage-title {
    text-align: center;
    font-size: 20px;
    min-height: 350px;
    max-height: 450px;
    overflow-y: auto;
  }

  .passage-title div {
    padding-bottom: 20px;
    padding-top: 3px;
  }

  .view-form {
    padding-top: 25px;
  }
</style>
