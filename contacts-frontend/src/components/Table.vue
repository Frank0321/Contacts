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
      <tr>
        <td>1</td>
        <td>201</td>
        <td>Matt</td>
        <td>2003-01-10</td>
        <td>0987654321</td>
        <td>
          <button class="edit-btn">View</button>
          <button class="delete-btn">Delete</button>
        </td>
      </tr>
      <tr>
        <td>2</td>
        <td>202</td>
        <td>Rhys</td>
        <td>2009-02-12</td>
        <td>0987654321</td>
        <td>
          <button class="edit-btn">View</button>
          <button class="delete-btn">Delete</button>
        </td>
      </tr>
      <tr>
        <td>3</td>
        <td>203</td>
        <td>Alan</td>
        <td>2009-03-15</td>
        <td>0987654321</td>
        <td>
          <button class="edit-btn">View</button>
          <button class="delete-btn">Delete</button>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  name: "Table"
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