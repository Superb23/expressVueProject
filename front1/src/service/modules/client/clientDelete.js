import axios from 'axios';
export const getClientDelete = (data) => {
  return axios.delete("/api/v1/client/delete", {data});
}