<template>
  <div>
    <passages-search-form @writeBlog="writeBlog"
                          @onSearch="search"
                          @onReset="resetTable"/>
    <passages-table :data=tableData
                    :total="total"
                    @openViewModal="openViewModal"
                    @deletePassage="deletePassage"/>
    <md-editor-modal ref="mdEditorModal"
                     @onPassagesConfirm="onPassagesConfirm"/>
    <passages-modal ref="passagesModal"
                    :dataModel="viewDataModel"
                    @cleanViewDataModel="cleanViewDataModel">
    </passages-modal>
  </div>
</template>

<script>
import PassagesSearchForm from './PassagesSearchForm'
import PassagesTable from './PassagesTable'
import PassagesApi from '@/api/passages/Passages'
import MdEditorModal from './widgets/MdEditorModal'
import PassagesModal from './PassagesModal'
import ENUM from '@/constants/Enum'

export default {
  data: () => {
    return {
      params: {},
      currentPage: 1,
      rows: 10,
      total: 0,
      tableData: [],
      viewDataModel: {
        tagList: []
      }
    }
  },
  methods: {
    search (val) {
      this.params = Object.assign(val)
      this.loadData(this.params)
    },
    loadData (params) {
      this.$Spin.show()
      params = this.cleanNullSearchParams(params)
      PassagesApi.searchPassages({
        page: this.currentPage,
        rows: this.rows,
        exampleJson: JSON.stringify(params)
      }).then(resp => {
        if (resp.success) {
          this.tableData = resp.data
          this.total = resp.total
          this.$Spin.hide()
        }
      })
    },
    resetTable () {
      this.currentPage = 1
      let params = {}
      this.loadData(params)
    },
    writeBlog () {
      this.$refs['mdEditorModal'].openModal(true)
    },
    onPassagesConfirm (jsonItem) {
      this.$Spin.show()
      PassagesApi.createItem(jsonItem).then(resp => {
        if (resp.success) {
          this.$Modal.success({title: '提示', content: '发布成功'})
          this.$refs['mdEditorModal'].onConfirmSucThenClose()
          this.resetTable()
        } else {
          this.$Modal.error({title: '失败', content: '发布失败:' + resp.message})
        }
        this.$Spin.hide()
      })
    },
    cleanNullSearchParams (params) {
      if (!params.baCreateTimeBegin) {
        delete params.baCreateTimeBegin
      }
      if (!params.baCreateTimeEnd) {
        delete params.baCreateTimeEnd
      }
      return params
    },
    openViewModal (id) {
      this.$refs['passagesModal'].openModal()
      this.findViewInfById(id)
    },
    findViewInfById (id) {
      this.$Spin.show()
      PassagesApi.findItemTagsById({id}).then(resp => {
        if (resp.success) {
          this.viewDataModel = resp.data.blogArticle
          this.$set(this.viewDataModel, 'tagList', resp.data.tagList)
        } else {
          this.$Modal.warning({
            title: '加载失败',
            content: resp.message
          })
        }
        this.$Spin.hide()
      })
    },
    cleanViewDataModel () {
      this.viewDataModel = {
        tagList: []
      }
    },
    deletePassage (id) {
      let json = {id: id, baStatus: ENUM.ENUM_BA_STATUS.DELETED.code}
      this.$Spin.show()
      PassagesApi.updateItemById(json).then(resp => {
        if (resp.success) {
          this.$Notice.success({
            title: '成功',
            desc: '删除成功'
          })
          this.loadData({})
        } else {
          this.$Notice.error({
            title: '失败',
            desc: '删除失败：' + resp.message
          })
        }
        this.$Spin.hide()
      })
    }
  },
  mounted () {
    this.loadData(this.params)
  },
  components: {
    PassagesSearchForm,
    PassagesTable,
    MdEditorModal,
    PassagesModal
  }
}
</script>

<style lang="less" scoped>
</style>
