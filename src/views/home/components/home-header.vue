<template>
  <div class="header">
    <div class="home-icon">
      <el-icon size="30px" 
               @click="handleCollapse"
               :style="{ transform: isCollapse ? '' : 'rotate(180deg)'}"
      >
        <Expand />
      </el-icon>
      <span>首页</span>
    </div>
    <div class="user"
         @mouseenter="isShowUserinfo(1)"
         @mouseleave="isShowUserinfo(0)"
    >
      <img src="@/assets/home-title.jpg" alt="">
      <div class="user-info" v-show="isShow">
        <div>superb</div>
        <div>退出登录</div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, defineProps } from 'vue'

const { handleCollapse, isCollapse } = defineProps(["handleCollapse", "isCollapse"])
const isShow = ref(false)
const isShowUserinfo = (flag) => {
  isShow.value = flag === 1 ? true : false
}
</script>

<style lang="less" scoped>
.user-info {
  z-index: 22;
  display: flex;
  flex-direction: column;
  position: absolute;
  right: 0;
  bottom: -77px;
  background-color: #fff;
  border: 5px;
  box-shadow: 0 4px 8px 0 rgb(7 17 27 / 10%);
  text-align: center;

  div:hover {
    color: #409eff;
  }

  div {
    padding: 10px;
  }
}

.header {
  position: relative;
  height: 100%;
  align-items: center;
  display: flex;
  justify-content: space-between;

  .home-icon {
    display: flex;
    align-items: center;

    span {
      margin-left: 10px;
    }
  }

  .user {
    display: flex;
    justify-content: center;
    width: 80px;

    img {
      width: 45px;
      height: 45px;
      border-radius: 50%;
    }
  }
}
</style>