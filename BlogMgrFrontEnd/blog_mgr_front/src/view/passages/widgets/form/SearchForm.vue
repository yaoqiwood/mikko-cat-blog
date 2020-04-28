<template>
  <div class="form-center">
    <Form inline
          :label-width="110">
      <Row type="flex" justify="center">
        <Col :span="8">
          <FormItem label="文章标题：">
            <Input v-model="searchFormItems.baTitle"
                   placeholder="请输入文章标题"/>
          </FormItem>
        </Col>
        <Col :span="8">
          <FormItem label="创建时间开始：">
            <DatePicker type="datetime"
                        v-model="searchFormItems.baCreateTimeBegin"
                        placeholder="请选择开始创建时间"/>
          </FormItem>
        </Col>
        <Col :span="8">
          <FormItem label="创建时间结束：">
            <DatePicker type="datetime"
                        v-model="searchFormItems.baCreateTimeEnd"
                        placeholder="请选择结束创建时间"/>
          </FormItem>
        </Col>
      </Row>
    </Form>
  </div>
</template>

<script>
export default {
  name: 'SearchForm.vue',
  props: {
    value: Object
  },
  data: () => {
    return {
      searchFormItems: {
        baCreateTimeBegin: '',
        baCreateTimeEnd: ''
      }
    }
  },
  watch: {
    value: {
      handler (val) {
        this.searchFormItems = val
      },
      deep: true,
      immediate: true
    }
  }
}
</script>

<style lang="less" scoped>
  .form-center {
    display: flex;
    padding-right: 70px;
    margin-top: 15px;
    justify-content: center;
    width: 1000px;
  }
</style>
