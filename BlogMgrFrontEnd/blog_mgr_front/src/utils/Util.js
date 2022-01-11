/* jshint esversion: 6 */
import Vue from 'vue'
import NetConstants from '../constants/NetConstants'
import CookieService from '@/service/CookieService'
// import RouterUtil from '@/router/routersUtil'
// import RouterUrl from '@/router/routersUrl'
import ColorConstant from '@/constants/ColorConstant'
// import { resolve } from 'build/webpack.base.conf'
// import {Message} from 'view-design'
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
  httpGetWithHeader (url, option) {
    return new Promise((resolve, reject) => {
      let promise = Vue.http.get(url, option)
      promise.then(resp => {
        resolve(resp.data)
      },
      rejectResp => {
        reject(rejectResp.data)
      })
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
  httpPostFormData (url, params) {
    return new Promise((resolve, reject) => {
      console.log(params)
      let promise = Vue.http.post(url, params, NetConstants.FORM_DATA_HEADER)
      // console.log(NetConstants.FORM_DATA_HEADER)
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
