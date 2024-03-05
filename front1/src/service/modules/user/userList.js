import axios from 'axios';

export const getUserList = (data) => {
  return axios.get("/api/v1/user/userList", data);
}