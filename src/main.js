import { createApp } from 'vue'
import App from './App.vue'
import "./common/base.css"
// 导入所有图标
import * as ElementPlusIconsVue from '@element-plus/icons-vue'

const app = createApp(App)
// 全局注册导入的所有图标
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component)
}
app.mount('#app')

