package com.example.contactsbackend.contacts;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * FileName : ContractController
 * CreatTime : 2021/10/31
 * Author : Frank.Chang
 * Description :
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/contacts")
public class ContactsController {

    private final ContactsService contactsService;

    @PostMapping("/save")
    public void saveContract (@RequestBody Contacts contacts){
        contactsService.save(contacts);
    }

    @GetMapping("/findAll")
    public List<Contacts> findAllContacts(){
        return contactsService.findAll();
    }

}
