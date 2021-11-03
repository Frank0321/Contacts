<template>
  <div>
    <Header/>
    <button class="title-btn type3"> 查詢 </button>
    <button class="title-btn type3"> 新增 </button>
    <button class="title-btn type3"> 登入 </button>
    <div class="container">
      <Table table-data="tableData"/>
    </div>
    <Footer/>
  </div>
</template>

<script>
import Header from "../components/Header";
import Footer from "@/components/Footer";
import Table from "@/components/Table";
import axios from "axios"
export default {
  name: "Contacts",
  components: {Table, Footer, Header},
  data(){
    return {
      tableData: []
    }
  },
  created: function (){
    this.fetchData();
  },
  methods:{
    fetchData(){
      let self = this;
      axios.get(`http://localhost:8090/contacts/findAll`, this.data, {
        headers:{
          //用 cors 來處理
          //https://ithelp.ithome.com.tw/articles/10247883
        }
      })
      .then(function (response){
        console.log("findAll data is response");
        console.log("response", response);
        self.tableData = response.data;
      })
      .catch(function (error){
        console.log("error not found");
        console.log(error);
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