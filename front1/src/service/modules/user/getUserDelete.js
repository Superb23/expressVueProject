import axios from 'axios';
export const getUserDelete = (data) => {
  return axios.get("/api/v1/user/delete", {
    params: {
      ...data
    },
  });
}