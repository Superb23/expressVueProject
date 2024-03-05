import hyRequest from '@/service/request/index'
import axios from 'axios'
export const getLogin = (data) => {
  // return hyRequest.post({
  //   url: "/api/v1/user/login",
  //   data
  // })
  return axios.post("/api/v1/user/login", data);
}