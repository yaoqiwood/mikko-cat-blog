import Vue from 'vue'
import NetConstants from '../constants/NetConstants'
export default {
  httpGet (url) {
    return new Promise((resolve, reject) => {
      let promise = Vue.http.get(url)
      promise.then(
        solveResp => {
          console.log(solveResp)
          resolve(solveResp)
        },
        rejectResp => {
          console.log(rejectResp)
          reject(rejectResp)
        }
      )
    })
  },
  httpPost (url, params) {
    return new Promise((resolve, reject) => {
      let promise = Vue.http.post(url, params, NetConstants.POST_OPTIONS)
      promise.then(
        resResp => {
          console.log(resResp)
          resolve(resResp)
        },
        rejectResp => {
          console.log(rejectResp)
          rejectResp(rejectResp)
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
