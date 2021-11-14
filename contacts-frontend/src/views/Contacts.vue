<template>
  <div>
    <Header/>
    <button class="title-btn type3"> 查詢 </button>
    <button class="title-btn type3" @click="addItem"> 新增 </button>
    <button class="title-btn type3"> 登入 </button>
    <modal v-if="modal.show" @close="closeModal"></modal>
    <div class="container">
      <Table :table-data="tableData" v-on:deleteItemMethod="deleteMethod"/>
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
      tableData: [],
      modal:{
        show: false,
      }
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
        self.tableData = response.data;
      })
      .catch(function (error){
        console.log("error not found");
        console.log(error);
      })
    },
    addItem(){
      this.modal.show = true;
    },
    closeModal() {
      this.modal.show = false;
    },
    //刪除該員工資料
    async deleteMethod(item){
      console.log(item);
      await axios.delete(`http://localhost:8090/contacts/deleteContacts?id=${item}`)
                  .then(function (respose){
                    console.log(`empId : ${item} is delete`);
                    console.log(respose);
                  })
      await this.fetchData();
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