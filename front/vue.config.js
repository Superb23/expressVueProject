const { defineConfig } = require('@vue/cli-service')
const AutoImport = require('unplugin-auto-import/webpack')
const Components = require('unplugin-vue-components/webpack')
const { ElementPlusResolver } = require('unplugin-vue-components/resolvers')

module.exports = defineConfig({
  lintOnSave: false,  // 关闭ESlint检验
  transpileDependencies: true,
  configureWebpack: {
    plugins: [
      AutoImport({
        resolvers: [ElementPlusResolver()],
      }),
      Components({
        resolvers: [ElementPlusResolver()],
      }),
    ]
  },
  devServer: {
    //代理列表
    proxy: {
      '/api': {
          target: 'http://127.0.0.1:7070/api', //要代理的域名
          changeOrigin: true,//允许跨域
          pathRewrite: {
            '^/api': ''  // 这个是定义要访问的路径，名字随便写
          }
      }
    }
  }
})