<template>
  <Dropdown ref="dropdown"
            @on-click="handleClick"
            @on-visible-change="handleDropdownMenuState"
            :transfer="true"
            :placement="placement"
            :name="placement.name">
    <a class="drop-menu-a"
       type="text"
       @mouseout="handleMouseout($event, parentItem)"
       @mouseover="handleMousemove($event, parentItem)">
      <Icon v-if="parentItem.icon!=''"
            class="menu-title"
            style="margin:5px 18px"
            :type="`${parentItem.icon}`"
            :size="40"></Icon>
      <Icon v-else
            class=""
            style="margin-top: 5px;"
            type="ios-navigate"
            :size="26"></Icon>
      <span class="menu-title"
            v-show="hideTitle">{{parentItem.name}}</span>
      <Icon class="menu-title"
            style="float: right;"
            v-if="hideTitle"
            type="ios-arrow-forward"
            :size="23" />

    </a>
    <DropdownMenu slot="list"
                  v-if="parentItem.childMenu.length>0"
                  @mouseout="handleMouseout($event, parentItem)"
                  @mouseover="handleMousemove($event, parentItem)">
      <template v-for="child in parentItem.childMenu">
        <!--
        <collapsed-menu v-if="showchildMenu(child)" :icon-size="iconSize" :parent-item="child" :key="`drop-${child.name}`"></collapsed-menu>
        -->
        <DropdownItem :key="`drop-${child.name}`"
                      :name="child.name">
          <Icon v-if="child.icon!=''"
                style="margin-top: -4px;"
                :type="`${child.icon}`"
                :size="20"></Icon>
          <Icon v-else
                style="margin-top: -4px;"
                type="ios-navigate"
                :size="20"></Icon>
          <span class="menu-title">{{child.name}}</span>
        </DropdownItem>
      </template>
    </DropdownMenu>
  </Dropdown>
</template>
<script>
// import mixin from './mixin'
import itemMixin from './item-mixin'
// import { findNodeUpperByClasses } from '@/libs/util'

export default {
  name: 'CollapsedMenu',
  mixins: [itemMixin],
  props: {
    hideTitle: {
      type: Boolean,
      default: false
    },
    rootIconSize: {
      type: Number,
      default: 20
    },
    parentItem: {
      type: Object,
      default: () => { }
    },
    activeName: {
      type: String,
      default: ''
    }
  },
  data () {
    return {
      select: false,
      placement: 'right-end',
      visible: false,
      enter: false
    }
  },
  methods: {
    handleClick (name) {
      this.$emit('on-click', name, this.parentItem.name)
    },
    handleMousemove (event, item) {
      let childMenu = item.childMenu
      const { pageY } = event
      const height = childMenu.length * 38
      const isOverflow = pageY + height < window.innerHeight
      this.placement = isOverflow ? 'right-start' : 'right-end'
      // this.enter = true
      // if (!this.visible) {
      // this.$emit('menu-item-select-enter', item.name, this.activeName)
      // }
    },
    handleMouseout (item) {
      // setTimeout(() => {
      // if (!this.visible && !this.enter) {
      //   this.enter = false
      // }
      // if (!this.enter) {
      //   this.$emit('menu-item-select-out')
      // }
      // }, 100)
    },
    handleDropdownMenuState (visible) {
      // debugger
      // this.visible = visible
      // if (visible) {
      //   setTimeout(() => {
      //     if (this.enter) this.$emit('menu-item-select-enter', this.parentItem.name, this.activeName)
      //   }, 100)
      // } else {
      //   setTimeout(() => {
      //     if (this.enter && !this.visible) this.$emit('menu-item-select-out')
      //   }, 650)
      // }
    }
  },
  mounted () {
    // let dropdown = findNodeUpperByClasses(this.$refs.dropdown.$el, ['ivu-select-dropdown', 'ivu-dropdown-transfer'])
    // if (dropdown) dropdown.style.overflow = 'visible'
  },
  watch: {
    'activeName' (newValue) {
      let dropdown = this.$el.getElementsByClassName('drop-menu-a')[0]
      if (this.activeName === this.parentItem.name) {
        if (this.hideTitle) {
          dropdown.getElementsByClassName('menu-title')[1].style.color = 'white'
          dropdown.getElementsByClassName('menu-title')[2].style.color = 'white'
        }
        dropdown.getElementsByClassName('menu-title')[0].style.color = 'white'
        // dropdown.style.background = '#288cf0'
      } else {
        if (this.hideTitle) {
          dropdown.getElementsByClassName('menu-title')[1].style.color = ''
          dropdown.getElementsByClassName('menu-title')[2].style.color = ''
        }
        dropdown.getElementsByClassName('menu-title')[0].style.color = ''
        dropdown.style.background = ''
      }
    },
    '$route' (newRoute) {
      let dropdown = this.$refs.dropdown.$el
      if (dropdown) {
        if (newRoute && newRoute.meta && newRoute.meta.bread && newRoute.meta.bread.length > 1 && (newRoute.meta.bread[1].name !== undefined) && (newRoute.meta.bread[1].name === this.parentItem.name)) {
          if (this.hideTitle) {
            dropdown.getElementsByClassName('menu-title')[1].style.color = 'white'
            dropdown.getElementsByClassName('menu-title')[2].style.color = 'white'
          }
          dropdown.getElementsByClassName('menu-title')[0].style.color = 'white'
          // dropdown.style.background = '#288cf0'
          dropdown.style.background = 'linear-gradient(90deg, rgb(100, 155, 238),rgb(76, 187, 238),rgb(98, 209, 243))'
        } else {
          if (this.hideTitle) {
            dropdown.getElementsByClassName('menu-title')[1].style.color = ''
            dropdown.getElementsByClassName('menu-title')[2].style.color = ''
          }
          dropdown.getElementsByClassName('menu-title')[0].style.color = ''
          dropdown.style.background = ''
        }
      }
    },
    'hideTitle' (newValue) {
      let newRoute = this.$route
      let dropdown = this.$refs.dropdown.$el
      if (newRoute && newRoute.meta && newRoute.meta.bread && newRoute.meta.bread.length > 1 && (newRoute.meta.bread[1].name !== undefined) && (newRoute.meta.bread[1].name === this.parentItem.name)) {
        if (this.hideTitle) {
          setTimeout(() => {
            dropdown.getElementsByClassName('menu-title')[1].style.color = 'white'
            dropdown.getElementsByClassName('menu-title')[2].style.color = 'white'
          }, 50)
        } else {
          if (!this.hideTitle) {
            setTimeout(() => {
              dropdown.getElementsByClassName('menu-title')[1].style.color = ''
            }, 50)
          }
        }
      }
    }
  },
  computed: {
  }
}
</script>
