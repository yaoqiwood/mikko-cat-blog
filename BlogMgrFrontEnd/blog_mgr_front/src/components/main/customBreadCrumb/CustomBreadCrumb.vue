<template>
  <div class="custom-bread-crumb">
    <Breadcrumb :style="{fontSize: `${fontSize}px`}">
      <BreadcrumbItem v-for="item in list"
                      :to="item.url ? item.url : ''"
                      :key="`bread-crumb-${item.name}`">
        <Icon :type='item.icons' />
        {{item.name}}
      </BreadcrumbItem>
    </Breadcrumb>
  </div>
</template>
<script>
import './customBreadCrumb.less'
export default {
  name: 'customBreadCrumb',
  components: {
  },
  props: {
    list: {
      type: Array,
      default: () => []
    },
    fontSize: {
      type: Number,
      default: 15
    },
    showIcon: {
      type: Boolean,
      default: false
    }
  },
  methods: {
  }
}
</script>
