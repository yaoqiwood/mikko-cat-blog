<template>
  <Form :label-width="120"
        class="form-view">
    <Row>
      <Col :span="8">
        <FormItem label="查看次数累计：">
          <Input v-model="dataModel.baViewCount"
                 :disabled="true"/>
        </FormItem>
      </Col>
      <Col :span="8">
        <FormItem label="评论数：">
          <Input v-model="dataModel.baCommentCount"
                 :disabled="true"/>
        </FormItem>
      </Col>
      <Col :span="8">
        <FormItem label="按赞总数：">
          <Input v-model="dataModel.baLikeCount"
                 :disabled="true"/>
        </FormItem>
      </Col>
    </Row>
    <Row>
      <Col :span="8">
        <FormItem label="是否允许评论：">
          <Input v-model="dataModel.baBlockComment"
                 :disabled="true"/>
        </FormItem>
      </Col>
      <Col :span="8">
        <FormItem label="状态：">
          <Input v-model="dataModel.baStatus"
                 :disabled="true"/>
        </FormItem>
      </Col>
      <Col :span="8">
        <FormItem label="创建时间：">
          <Input v-model="dataModel.baCreateTime"
                 :disabled="true"/>
        </FormItem>
      </Col>
    </Row>
    <Row>
      <Col :span="8">
        <FormItem label="更新时间：">
          <Input v-model="dataModel.baCreateTime"
                 :disabled="true"/>
        </FormItem>
      </Col>
    </Row>
    <Row>
      <Col :span="24">
        <FormItem label="标签：">
          <span v-if="dataModel.tagList.length">
            <Tag
              v-for="item in dataModel.tagList"
              :color="item.btTagColor"
              :key="item.id">{{item.btTagName}}
            </Tag>
          </span>
          <span v-else>暂无数据</span>
        </FormItem>
      </Col>
    </Row>
  </Form>
</template>

<script>
export default {
  name: 'ViewInfForm',
  props: {
    dataModel: {
      type: Object
    }
  },
  data: () => {
    return {}
  }
}
</script>

<style lang="less" scoped>
  .form-view {
    padding-right: 18px;
  }
</style>
