import axios from 'axios';
export const getClientUpdateStatus = (data) => {
  return axios.put("/api/v1/client/update/status", data);
}