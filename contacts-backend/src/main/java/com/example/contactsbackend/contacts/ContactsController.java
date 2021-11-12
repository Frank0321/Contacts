package com.example.contactsbackend.contacts;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity saveContract (@RequestBody Contacts contacts){
        contactsService.save(contacts);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * 全部員工人數為最新的資料
     * @return List<Contacts>
     */
    @GetMapping("/findAllLastVersion")
    public ResponseEntity<List<Contacts>> findAllContactsOfLastVersion(){
        return ResponseEntity.ok(contactsService.findAllLastVersionIsTrue());
    }

    /**
     * 查詢一筆員工的資料
     * @param empId
     * @return Contacts
     */
    @GetMapping("/findContact")
    public ResponseEntity<Contacts> findContact(@RequestParam Long empId){
        return ResponseEntity.ok(contactsService.findContact(empId));
    }



}
