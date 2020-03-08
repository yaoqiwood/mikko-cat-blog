const bcrypt = require('bcryptjs')
// 測試驗證密碼的次數。
const saltRounds = 10

export default {
  hashWords (words) {
    let salt = ''
    let hash = ''
    bcrypt.genSalt(saltRounds).then(res => {
      salt = res
      hash = bcrypt.hashSync(words, salt)
    })
    return hash
  }
}
