import route from '@/router'

export default {
  routerPush (name, params) {
    route.push({
      name: name,
      params: params
    })
  },
  routerReplace (name, params) {
    route.replace({
      name,
      params
    })
  }
}
