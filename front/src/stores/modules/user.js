import { getUserList } from "@/service";
import { defineStore } from "pinia";

const useUserStore = defineStore("user", {
  state: () => ({
    list: [],
  }),
  getters: {
    
  },
  actions: {
    async fetchUserList() {
      if (this.list?.length > 0) return;

      const res = (await getUserList()).data;
      this.list = res.data?.adminList;
    }
  }
});

export default useUserStore;