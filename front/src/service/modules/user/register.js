import hyRequest from '@/service/request/index'
import axios from 'axios'

export const getRegister = (data) => {
  // return hyRequest.post({
  //   url: "/api/v1/user/register",
  //   data
  // })
  return axios.post("/api/v1/user/register", data);
}