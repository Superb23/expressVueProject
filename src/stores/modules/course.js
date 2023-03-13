import { defineStore } from "pinia";
import { getCourseList } from "@/service";

const useCourseStore = defineStore("course", {
  state: () => ({
    data: {
      list: [],
      page: 1,
      total: 1
    },
    category: "front"
  }),
  getters: {
    
  },
  actions: {
    async fetchCourseListData(query) {
      const category = query?.category || this.category
      const page = query?.page || 1
      const size = query?.size || 5
      const res = await getCourseList({
        category,
        page,
        size
      })
      this.data.list = res?.data?.list.filter(item => {
        return item.category === category
      })
      this.data.total = res?.data.total[0]
    }
  }
})

export default useCourseStore