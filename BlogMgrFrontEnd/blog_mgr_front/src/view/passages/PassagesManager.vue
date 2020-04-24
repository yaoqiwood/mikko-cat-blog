<template>
  <div>
    <passages-search-form @writeBlog="writeBlog"
                          @onSearch="search"
                          @onReset="resetTable"/>
    <passages-table :data=tableData
                    :total="total"/>
    <md-editor-modal ref="mdEditorModal"
                     @onPassagesConfirm="onPassagesConfirm"/>
  </div>
</template>

<script>
import PassagesSearchForm from './PassagesSearchForm'
import PassagesTable from './PassagesTable'
import PassagesApi from '@/api/passages/Passages'
import MdEditorModal from './widgets/MdEditorModal'

export default {
  data: () => {
    return {
      params: {},
      currentPage: 1,
      rows: 10,
      total: 0,
      tableData: []
    }
  },
  methods: {
    search (val) {
      this.params = Object.assign(val)
      this.loadData(this.params)
    },
    loadData (params) {
      this.$Spin.show()
      PassagesApi.searchItem({
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
    }
  },
  mounted () {
    this.loadData({})
  },
  components: {
    PassagesSearchForm,
    PassagesTable,
    MdEditorModal
  }
}
</script>

<style lang="less" scoped>
</style>
