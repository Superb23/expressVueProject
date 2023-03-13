import hyRequest from '@/service/request/index'
export const getLogin = (data) => {
  return hyRequest.post({
    url: "/api/v1/user/login",
    data
  })
}