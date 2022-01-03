<template>
  <div class="modal">
    <div class="modal-card">

      <h1> {{title}} </h1>
      <button class="close-btn" @click="closeBtn">x</button>

      <slot />
<!--      <div class="input-type">-->
<!--        姓名<input class="input-type input-box" v-model="editData.name"/>-->
<!--      </div>-->
<!--      <div class="input-type">-->
<!--        生日<input class="input-type input-box" v-model="editData.birthday"/>-->
<!--      </div>-->
<!--      <div class="input-type">-->
<!--        血型<input class="input-type input-box" v-model="editData.bloodType"/>-->
<!--      </div>-->
<!--      <div class="input-type">-->
<!--        電話<input class="input-type input-box" v-model="editData.phone"/>-->
<!--      </div>-->
<!--      <button class="input-save" @click="saveModal">save</button>-->

    </div>
  </div>
</template>

<script>
export default {
  name: "Modal",
  data() {
    return {
      editData: {
        name: "",
        birthday: "",
        bloodType: "",
        phone: "",

      }
    }
  },
  props: {
    returnEditData: {
    },
    title: {
      type: String,
      default: "",
    }
  },

  methods:{
    closeBtn(){
      this.$emit("closeModal");
    },
    // saveModal(){
    //   this.$emit("saveItem", this.editData);
    // }
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
.input-save{
  padding: 8px 20px;
  margin-left: 20px;
  border-radius: 15px;
  font-weight: bolder;
  font-size: 14px;
}
</style>