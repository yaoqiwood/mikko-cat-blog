<template>
  <div class="layout">
    <!-- <index-collapse>
    </index-collapse> -->
    <Layout>
      <Header>
        <Menu mode="horizontal"
              theme="dark"
              active-name="1">
          <div class="layout-logo">
            <div></div>
          </div>
          <div class="layout-nav">
            <Dropdown @on-click="onSelect">
              <div class="inner_drop_down">
                <Icon type="ios-stats" />
                {{userObj.username}}
                <Icon type="ios-arrow-down" />
              </div>
              <DropdownMenu slot="list"
                            style="text-align:center">
                <DropdownItem name="3-1"><span class="menu-item-font">信息修改</span></DropdownItem>
                <DropdownItem name="logout"><span class="menu-item-font">注銷賬戶</span></DropdownItem>
              </DropdownMenu>
            </Dropdown>
          </div>
        </Menu>
      </Header>
      <Layout style="minHeight: 90.7vh">
        <Sider hide-trigger
               :style="{background: '#fff'}"
               collapsible
               :collapsed-width="78"
               v-model="isCollapsed"
               ref="sider"
               width="230px">
          <!-- width="230px" -->
          <Menu theme="light"
                width="auto"
                mode="vertical"
                style="text-align:left"
                accordion>
            <main-page-side-sub-menu-item v-show="!isCollapsed"
                                          :menuItemList=menuItemList></main-page-side-sub-menu-item>
            <div class="menu-collapsed"
                 v-show="isCollapsed"
                 :list="menuItemList">
              <template v-for="item in menuItemList">
                <collapsed-menu v-if="item.childMenu"
                                @on-click="handleSelect"
                                @menu-item-select-enter="handleMenuSelectEnter"
                                @menu-item-select-out="handleMenuSelectOut"
                                active-name="''"
                                :hide-title="!isCollapsed"
                                theme="dark"
                                :parent-item="item"
                                :key="item.menuId">
                </collapsed-menu>
              </template>
            </div>
          </Menu>
        </Sider>
        <Layout :style="{padding: '0 15px 15px'}">
          <div>
            <Icon @click.native="collapsedSider"
                  :class="rotateIcon"
                  :style="{margin: '0 0',display:'block',width:'20px',float:'left', position: 'relative',top: '13.5px'}"
                  type="md-menu"
                  size="24" />
            <Breadcrumb :style="{margin: '15px 0',display:'block',width:'300px',float:'left',position: 'relative',left: '20px'}">
              <BreadcrumbItem>Home</BreadcrumbItem>
              <BreadcrumbItem>Components</BreadcrumbItem>
              <BreadcrumbItem>Layout</BreadcrumbItem>
            </Breadcrumb>
          </div>

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
import CollapsedMenu from './collapseMenu/collapsed-menu'
import IndexCollapse from '@/components/collapse/app/MainCollapse'
import UserService from '@/service/UserService'
import RouterUtil from '@/router/routersUtil'
import RouterUrls from '@/router/routersUrl'
import Constants from '@/constants/Constants'
export default {
  name: 'MainPage',
  beforeRouteEnter (to, from, next) {
    next(vm => {
      vm.getAllMenuItem()
    })
  },
  mounted () {
    this.getLoginStatus()
    // cookie获取用户对象
    this.userObj = UserService.initUserInf()
  },
  data () {
    return {
      menuItemList: [],
      userObj: {},
      isCollapsed: false
    }
  },
  methods: {
    getAllMenuItem () {
      try {
        MainApi.getAllMenuItem().then(resp => {
          if (resp.success) {
            this.menuItemList = resp.data
          }
        })
      } catch (e) {
        this.$Message.error(e)
      }
    },
    getLoginStatus () {
      try {
        UserService.getLoginStatus()
      } catch (e) {
        RouterUtil.routerReplace(RouterUrls.NLogin, {})
      }
    },
    onSelect (name) {
      if (name === Constants.MAIN_BUTTON_TYPE.LOGOUT) {
        this.$Modal.confirm({
          title: '提示',
          content: '確定要注銷？',
          onOk: () => {
            UserService.userLogout()
          }
        })
      }
    },
    collapsedSider () {
      this.$refs['sider'].toggleCollapse()
    },
    handleMenuSelectEnter (menuName, activeName) {
      // this.$emit('menu-item-select', menuName)
    },
    handleMenuSelectOut () {
      // this.$emit('menu-item-select', this.defaultActiveName)
    },
    handleSelect (name, activeName) {
      // this.defaultActiveName = activeName
      // this.$emit('on-select', name, activeName)
    }
  },
  computed: {
    rotateIcon () {
      return [
        'menu-icon',
        this.isCollapsed ? 'rotate-icon' : ''
      ]
    }
  },
  components: {
    MainPageSideSubMenuItem, IndexCollapse, CollapsedMenu
  }
}
</script>
<style lang="less" scoped>
@import "./less/MainPage.less";
</style>
