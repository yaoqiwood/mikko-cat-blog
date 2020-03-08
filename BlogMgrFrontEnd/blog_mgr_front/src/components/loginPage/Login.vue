<template>
  <div class="back">
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
                :verificationCodeSrc="verificationCodeSrc"></login-form>
  </div>
</template>
<script>
import Urls from '@/router/routersUrl'
import LoginForm from './components/LoginForm'
import LoginApi from '@/api/login/Login'
// import BcryptUtil from '@/utils/BcryptUtil'
import MD5Util from '@/utils/MD5Util'
import Constants from '@/constants/SystemConstants'

export default {
  name: 'Login',
  components: { LoginForm },
  data () {
    return {
      bottomImgUrlRandomNum: 9,
      // bottomImgUrl: 'http://127.0.0.1:8084/summerCat/blog/sysAnnexConfigInfo/downloadImgById.action?id=',
      bottomImgUrl: Urls.RMenharaImg,
      bottomImgStyle: '',
      verificationCodeSrc: ''
    }
  },
  mounted () {
    // this.bottomImgUrl += this.bottomImgUrlRandomNum
    this.tempUrl = this.bottomImgUrl
    this.tempUrl += this.bottomImgUrlRandomNum
    this.bottomImgStyle = { 'background-image': 'url(' + this.tempUrl + ')' }
  },
  methods: {
    menheraClick () {
      this.bottomImgUrlRandomNum = this.getRandomNum(9, 169)
      this.tempUrl = this.bottomImgUrl
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
      // BcryptUtil.hashWords(params.password)
      let md5First = MD5Util.genMD5(params.password).toUpperCase() + Constants.SUFFIX
      console.log(MD5Util.genMD5(md5First).toUpperCase())
    }
  }
}
</script>
<style lang="less" scoped>
@import url("./less/Login.less");
</style>
