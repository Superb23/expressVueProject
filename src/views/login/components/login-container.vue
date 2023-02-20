<template>
  <div class="login-container">
    <h1>superb课程管理系统</h1>
    <el-form class="login-form">
      <el-form-item>
        <el-input placeholder="请输入用户名">
          <template #prepend>
            <el-icon><Avatar /></el-icon>
          </template>
        </el-input>
      </el-form-item>
      <el-form-item>
        <el-input placeholder="请输入密码" show-password>
          <template #prepend>
            <el-icon><Key /></el-icon>
          </template>
        </el-input>
      </el-form-item>
      <el-button type="primary" class="login-submit">登录</el-button>
      <div class="login-register">注册</div>
    </el-form>
  </div>
</template>

<script setup>

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
    }
    :deep(.el-input-group__prepend) {
      padding: 0 10px;
    }
  }
}
</style>