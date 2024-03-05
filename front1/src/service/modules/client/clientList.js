import axios from 'axios';
export const getClientList = (data) => {
  return axios.get("/api/v1/client/list", {
    params: {
      ...data
    }
  });
}