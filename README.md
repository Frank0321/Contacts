# Contacts
員工通訊錄

## side-project 介紹
### 前端 : vue 2x
- 以 vue 撰寫員工通訊錄，藉由父子元件完成新增資料的方式，並執行 CRUD 呼叫後端
- components
- 父傳子，子傳父
  
### 後端 : spring boot
- 使用 mariadb DB、JPA 等技術，接收前端的資料，並做出適當的回應
1. Entity 設計
> - 統一 Entity 的命名規則
> - 將共用的欄位抽出來在 AbstractEntity 中
2. 使用 RESTful API
3. 物件與資料庫分層管理
4. 使用 Spring Data JPA 操作資料庫
5. 資料版本進行控管，改善查詢時間


## axios
- 安裝 axios
  ```
  npm install axios
  ```

## 使用時間套件

- [vue2-datepicker](https://www.npmjs.com/package/vue2-datepicker)
  
### 未來期許
- 使用 spring security
- 分布不同權限管理的功能
- 結合 JPA 紀錄建立資料的人員，以及修改資料的人員
