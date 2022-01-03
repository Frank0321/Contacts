<template>
  <div>
    <Header/>
    <button class="title-btn type3"> 查詢 </button>
    <button class="title-btn type3" @click="addItem"> 新增 </button>
    <button class="title-btn type3"> 登入 </button>
    <modal :title="modal.title" v-if="modal.show" @closeModal="closeMethod" >

            <div class="input-type">
              姓名<input class="input-type input-box" v-model="editData.name"/>
            </div>
            <div class="input-type">
              生日<input class="input-type input-box" v-model="editData.birthday"/>
            </div>
            <div class="input-type">
              血型<input class="input-type input-box" v-model="editData.bloodType"/>
            </div>
            <div class="input-type">
              電話<input class="input-type input-box" v-model="editData.phone"/>
            </div>
            <button class="input-save" @click="saveModal">{{ modalSaveWord }}</button>

    </modal>
    <div class="container">
      <Table :table-data="returnTableData" v-on:deleteItem="deleteMethod" v-on:viewItem="viewMethod"/>
    </div>
    <Footer/>
  </div>
</template>

<script>
import Header from "../components/Header";
import Footer from "@/components/Footer";
import Table from "@/components/Table";
import axios from "axios"
import Modal from "@/components/Modal";

export default {
  name: "Contacts",
  components: {Modal, Table, Footer, Header},
  data(){
    return {
      returnTableData: [],
      modal:{
        title: "",
        show: false,
      },
      editData: {
        name: "",
        birthday: "",
        bloodType: "",
        phone: "",
        empId: "",
      },
      modalSaveWord: "儲存",
    }
  },
  created: function (){
    this.fetchData();
  },
  methods:{
    fetchData(){
      let self = this;
      axios.get(`http://localhost:8090/contacts/findAllLastVersion`)
      .then(function (response){
        console.log("response", response.data);
        self.returnTableData = response.data;
      })
      .catch(function (error){
        console.log("error not found");
        console.log(error);
      })
    },
    addItem(){
      this.modal.show = true;
      this.modal.title = "新增";
      this.editData = {};
    },
    closeMethod() {
      this.modal.show = false;
    },
    //刪除該員工資料
    async deleteMethod(item){
      await axios.delete(`http://localhost:8090/contacts/deleteContacts?id=${item}`)
                  .then(function (respose){
                    console.log(`empId : ${item} is delete`);
                    console.log(respose);
                  })
      await this.fetchData();
    },
    //新增員工資料
    async saveModal(){
      if (this.editData.empId){
        console.log(this.editData.empId);
      }else {
        console.log("new add");
      }
      this.closeMethod();
      await axios.post(`http://localhost:8090/contacts/addNewContacts`, this.editData)
                  .then(function (response){
                    console.log("add new emp");
                    console.log(response);
                  })
      await this.fetchData();
    },
    //查看單筆資料
    viewMethod(item){
      this.modal.show = true;
      this.modal.title = "查看";
      this.modalSaveWord = "修改";
      console.log(item);
      let self = this;
      axios.get(`http://localhost:8090/contacts/findContact?empId=${item}`)
            .then(function (response){
              console.log("find one emp");
              console.log("response", response.data);
              self.editData = response.data;
            })
    }
  }

}
</script>

<style scoped>
.title-btn{
  margin-left: 150px;
  border-radius: 15px;
  font-size: 25px;
  margin-bottom: 10px;
  width: 80px;
}


.container{
  padding: 30px 200px;
  background: gainsboro;
}


</style>