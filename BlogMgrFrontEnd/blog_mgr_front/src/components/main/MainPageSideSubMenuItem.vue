<template>
  <div>
    <!-- 菜单递归  Submenu 父级展开 -->
    <Submenu v-for="(item) in menuItemList"
             v-if="item.childMenu.length>0"
             :name="item.code"
             :key="item.menuId">
      <template slot="title">
        <Icon :type="item.icon"
              size="18" />
        <span> {{item.name}} </span>
      </template>
      <!-- size="24" -->
      <!-- 子菜单内部 -->
      <main-page-side-sub-menu-item :menuItemList=item.childMenu>
      </main-page-side-sub-menu-item>
    </Submenu>
    <MenuItem v-else
              :name="item.code">
    <Icon :type="item.icon"
          size="18" />
    {{item.name}}
    </MenuItem>
  </div>
</template>
<script>
export default {
  name: 'MainPageSideSubMenuItem',
  props: {
    menuItemList: {
      type: Array,
      default: () => []
    }

  }
}
</script>
