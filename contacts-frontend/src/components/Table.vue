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
          <button class="edit-btn">View</button>
          <button class="delete-btn" @click="deleteBtn(item.empId)">Delete</button>
        </td>
      </tr>
      </tbody>
    </table>
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
    }
  },
  methods: {
    deleteBtn(item){
      console.log(item);
      this.$emit("deleteItemMethod", item);
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

</style>