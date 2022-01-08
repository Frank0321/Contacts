<template>
  <div>
    <table class="table" >
      <thead>
      <tr>
        <th>No.</th>
        <th>EmpNo.</th>
        <th>Name</th>
        <th>Birthday</th>
        <th>Phone</th>
        <th>Doing</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="(item, index) in tableData" :key="index">
        <td>{{index+1}}</td>
        <td>{{item.empId}}</td>
        <td>{{item.name}}</td>
        <td>{{item.birthday}}</td>
        <td>{{item.phone}}</td>
        <td>
          <button class="edit-btn" @click="viewBtn(item.empId)">View</button>
          <button class="delete-btn" @click="deleteBtn(item.empId)">Delete</button>
        </td>
      </tr>
      </tbody>

    </table>
    <div class="bottom">
      <button v-for="(p, index) in totalPage" :key="index" @click="toPage(p-1)">{{p}}</button>
      <div class="bottom-table">共 {{ totalNum }} 筆資料</div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Table",
  props:{
    tableData:{
      type: Array,
      default: ()=>{
        return [];
      },
    },
    totalPage:{
      type: Number,
      default: 0
    },
    totalNum:{
      type: Number,
      default: 0
    }
  },
  methods: {
    deleteBtn(item){
      this.$emit("deleteItem", item);
    },
    viewBtn(item){
      this.$emit("viewItem", item);
    },
    toPage(page){
      this.$emit("toPageNum", page);
    }
  }
}
</script>

<style scoped>
.table{
  width: 100%;
  display: table;
  font-size: 20px;
}
td{
  height: 50px;
  background-color: white;
}
.edit-btn, .delete-btn{
  background: aquamarine;
  padding: 8px 20px;
  margin-left: 20px;
  border-radius: 15px;
  font-weight: bolder;
  font-size: 14px;
}
.delete-btn{
  background: orange;
}
.bottom-table{
  text-align: right;
}

</style>