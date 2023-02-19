<template>
  <div class="home">
    <div>首页</div>
    <el-button type="primary" @click="toGo('/login')">跳转登录</el-button>
    <el-button type="primary" @click="toGo('/register')">跳转注册</el-button>
  </div>
</template>

<script setup>
import router from '@/router'

const toGo = (value) => {
  router.push(value)
}
</script>

<style lang="less" scoped>

</style>