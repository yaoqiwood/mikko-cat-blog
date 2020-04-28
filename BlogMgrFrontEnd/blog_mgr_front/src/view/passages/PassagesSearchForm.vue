<template>
  <div>
    <advanced-search-form ref="advancedSearchForm"
                          @search="onSearch"
                          @resetSearchForm="resetSearchForm">
      <template slot="searchForm">
        <search-form v-model="formItem"/>
      </template>
    </advanced-search-form>
    <Form :model="formItem"
          :label-width="80"
          inline>
      <Row>
        <Col :md="5">
          <FormItem label="文章标题：">
            <Input v-model="formItem.baTitle"
                   placeholder="请输入文章标题">
            </Input>
          </FormItem>
        </Col>
        <Button type="primary"
                style="margin-left:10px"
                @click="onSearch"
                icon="ios-search">搜索
        </Button>
        <Button style="margin-left:10px"
                @click="onReset"
                icon="md-refresh">重置
        </Button>
        <Button style="margin-left: 10px"
                type="info"
                @click="onAdvancedSearch">
          高级搜索
        </Button>
        <Button type="primary"
                @click="writeBlog"
                style="float:right"
                icon="md-add">写博客
        </Button>
      </Row>
    </Form>
  </div>
</template>

<script>
import AdvancedSearchForm from '@/components/table/advancedSearchForm/AdvancedSearchForm'
import SearchForm from './widgets/form/SearchForm'

export default {
  data: () => {
    return {
      formItem: {}
    }
  },
  methods: {
    writeBlog () {
      this.$emit('writeBlog')
    },
    onSearch () {
      this.$emit('onSearch', this.formItem)
    },
    onReset () {
      this.formItem = {}
      this.$emit('onReset')
    },
    onAdvancedSearch () {
      this.$refs['advancedSearchForm'].openSearchModal()
    },
    resetSearchForm () {
      this.onReset()
    }
  },
  components: {
    AdvancedSearchForm,
    SearchForm
  }
}
</script>

<style lang="less" scoped>
  .ivu-form-item {
    margin-bottom: 12px;
  }
</style>
