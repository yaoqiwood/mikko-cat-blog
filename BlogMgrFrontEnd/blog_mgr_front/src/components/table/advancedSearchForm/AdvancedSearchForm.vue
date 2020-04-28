<template>
  <div>
    <Modal :title="title"
           v-model="isOpen"
           :styles="{top:'200px'}"
           :width="1000">
      <slot name="searchForm"/>
      <div slot="footer">
        <Button @click="resetSearchForm">重置</Button>
        <Button @click="cancel">取消</Button>
        <Button type="primary"
                @click="onOk">确定
        </Button>
      </div>
    </Modal>
  </div>
</template>

<script>
export default {
  name: 'AdvancedSearchForm',
  props: {
    title: {
      type: String,
      default: '高级搜索'
    }
  },
  data: () => {
    return {
      isOpen: false
    }
  },
  methods: {
    openSearchModal () {
      this.isOpen = true
    },
    cancel () {
      this.isOpen = false
    },
    onOk () {
      this.$emit('search')
      this.cancel()
    },
    resetSearchForm () {
      this.$emit('resetSearchForm')
    }
  }
}
</script>

<style lang="less" scoped>
</style>
