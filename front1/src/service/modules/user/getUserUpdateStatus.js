import axios from 'axios';

export const getUserUpdateStatus = (data) => {
  return axios.get("/api/v1/user/update/status", {
    params: {
      ...data
    },
  });
}