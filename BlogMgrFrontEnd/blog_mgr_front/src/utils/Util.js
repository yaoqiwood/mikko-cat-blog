import Vue from 'vue'
import NetConstants from '../constants/NetConstants'
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
    return new Promise((resolve, reject) => {
      let promise = Vue.http.post(url, params, NetConstants.POST_OPTIONS)
      promise.then(
        resResp => {
          resolve(resResp.data)
        },
        rejectResp => {
          rejectResp(rejectResp.data)
        })
    })
  },
  httpPostJSON (url, params) {
    return new Promise((resolve, reject) => {
      let promise = Vue.http.post(url, params, NetConstants.POSTJSON_OPTIONS)
      promise.then(
        resResp => {
          console.log(resResp)
          resolve(resResp)
        },
        rejectResp => {
          console.log(rejectResp)
          reject(rejectResp)
        }
      )
    })
  }
}
