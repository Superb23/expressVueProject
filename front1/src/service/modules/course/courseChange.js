import hyRequest from '@/service/request/index'
import axios from 'axios'
export const getCourseChange = (data) => {
  // return hyRequest.get({
  //   url: "/api/v1/course/update",
  //   params: data
  // })
  return axios.put("/api/v1/course/update", data);
}