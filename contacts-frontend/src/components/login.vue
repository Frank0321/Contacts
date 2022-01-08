<template>
  <div class="login">
    <div class="login-card">
      <h1> 登入頁面 </h1>
      <h2>
        <div class="login-type">
          帳號<input class="login-type login-box" v-model="login.username"/>
        </div>
        <div class="login-type">
          密碼<input class="login-type login-box" type="password" v-model="login.password"/>
        </div>
        <div>
          <button class="login-btn" @click="reset"> 重設 </button>
<!--          <button class="btn btn-dark"> LOGIN </button>-->
          <button class="login-btn"> LOGIN </button>
        </div>

      </h2>
    </div>
  </div>
</template>

<script>
export default {
  name: "login",
  data() {
    return {
      login: {
        username: "",
        password: "",
      }
    }
  },
  methods: {
    reset(){
      this.login = {};
    }
  }
}
</script>

<style scoped>
.login{
  background-color: rgba(100,100,100,0.5);
  height: 100%;
  width: 100%;
  position: fixed;
  top: 0;
  left: 0;
  z-index: 2;
}
.login-card{
  background-color: white;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 500px;
  padding: 10px 50px;
}
.login-type{
  width: 80%;
  padding: 12px 20px;
  margin: 2px 20px;
  border-radius: 2px;
  box-sizing: border-box;
}
.login-box{
  width: 70%;
}
.login-btn {
  font-size: 20px;
  margin-right: 2em;
  width: 90px;
  color: black;
  background-color: #ffa214;
  border-radius: 15px;
  box-shadow: 0 9px #999;
}
.login-btn:hover {
  box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
}
.login-btn:active {
  color: #fff;
  background-color: #ff7106;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}

</style>