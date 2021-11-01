# 通訊錄-後端設計

## 資料庫設計

### 統一全部資料皆有的欄位
- AbstractEntity.java
- 統一的欄位有 :
  >- id : id, Long
  >- 建立時間 : createDateTime, LocalDateTime
  >- 建立人員 : createBy, String
  >- 最後修改時間 : lastModifieDateTime, LocalDateTime
  >- 資料儲存版本 : version, Long
  >- 是否為最新的版本 : lastVersion, boolean
  >- 是否被刪除 : deleted, boolean
- 自動生成參數 (@CreatedDate、@LastModifiedDate)   
  - 需要在實體類別新增 @EntityListeners(AuditingEntityListener.class)
  - 在 application 啟動類別中加上 @EnableJpaAuditing

- 特別使用到的 annotation
- @MappedSuperclass
  > 在父類別標註，不同的子類別則可以共用父類別的欄位
  >

- 待測試 (時間格式) 
- [time format](https://github.com/Frank0321/softleader-training-course/blob/master/2021/Q3/spring-web-jpa/demo-web-jpa/src/main/java/tw/com/softleader/demoweb/DemoWebJpaApplication.java)

  - [@MappedSuperclass的作用](https://www.cnblogs.com/zouhong/p/13450688.html)
  - [自动生成时间和修改者](https://www.jianshu.com/p/14cb69646195)
  - [自動產生 jpa 參數](https://ithelp.ithome.com.tw/articles/10273243?sc=iThomeR)
### 建立所有 Entity 在資料庫顯示的規則
- NewTableNameRule.java
  - 需繼承 SpringPhysicalNamingStrategy
  - 修改表格前綴字   -> @override toPhysicalTableName
    > 通常會加上一些文字作為標示
  - 修改扁格後端文字 -> @override getIdentifier
    > 通常會把最後的 Entity 字眼拿掉

- application.properties 設定
  - 建立好規則後，需要再 application.properties 設定參數，設定如下 :
    ```
    #設定全部 Entity 的命名規則，引用 NewTableNameRule 這一個檔案
    spring.jpa.hibernate.naming.physical-strategy=com.example.directorybackend.utils.NewTableNameRule
    ```
### Mapstruct 與 lombok 共用產生的問題
- 錯誤訊息 :
  ```java
  Unknown property "name" in result type AbstractEntity.AbstractEntityBuilder<?,?>. Did you mean "null"?
  ```
- MapStruct and Lombok not working together
- [stackoverflow](https://stackoverflow.com/questions/47676369/mapstruct-and-lombok-not-working-together/47684351)

### 注意事項
- @RequestBody
  >- 只能適用在 Post 請求上
  >- [@RequestBody的使用](https://www.cnblogs.com/east7/p/13939235.html)
