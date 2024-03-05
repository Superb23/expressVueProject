import hyRequest from '@/service/request/index'

export const getUserInfo = (data) => {
  // return hyRequest.get({
  //   url: "/api/v1/user/userInfo"
  // }) 
  return axios.get("/api/v1/user/userInfo", data);
}