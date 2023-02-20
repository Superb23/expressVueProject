<template>
  <div class="login-container">
    <h1>superb课程管理系统</h1>
    <!-- @keyup.enter="onLogin" 监听键盘enter点击 -->
    <el-form class="login-form" 
            :model="userInfo"
            :rules="rules"
            @keyup.enter="onLogin"
            ref="refForm"
    >
    <!-- prop="userName"  对于校验规则rules中的要求 -->
      <el-form-item prop="userName">
        <el-input placeholder="请输入用户名"
                  v-model="userInfo.userName"
        >
          <template #prepend>
            <el-icon><Avatar /></el-icon>
          </template>
        </el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input placeholder="请输入密码" 
                  v-model="userInfo.password"
                  show-password
        >
          <template #prepend>
            <el-icon><Key /></el-icon>
          </template>
        </el-input>
      </el-form-item>
      <el-button type="primary"
                 class="login-submit"
                 @click="onLogin"
      >
        登录
      </el-button>
      <div class="login-register">
        <span class="text"
              @click="goRegister">
          注册
        </span>
      </div>
    </el-form>
  </div>  
</template>

<script setup>
import { ref } from 'vue';
import router from '@/router';

// 获取元素-html实例
const refForm = ref()
// 表单数据声明
const userInfo = ref({
  userName: "",
  password: ""
})
// 表单数据校验规则
const rules = {
  userName: [{
    required: "true", // 必填
    trigger: "blur",  // 失去焦点即进行验证
    message: "用户名不能为空"
  }],
  password: [{
    required: "true",
    trigger: "blur",
    message: "密码不能为空"
  }]
}
// 登录的方法
const onLogin = () => {
  // 任意表单项校验后触发
  refForm.value.validate((value) => {
    if (value) {
      // 校验成功
      getLoginData()
    } else {
      // 校验失败
    }
  })
}
// 登录接口
const getLoginData = () => {
  localStorage.setItem("token", 1)
  // 消息提示
  ElMessage({
    message: "登录成功",
    type: 'success',
  })
  router.push("/home")
}
// 跳转注册
const goRegister = () => {
  router.push("/register")
}

</script>

<style lang="less" scoped>
.login-container {
  position: fixed;
  z-index: 1;
  width: 20%;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  min-height: 200px;
  text-align: center;
  background-color: #fff;
  border-radius: 10px;
  padding: 20px;
  h1 {
    font-size: 24px;
    transition: all 1s;
    font-weight: bold;
    margin-bottom: 36px;
  }
  .login-form {
    .login-submit {
      font-size: 16px;
      width: 100%;
      height: 50px;
      border-radius: 20px;
      margin-bottom: 10px;
    }
    .login-register {
      width: 100%;
      font-size: 12px;
      margin: 0 auto;
      .text {
        cursor:pointer; 
      }
    }
    :deep(.el-input-group__prepend) {
      padding: 0 10px;
    }
  }
}
</style>