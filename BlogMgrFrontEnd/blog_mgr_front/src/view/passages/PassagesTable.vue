<template>
  <div>
    <Row>
      <Col :span="24">
        <Table stripe
               ref="currentRowTable"
               :border="true"
               :columns="columns"
               :data="data">
          <template slot-scope="{ row }"
                    slot="action">
            <Button size="small"
                    @click="deletePassage(row)">删除
            </Button>
            <Button size="small"
                    @click="openViewModal(row)">查看
            </Button>
          </template>
        </Table>
      </Col>
    </Row>
    <Row>
      <div style="float:right;margin-top:20px">
        <Page :total="total"
              show-elevator
              show-sizer
              show-total
              style="padding-right:3px"/>
      </div>
    </Row>
  </div>
</template>

<script>
export default {
  props: {
    data: {
      type: Array,
      default: () => {
        return []
      }
    },
    total: {
      type: Number,
      default: 0
    }
  },
  data: () => {
    return {
      columns: [
        {
          title: '序号',
          type: 'index',
          width: 70,
          align: 'center',
          disabled: true,
          key: 'index'
        },
        {
          title: '文章标题',
          align: 'center',
          minWidth: 170,
          key: 'baTitle',
          tooltip: true
        },
        {
          title: '文章概要',
          align: 'center',
          minWidth: 60,
          // maxWidth: 330,
          key: 'baSummary',
          tooltip: true
        },
        {
          title: '查看次数',
          align: 'center',
          key: 'baViewCount',
          maxWidth: 100
        },
        {
          title: '评论数',
          align: 'center',
          key: 'baCommentCount',
          maxWidth: 100
        },
        {
          title: '按赞总数',
          align: 'center',
          key: 'baLikeCount',
          maxWidth: 100
        },
        {
          title: '允许评论',
          align: 'center',
          key: 'baBlockComment',
          maxWidth: 100
        },
        {
          title: '创建时间',
          align: 'center',
          key: 'baCreateTime',
          width: 160
        },
        {
          title: '操作',
          align: 'center',
          key: 'action',
          fixed: 'right',
          minWidth: 120,
          maxWidth: 150,
          slot: 'action'
        }
      ]
    }
  },
  methods: {
    openViewModal (row) {
      this.$emit('openViewModal', row.id)
    },
    deletePassage (row) {
      this.$Modal.confirm({
        title: '提示',
        content: '确认是否要删除',
        onOk: () => {
          this.$emit('deletePassage', row.id)
        }
      })
    }
  }
}
</script>

<style lang="less" scoped>
</style>
