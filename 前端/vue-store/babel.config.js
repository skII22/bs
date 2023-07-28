<<<<<<< HEAD
  // 这是项目发布阶段需要用到的bable插件
const prodPlugins = []
// 判断开发环境
if(process.env.NODE_ENV === 'production'){
  prodPlugins.push('transform-remove-console')
}

=======
>>>>>>> 32478a31c06519498ac512df3778dd391cd6f415
module.exports = {
  presets: [
    '@vue/cli-plugin-babel/preset'
  ]
}
