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
    private final ContactsRepository contactsRepository;

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

    @GetMapping("/save")
    public String testVersion(@RequestParam String name){
        contactsRepository.save(ContactsEntity.builder().id(100001L).name(name).build());
        return "finish";
    }


}
