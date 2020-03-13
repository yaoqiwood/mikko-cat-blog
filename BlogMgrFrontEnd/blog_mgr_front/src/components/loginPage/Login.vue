<template>
  <div v-on:keyup.enter="formKeyEnter()"
       class="back">
    <vue-particles class="particle_point"
                   color="ffa500"
                   :particleOpacity="0.7"
                   :particlesNumber="80"
                   shapeType="circle"
                   :particleSize="4"
                   linesColor="#dedede"
                   :linesWidth="1"
                   :lineLinked="true"
                   :lineOpacity="0.4"
                   :linesDistance="150"
                   :moveSpeed="3"
                   :hoverEffect="true"
                   hoverMode="grab"
                   :clickEffect="true"
                   clickMode="push" />
    <div class="left_sider">
      <div class="title_login_back_btn_div">
        <div class="title_login_back_btn_div_inner">
          <Icon type="ios-home-outline"
                size="24" />
          <span class="title_login_back_btn">点击返回首页</span>
        </div>
      </div>
      <div class="title_login_back_btn_div_inner title_font_size"
           @click="menheraClick">
        <Icon type="md-arrow-round-down"
              size="24" />
        <span> Menhera</span>
      </div>
      <div :style="bottomImgStyle"
           class="bottom_img">
      </div>
    </div>
    <login-form @getVerificationCodeSrc="getVerificationCodeSrc"
                @onSubmit="onSubmit"
                ref="loginForm"
                :verificationCodeSrc="verificationCodeSrc"></login-form>
  </div>
</template>
<script>
import Urls from '@/router/routersUrl'
import LoginForm from './components/LoginForm'
import LoginApi from '@/api/login/Login'
import SysAnnexApi from '@/api/sysAnnexConfigInfo/SysAnnexConfigInfo'
import CookieService from '@/service/CookieService'
import RouterUtil from '@/router/routersUtil'
import UserService from '@/service/UserService'

export default {
  name: 'Login',
  components: { LoginForm },
  data () {
    return {
      bottomImgUrlRandomNum: 9,
      menharaIdItems: [],
      bottomImgStyle: '',
      verificationCodeSrc: ''
    }
  },
  mounted () {
    this.tempUrl = SysAnnexApi.downloadImgByIdUrl()
    this.tempUrl += this.bottomImgUrlRandomNum
    this.bottomImgStyle = { 'background-image': 'url(' + this.tempUrl + ')' }
    this.getMenharaItems()
    // 检查是否已经登录
    this.isLoginCheck()
  },
  methods: {
    menheraClick () {
      this.bottomImgUrlRandomNum = this.menharaIdItems[this.getRandomNum(0, this.menharaIdItems.length)].id
      this.tempUrl = SysAnnexApi.downloadImgByIdUrl()
      this.tempUrl += this.bottomImgUrlRandomNum
      this.bottomImgStyle = { 'background-image': 'url(' + this.tempUrl + ')' }
    },
    getRandomNum (min, max) {
      return Math.floor(Math.random() * (max - min) + min)
    },
    getVerificationCodeSrc () {
      this.verificationCodeSrc = LoginApi.getVerificationCodeImgSrc()
    },
    onSubmit (params) {
      this.$Spin.show()
      UserService.login(params).then(resp => {
        if (resp.success) {
          CookieService.saveAndGetToken(resp.data.user.token)
          RouterUtil.routerPush(Urls.NIndexMain, {})
          this.$Spin.hide()
        } else {
          this.getVerificationCodeSrc()
          this.$Message.error({
            content: resp.message
          })
          this.$Spin.hide()
        }
      })
    },
    getMenharaItems () {
      SysAnnexApi.getMenharaItems().then(resp => {
        if (resp.success) {
          this.menharaIdItems = resp.data
        }
      })
    },
    isLoginCheck () {
      if (UserService.isLoginCheck()) {
        // this.$Message.error('当前用户已登录，将强制跳转页面')
        this.$Spin.show()
        setTimeout(() => {
          this.$Spin.hide()
          RouterUtil.routerPush(Urls.NIndexMain, {})
        }, 2000)
      }
    },
    formKeyEnter () {
      this.$refs['loginForm'].onSubmit()
    }
  }
}
</script>
<style lang="less" scoped>
@import url("./less/Login.less");
</style>
