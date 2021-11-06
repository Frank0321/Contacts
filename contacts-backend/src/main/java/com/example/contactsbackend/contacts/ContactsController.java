package com.example.contactsbackend.contacts;

import lombok.RequiredArgsConstructor;
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

    @PostMapping("/save")
    public void saveContract (@RequestBody Contacts contacts){
        contactsService.save(contacts);
    }

    /**
     *
     * @return 全部員工人數為最新的資料
     */
    @GetMapping("/findAllLastVersion")
    public ResponseEntity<List<Contacts>> findAllContactsOfLastVersion(){
        return ResponseEntity.ok(contactsService.findAllLastVersionIsTrue());
    }

}
