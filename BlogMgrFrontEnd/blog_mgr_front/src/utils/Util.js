/* jshint esversion: 6 */
import Vue from 'vue'
import NetConstants from '../constants/NetConstants'
import CookieService from '@/service/CookieService'
import RouterUtil from '@/router/routersUtil'
import RouterUrl from '@/router/routersUrl'
import ColorConstant from '@/constants/ColorConstant'
import {Message} from 'view-design'

export default {
  httpGet (url) {
    return new Promise((resolve, reject) => {
      let promise = Vue.http.get(url)
      promise.then(
        solveResp => {
          resolve(solveResp.data)
        },
        rejectResp => {
          reject(rejectResp.data)
        }
      )
    })
  },
  httpPost (url, params) {
    this.mountLoginToken()
    return new Promise((resolve, reject) => {
      let promise = Vue.http.post(url, params, NetConstants.POST_OPTIONS)
      promise.then(
        resResp => {
          this.checkRespError(resResp)
          resolve(resResp.data)
        },
        rejectResp => {
          reject(rejectResp.data)
        })
    })
  },
  httpPostJSON (url, params) {
    return new Promise((resolve, reject) => {
      let promise = Vue.http.post(url, params, NetConstants.POSTJSON_OPTIONS)
      promise.then(
        resResp => {
          this.checkRespError(resResp)
          resolve(resResp.data)
        },
        rejectResp => {
          reject(rejectResp.data)
        }
      )
    })
  },
  checkRespError (resp) {
    if (resp.data.errorValidation) {
      Message.error('当前用户登录信息失效，请重新登录')
      setTimeout(() => {
        // 清空cookie
        CookieService.userLogout()
        RouterUtil.routerReplace(RouterUrl.NLogin)
      }, 2000)
    }
  },
  mountLoginToken () {
    if (!NetConstants.POST_HEADERS.Authorization) {
      CookieService.judgeMountUserToken()
    }
  },
  colorRandom () {
    return ColorConstant.TAG_COLOR[Math.floor(Math.random() * Math.floor(ColorConstant.TAG_COLOR.length))]
  },
  jsonDeepCopy (params) {
    return JSON.parse(JSON.stringify(params))
  }
}
