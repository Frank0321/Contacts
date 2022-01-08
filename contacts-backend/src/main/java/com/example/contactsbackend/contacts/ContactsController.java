package com.example.contactsbackend.contacts;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * FileName : ContractController
 * CreatTime : 2021/10/31
 * Author : Frank.Chang
 * Description :
 */
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/contacts")
public class ContactsController {

    private final ContactsService contactsService;

    /**
     * 新增一筆資料
     * @param
     */
    @PostMapping("/addNewContacts")
    public ResponseEntity saveContacts (@NotBlank @RequestBody Contacts contacts){
        contactsService.createContacts(contacts);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * 全部員工人數為最新的資料
     * @return List<Contacts>
     */
    @GetMapping("/findAllLastVersion")
    public ResponseEntity<List<Contacts>> findAllContactsOfLastVersionAndNotDelete(){
        return ResponseEntity.ok(contactsService.findAllLastVersionIsTrueDeleteFalse());
    }

    /**
     * 查詢一筆員工的資料
     * @param empId
     * @return Contacts
     */
    @GetMapping("/findContact")
    public ResponseEntity<Contacts> findContacts(@NotBlank @RequestParam Long empId){
        return ResponseEntity.ok(contactsService.findContacts(empId));
    }

    /**
     * 更新員工絲料
     * @param contacts
     * @return
     */
    @PostMapping("/updateContracts/{id}")
    public ResponseEntity updateContacts (@NotBlank @RequestBody Contacts contacts,@NotNull @PathVariable long id){
        contacts.setEmpId(id);
        contactsService.updateContacts(contacts);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * 刪除一筆員工資料
     * @param id
     * @return
     */
    @DeleteMapping("/deleteContacts")
    public ResponseEntity deleteContacts (@NotNull @RequestParam("id") long id){
        contactsService.deleteContacts(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    /**
     * 以芬頁進行搜尋有效員工
     * @param page
     * http://localhost:8090/contacts/findPage
     * http://localhost:8090/contacts/findPage?page=0
     * @return
     */
    @GetMapping("findPage")
    public ResponseEntity<Page<Contacts>> findAllContactByPage(
            @NotNull @PageableDefault(page = 0, size = 10, sort = "empId") Pageable page){
        return ResponseEntity.ok(contactsService.findContactsByPage(page));
    }


}
