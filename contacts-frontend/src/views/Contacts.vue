<template>
  <div>
    <h1 class="title"> 通  訊  錄 </h1>
    <div class="container">
      <table class="table"  cellpadding="10" border='0'>
        <thead>
          <tr>
            <th>No.</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Phone</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>1</td>
            <td>Blair</td>
            <td>2009-03-15</td>
            <td>0987654321</td>
            <td>
              <button class="edit-btn">Edit</button>
              <button class="delete-btn">Delete</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
export default {
  name: "Contacts"
}
</script>

<style scoped>
.title{
  font-size: 40px;
  font-weight: 900;
}
.container{
  padding: 30px 200px;
}
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
  margin: 10px;
  border-radius: 15px;
  font-weight: bolder;
}
.delete-btn{
  background: orange;
}
</style>