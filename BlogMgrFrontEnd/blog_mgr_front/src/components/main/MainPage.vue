<template>
  <div class="layout">
    <index-collapse>
    </index-collapse>
    <Layout>
      <Header>
        <Menu mode="horizontal"
              theme="dark"
              active-name="1">
          <div class="layout-logo"></div>
          <div class="layout-nav">
            <MenuItem name="1">
            <Icon type="ios-navigate"></Icon>
            Item 1
            </MenuItem>
            <MenuItem name="2">
            <Icon type="ios-keypad"></Icon>
            Item 2
            </MenuItem>
            <MenuItem name="3">
            <Icon type="ios-analytics"></Icon>
            Item 3
            </MenuItem>
            <MenuItem name="4">
            <Icon type="ios-paper"></Icon>
            Item 4
            </MenuItem>
          </div>
        </Menu>
      </Header>
      <Layout style="minHeight: 85vh">
        <Sider hide-trigger
               :style="{background: '#fff'}"
               width="260px">
          <Menu theme="light"
                width="260px"
                mode="vertical"
                style="text-align:left"
                accordion>
            <main-page-side-sub-menu-item :menuItemList=menuItemList></main-page-side-sub-menu-item>
          </Menu>
        </Sider>
        <Layout :style="{padding: '0 24px 24px'}">
          <Breadcrumb :style="{margin: '24px 0'}">
            <BreadcrumbItem>Home</BreadcrumbItem>
            <BreadcrumbItem>Components</BreadcrumbItem>
            <BreadcrumbItem>Layout</BreadcrumbItem>
          </Breadcrumb>
          <Content :style="{padding: '24px', minHeight: '280px', background: '#fff'}">
            Content
          </Content>
        </Layout>
      </Layout>
    </Layout>
  </div>
</template>
<script>
import MainApi from '@/api/main/MainApi'
import MainPageSideSubMenuItem from './MainPageSideSubMenuItem'
import IndexCollapse from '@/components/collapse/app/MainCollapse'
import UserService from '@/service/UserService'
import RouterUtil from '@/router/routersUtil'
import RouterUrls from '@/router/routersUrl'
export default {
  name: 'MainPage',
  beforeRouteEnter (to, from, next) {
    next(vm => {
      vm.getAllMenuItem()
    })
  },
  mounted () {
    this.getLoginStatus()
  },
  data () {
    return {
      menuItemList: []
    }
  },
  methods: {
    getAllMenuItem () {
      // TODO: 获取菜单 权限配置 Cookie
      try {
        MainApi.getAllMenuItem().then(resp => {
          if (resp.success) {
            this.menuItemList = resp.data
          }
        })
      } catch (e) {
        console.log(e)
      }
    },
    getLoginStatus () {
      try {
        UserService.getLoginStatus()
      } catch (e) {
        RouterUtil.routerReplace(RouterUrls.NLogin, {}, this.$router)
      }
    }
  },
  components: {
    MainPageSideSubMenuItem, IndexCollapse
  }
}
</script>
<style lang="less" scoped>
@import "./less/MainPage.less";
</style>
