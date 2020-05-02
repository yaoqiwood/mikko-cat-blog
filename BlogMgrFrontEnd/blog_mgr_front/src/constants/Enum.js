const TRUE_OR_FALSE = {
  NO: {
    name: '否',
    code: 0
  },
  YES: {
    name: '是',
    code: 1
  }
}

const ENUM_BLOCK_COMMENT = {
  NO: {
    name: '否',
    code: '0'
  },
  YES: {
    name: '是',
    code: '1'
  }
}

const ENUM_BA_STATUS = {
  FORBIDDEN_VIEW: {
    name: '不可查看',
    code: '0'
  },
  ABLE_VIEW: {
    name: '可查看',
    code: '1'
  },
  DRAFT: {
    name: '草稿',
    code: '2'
  },
  DELETED: {
    name: '已删除',
    code: '9'
  }
}

export default {
  TRUE_OR_FALSE,
  ENUM_BLOCK_COMMENT,
  ENUM_BA_STATUS
}
