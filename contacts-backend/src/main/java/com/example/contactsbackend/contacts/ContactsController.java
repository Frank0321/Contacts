package com.example.contactsbackend.contacts;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FileName : ContractController
 * CreatTime : 2021/10/31
 * Author : Frank.Chang
 * Description :
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/contract")
public class ContactsController {

    private final ContactsService contactsService;

    @PostMapping("/save")
    public void saveContract (@RequestBody ContactsEntity contacts){
        contactsService.save(contacts);
    }

}
