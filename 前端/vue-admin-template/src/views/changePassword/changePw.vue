<template>
  <div class="main">
    <el-form ref="form" label-width="80px">
      <el-form-item class="form">
        <el-form-item label="原密码">
          <el-input v-model="oldPw" class="input" style="width: 200px"></el-input>
        </el-form-item>
        <el-form-item label="新密码" >
          <el-input v-model="newPw" style="width: 200px"></el-input>
        </el-form-item>
        <div class="message" v-if="passwordMatch === false" style="color: red">两次密码不一致,请重新查看后输入</div>
        <el-form-item label="确认密码" >
          <el-input v-model="confirmPw" style="width: 200px"></el-input>
        </el-form-item>
      </el-form-item>
    </el-form>
    <el-button type="primary" :disabled="passwordMatch === false" @click="submit(oldPw,newPw)" style="margin-left: 140px">提交</el-button>
  </div>
</template>

<script src="./changePassword.js">
export default {
  name: 'changePw'
}
</script>
<style scoped="scoped">
.main{
text-align: center;
  margin-top: 300px;
}

</style>


