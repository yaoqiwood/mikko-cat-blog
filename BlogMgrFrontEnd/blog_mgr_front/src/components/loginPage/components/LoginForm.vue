<template>
  <div>
    <div class="center_box">
      <h1 class="card_heading">登录</h1>
      <div class="center_box_inner_box">
        <Form ref="dataForm"
              class="form"
              :model="dataModal"
              :rules="rules">
          <div class="center_box_inner_username">
            <FormItem prop="account">
              <Input type="text"
                     v-model.trim="dataModal.account"
                     placeholder="Username">
              <Icon type="ios-person-outline"
                    slot="prepend"></Icon>
              </Input>
            </FormItem>
          </div>
          <div class="center_box_inner_password">
            <FormItem prop="password">
              <Input type="password"
                     v-model.trim="dataModal.password"
                     placeholder="Password">
              <Icon type="ios-lock-outline"
                    slot="prepend"></Icon>
              </Input>
            </FormItem>
          </div>
          <div class="center_box_inner_verification">
            <FormItem prop="verificationCode">
              <Input type="text"
                     v-model.trim="dataModal.verificationCode"
                     placeholder="Verification Code">
              </Input>
              <img :src="verificationCodeSrc"
                   @click="verificationCodeImgClick"
                   class="verification_code_box" />
            </FormItem>
          </div>
        </Form>
      </div>
      <Button type="primary"
              @click="onSubmit">登 錄</Button>
    </div>
  </div>
</template>
<script>
export default {
  name: 'LoginForm',
  props: {
    verificationCodeSrc: {
      type: String,
      default: ''
    }
  },
  data () {
    return {
      dataModal: {},
      rules: {
        account: [
          { required: true, message: '请输入账号', trigger: 'blur' },
          { type: 'string', max: 15, message: '账号长度不能大于15', trigger: 'blur' },
          { type: 'string', min: 5, message: '账号不能小于5个字符', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          { type: 'string', max: 20, message: '密码长度不能大于20', trigger: 'blur' },
          { type: 'string', min: 5, message: '密码不能小于5个字符', trigger: 'blur' }
        ],
        verificationCode: [
          { required: true, message: '请输入验证码', trigger: 'blur' },
          { type: 'string', max: 5, message: '验证码长度不能大于5', trigger: 'blur' }
        ]
      }
    }
  },
  mounted () {
    this.$emit('getVerificationCodeSrc')
  },
  methods: {
    verificationCodeImgClick () {
      this.$emit('getVerificationCodeSrc')
    },
    onSubmit () {
      this.$refs['dataForm'].validate(valid => {
        if (valid) {
          this.$emit('onSubmit', this.dataModal)
        }
      })
    }
  }

}
</script>
<style lang='less' scoped>
@import url("../less/Login.less");
</style>
