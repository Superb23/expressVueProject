<template>
  <div class="aside">
    <el-menu class="el-menu-vertical-demo"
             active-text-color="#ffd04b"
             background-color="#545c64"
             text-color="#fff"
             :collapse="isCollapse"
    >
      <div class="title-icon">
        <img src="@/assets/home-title2.png" alt="">
        <span>xxx课程管理系统</span>
      </div>
      <el-sub-menu index="1">
        <template #title>
          <el-icon><Document /></el-icon>
          <span>课程管理</span>
        </template>
          <el-menu-item index="1-1" @click="courseHandle('front')">前端课程</el-menu-item>
          <el-menu-item index="1-2" @click="courseHandle('back')">后端课程</el-menu-item>
          <el-menu-item index="1-3" @click="courseHandle('all')">全栈课程</el-menu-item>
      </el-sub-menu>
      <el-sub-menu index="2">
        <template #title>
          <el-icon><User /></el-icon>
          <span>用户管理</span>
        </template>
          <el-menu-item index="2-1">普通用户</el-menu-item>
          <el-menu-item index="2-2">会员用户</el-menu-item>
          <el-menu-item index="2-3">SVIP用户</el-menu-item>
      </el-sub-menu>
    </el-menu>
  </div>
</template>

<script setup>
import { storeToRefs } from 'pinia'
import { defineProps } from 'vue'
import useCourseStore from '@/stores/modules/course'

const courseStore = useCourseStore()
const { data, category } = storeToRefs(courseStore)
const { isCollapse } = defineProps(["isCollapse"])

const courseHandle = (type) => {
  data.value.page = 1
  category.value = type
}
</script>

<style lang="less" scoped>
.el-radio-button__inner {
  padding: 0;
}

.el-menu--collapse {
  border: none;
}

.el-menu:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
  border: none;
}

.title-icon {
  display: flex;
  align-items: center;
  font-weight: 600;
  height: 60px;
  background-color: #fff;
  white-space: nowrap;
  padding-left: 15px;

  img {
    width: 40px;
    height: 40px;
    border-radius: 10%;
    margin-right: 10px;
  }
}
</style>