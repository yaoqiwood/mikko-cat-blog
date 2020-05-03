<template>
  <div class="layout">
    <!-- <index-collapse>
    </index-collapse> -->
    <Layout>
      <!-- <Header> -->
      <div class="header_bg">
        <Menu mode="horizontal"
              theme="dark"
              active-name="1">
          <div class="layout-logo">
            <div></div>
          </div>
          <div class="layout-nav">
            <Dropdown @on-click="onSelect">
              <div class="inner_drop_down">
                <Icon type="ios-stats"/>
                {{userObj.username}}
                <Icon type="ios-arrow-down"/>
              </div>
              <DropdownMenu slot="list"
                            style="text-align:center">
                <DropdownItem name="3-1"><span class="menu-item-font">信息修改</span></DropdownItem>
                <DropdownItem name="logout"><span class="menu-item-font">注銷賬戶</span></DropdownItem>
              </DropdownMenu>
            </Dropdown>
          </div>
        </Menu>
      </div>

      <!-- </Header> -->
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
                @on-select="onSelectMenu"
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
        <Layout :style="{padding: '0 10px 15px'}">
          <div>
            <Icon @click.native="collapsedSider"
                  :class="rotateIcon"
                  :style="{margin: '0 0',display:'block',width:'20px',float:'left', position: 'relative',top: '13.5px',cursor:'pointer'}"
                  type="md-menu"
                  size="24"/>
            <custom-bread-crumb show-icon
                                :style="{margin: '15px 0',display:'block',width:'300px',float:'left',position: 'relative',left: '20px'}"
                                :list="breadCrumbList"></custom-bread-crumb>
            <!-- <Breadcrumb :style="{margin: '15px 0',display:'block',width:'300px',float:'left',position: 'relative',left: '20px'}">
              <BreadcrumbItem>Home</BreadcrumbItem>
              <BreadcrumbItem>Components</BreadcrumbItem>
              <BreadcrumbItem>Layout</BreadcrumbItem>
            </Breadcrumb> -->
          </div>

          <Content :style="{padding: '0px', minHeight: '280px', background: '#fff'}">
            <!-- Content -->
            <router-view style="padding:10px 20px 0 20px"/>
          </Content>
        </Layout>
      </Layout>
    </Layout>
    <live2d :zIndex="999"/>
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
import CustomBreadCrumb from './customBreadCrumb'
// live-2d
import Live2d from 'vue-live2d'
import 'vue-live2d/dist/vue-live2d.css'

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
      allMenuItem: [],
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
            this.allMenuItem = []
            this.menuItemList.forEach(element => {
              this.allMenuItem.push(element)
              this.reduceMenu(this.allMenuItem, element)
            })
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
    },
    onSelectMenu (name) {
      let item = this.allMenuItem.filter(item => item.code === name)[0]
      RouterUtil.routerPush(item.code, {})
    },
    reduceMenu (allMenuItem, menuItem) {
      if (menuItem.childMenu) {
        menuItem.childMenu.forEach(element => {
          allMenuItem.push(element)
          this.reduceMenu(allMenuItem, element)
        })
      }
    }
  },
  computed: {
    rotateIcon () {
      return [
        'menu-icon',
        this.isCollapsed ? 'rotate-icon' : ''
      ]
    },
    breadCrumbList () {
      return this.$route.meta.bread
    }
  },
  components: {
    MainPageSideSubMenuItem, IndexCollapse, CollapsedMenu, CustomBreadCrumb, Live2d
  }
}
</script>
<style lang="less" scoped>
  @import "./less/MainPage.less";
</style>
