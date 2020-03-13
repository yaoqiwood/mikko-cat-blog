const HTTP_METHODS = {
  HTTP: 'HTTP',
  GET: 'GET'
}

const POST_HEADERS = {
  'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
}

const POSTJSON_HEADERS = {
  'Content-Type': 'application/json'
}

const PROJECT_NAME_PATH = '/summerCat/blog/'

const POST_OPTIONS = {
  emulateJSON: true,
  headers: POST_HEADERS
}

const POSTJSON_OPTIONS = {
  emulateJSON: false,
  headers: POSTJSON_HEADERS
}

export default {
  HTTP_METHODS,
  POST_OPTIONS,
  POST_HEADERS,
  POSTJSON_HEADERS,
  POSTJSON_OPTIONS,
  PROJECT_NAME_PATH
}
