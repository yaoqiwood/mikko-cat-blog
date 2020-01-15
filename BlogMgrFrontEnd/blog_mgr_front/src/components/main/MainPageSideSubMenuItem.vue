<template>
  <div>
    <!-- 菜单递归  Submenu 父级展开 -->
    <Submenu v-for="(item) in menuItemList"
             v-if="item.childMenu.length>0"
             :name="item.menuId"
             :key="item.menuId">
      <template slot="title">
        <Icon :type="item.icon" />
        <span> {{item.name}} </span>
      </template>
      <!-- 子菜单内部 -->
      <main-page-side-sub-menu-item :menuItemList=item.childMenu>
      </main-page-side-sub-menu-item>
    </Submenu>
    <MenuItem v-else
              :name="item.menuId">{{item.name}}
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
