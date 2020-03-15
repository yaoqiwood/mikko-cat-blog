import route from '@/router'

export default {
  routerPush (name, params) {
    route.push({
      name: name,
      params: params
    })
  },
  routerReplace (name, params) {
    if (route.currentRoute.name !== name) {
      route.replace({
        name,
        params
      })
    }
  }
}
