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
    private final ContactsRepository contactsRepository;

    /**
     *
     * @param contacts
     */
    @PostMapping("/addNewContacts")
    public ResponseEntity saveContract (@RequestBody Contacts contacts){
        contactsService.save(contacts);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     *
     * @return 全部員工人數為最新的資料
     */
    @GetMapping("/findAllLastVersion")
    public ResponseEntity<List<Contacts>> findAllContactsOfLastVersion(){
        return ResponseEntity.ok(contactsService.findAllLastVersionIsTrue());
    }

    @GetMapping("/save")
    public String testVersion(@RequestParam String name){
        contactsRepository.save(ContactsEntity.builder().id(100001L).name(name).build());
        return "finish";
    }



}
