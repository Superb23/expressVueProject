import hyRequest from '@/service/request/index'
import axios from 'axios'
export const getCourseList = (data) => {
  // return hyRequest.get({
  //   url: "/api/v1/course/find",
  //   params: data
  // })
  return axios.get("/api/v1/course/find", {
    params: {
      ...data
    },
  });
}