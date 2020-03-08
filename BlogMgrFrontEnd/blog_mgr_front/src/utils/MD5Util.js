const md5 = require('md5')

export default {
  genMD5 (words) {
    return md5(words)
  }
}
