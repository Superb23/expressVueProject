import hyRequest from '@/service/request/index'
import axios from 'axios'
export const getCourseDelete = (data) => {
  // return hyRequest.get({
  //   url: "/api/v1/course/delete",
  //   params: data
  // })
  return axios.delete("/api/v1/course/delete", {
    params:{
      ...data
    }
  });
}
