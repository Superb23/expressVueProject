import axios from 'axios';
export const getClientUpdate = (data) => {
  return axios.put("/api/v1/client/update", data);
}