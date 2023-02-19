import { createRouter, createWebHashHistory } from "vue-router"

const router = createRouter({
  history: createWebHashHistory(),  // 选择hash路由
  routes: [
    {
      path: "/",
      redirect: "/login"
    },
    {
      path: "/home",
      component: () => import("@/views/Home.vue"),
      meta: {
        isAuth: true
      }
    },
    {
      path: "/login",
      component: () => import("@/views/Login.vue")
    },
    {
      path: "/register",
      component: () => import("@/views/Register.vue")
    }
  ]
})

// 路由拦截
router.beforeEach((to, from, next) => {
  if (to.meta.isAuth) {
    if (localStorage.getItem("token")) {
      next()
    } else {
      ElMessage.error("请先登录账号")
    }
  } else {
    next()
  }
})

export default router