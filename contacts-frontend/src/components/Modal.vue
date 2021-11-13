<template>
  <div class="modal">
    <div class="modal-card">
      <h1> 新增 </h1>
      <button class="close-btn" @click="closeModal">x</button>
      <div class="input-type">
        姓名<input class="input-type input-box"/>
      </div>
      <div class="input-type">
        生日  <input class="input-type input-box"/>
      </div>
      <div class="input-type">
        血型<input class="input-type input-box"/>
      </div>
      <div class="input-type">
        電話<input class="input-type input-box"/>
      </div>
      <button>save</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "Modal",
  methods:{
    closeModal(){
      this.$emit("close");
    }
  }
}
</script>

<style scoped>
.modal{
  background-color: rgba(100,100,100,0.5);
  height: 100%;
  width: 100%;
  position: fixed;
  top: 0;
  left: 0;
  z-index: 2;
}
.modal-card{
  background-color: white;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 400px;
  padding: 10px 50px;
}
.close-btn{
  position: absolute;
  right: 50px;
  top: 25px;
  font-size: 20px;
  background: none;
  border: none;
  outline: none;
  cursor: pointer;
}
.input-type{
  width: 80%;
  padding: 12px 20px;
  margin: 2px 20px;
  border-radius: 2px;
  box-sizing: border-box;
}
.input-box{
  width: 70%;
}
</style>