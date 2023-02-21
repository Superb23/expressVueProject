<template>
  <div class="main">
    <!-- 搜索框 -->
    <el-form>
      <el-form-item>
        <el-input v-model="inputValue" placeholder="请输入内容"></el-input>
      </el-form-item>
      <el-button type="primary" @click="handleClick">搜索</el-button>
    </el-form>
    <!--  -->
    <home-main-table :list="courserList" 
                     @editClick="editClick"
                     :deleteHandle="deleteHandle"
    />
    <home-main-pagination :currentChange="currentChange" />
  </div>
  <!-- 编辑 -->
  <home-main-dialog v-if="dialogShow"
                    :dialogShow="dialogShow" 
                    :message="courseItemState.message"
                    :confirmClick="confirmClick"
  />
</template>

<script setup>
import { reactive, ref, computed } from 'vue'
import homeMainTable from './home-main-table.vue'
import homeMainDialog from './home-main-dialog.vue'
import homeMainPagination from './home-main-pagination.vue'

const data = reactive({
  list: [
    {
      category: "front",
      courseImg: "https://file.xdclass.net/video/2022/77-QD/cover.jpeg",
      del: 0,
      id: 1,
      point: 9.8,
      price: "99",
      title: "22年新版【前端高级工程师】面试专题第一季"
    },
    {
      category: "front",
      courseImg: "https://file.xdclass.net/video/2022/75-Vue3/cover1.jpeg",
      del: 0,
      id: 2,
      point: 9.5,
      price: "99",
      title: "22年新版-零基础玩转vue3+开发仿美团外卖项目vue视频"
    },
    {
      category: "front",
      courseImg: "https://file.xdclass.net/video/2022/76-webpack5/cover.jpeg",
      del: 0,
      id: 3,
      point: 9.3,
      price: "59",
      title: "新版webpack5丨带你玩转时下最流行的构建工具"
    },
    {
      category: "front",
      courseImg: "https://file.xdclass.net/video/2021/74-git/WechatIMG3026.jpeg",
      del: 0,
      id: 4,
      point: 9.2,
      price: "39",
      title: "22年新版-玩转Git零基础到进阶实战 git视频急速入门"
    },
    {
      category: "front",
      courseImg: "https://file.xdclass.net/video/2021/73-ES6/cover.jpeg",
      del: 0,
      id: 5,
      point: 9.4,
      price: "49",
      title: "22年新版-玩转ECMAScript6零基础到进阶实战es6视频"
    },
  ],
  page: 1,
  total: 5
})

// 搜索框的逻辑
const inputValue = ref("")
const courserList = computed(() => {
  return data.list?.filter((item) => {
    return item.title.indexOf(inputValue.value) >= 0
  })
})
const isRef = ref(false)
const handleClick = () => {
  if (inputValue.value) {
    ElMessage({
      message: "查询成功",
      type: "success",
      showClose: true
    })
  } else {
    ElMessage({
      message: "请输入搜索内容",
      type: "error",
      showClose: true
    })
  }
}


// 编辑
const courseItemState = reactive({
  message: {}
})
const dialogShow = ref(false)
const isShowDialog = (show) => {
  dialogShow.value = show
}
const editClick = (value) => {
  isShowDialog(true)
  courseItemState.message = value
}

// 取消/确定按钮
const confirmClick = (value) => {
  if (value === 0) {
    isShowDialog(false)
  } else if (value.title !== courseItemState.message.title || value.price !== courseItemState.message.price) {
    data.list.map((item) => {
      if (item.id === value.id) {
        item.title = value.title
        item.price = value.price
      }
    })
    // 修改接口调用
    ElMessage({
      message: "已成功修改",
      type: "success"
    })
    isShowDialog(false)
  } else {
    ElMessage({
      showClose: true,
      message: "没有发现更多内容",
      type: "warning"
    })
    isShowDialog(false)
  }
}

// 删除
const deleteHandle = (value) => {
  if (value) {
    // 筛选
    data.list = data.list.filter((item) => {
      return item.id != value
    })
    // 删除接口
  }
}

// 翻页
const currentChange = (value) => {
  if (value === "pre") {
    if (data.page > 1) {
      data.page--
    } else {
      ElMessage({
        message: "已经是第一页了",
        type: "warning",
        showClose: true
      })
    }
  }
  if (value === "next") {
    if (data.page < Math.ceil(data.total/5)) {
      data.page++
    } else {
      ElMessage({
        message: "已经是最后一页了",
        type: "warning",
        showClose: true
      })
    }
  }
  // 请求课程的接口
}
</script>

<style lang="less" scoped>
.el-form {
  display: flex;
}

.main {
  background-color: #fff;
  padding: 20px;
  flex: 1;
  display: flex;
  flex-direction: column;

  .input-with-select {
    width: 400px;
    margin-bottom: 40px;
  }
}

:deep(.el-table__header-wrapper) {
  position: fixed;
  z-index: 20;
}

:deep(.el-table__inner-wrapper) {
  overflow: hidden;
}

:deep(.el-table__body-wrapper) {
  margin-top: 40px;
}

:deep(.el-input__inner) {
  width: 300px;
  margin-right: 10px;
}

:deep(.warning-row) {
  --el-table-tr-bg-color: var(--el-color-warning-light-9) !important;
  height: 140px !important;
}

.table {
  height: 80vh;
  width: 85vw;
  overflow: hidden;
  overflow-y: scroll;
}

.table::-webkit-scrollbar {
  display: none
}
</style>