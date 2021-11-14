# 通訊錄-前端設計

## 常用元件介紹
### router 
- src/router/index.js 的檔案
- 主要撰寫路徑的位置
  ```javascript
  {
    path: "/",
    name: "Contacts",
    component: Contacts,
  },
  ```

### App.vue
- 主要撰寫共用的區塊

## components 
- 主要為自己設計的，在這邊標示哪些 componets 主要是做甚麼

### Contacts
- 整個畫面的首頁

### Header
- 顯示標題

###　Table 
- 顯示內容用的 table

### Footer
- 顯示頁尾

### Modal
- 為查詢、新增、View 共用的視窗格式
- 具有兩層 class 包起來
> - class="Modal" -> 為外層，設定說背景為灰色，且具有透明的，可以顯示下層的東西
> - class="modal-card" -> 為內層，可以顯示相對應要輸入的東西

- method 介紹
- deleteBtn 將該筆資料刪除
  > - 方法寫在 Table 中
  > - 利用 emit 將控制權傳到 Contacts 
  > - 由 Contacts 進行刪除的功能


## cors 問題
- 錯誤訊息如下 :
  ```javascript
  has been blocked by CORS policy: No 'Access-Control-Allow-Origin' header is present on the requested resource.
  ```
- 解決方法 : 
  > 後端 controller 加上 @CrossOrigin
