package com.example.contactsbackend.contacts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * FileName : ContractService
 * CreatTime : 2021/10/31
 * Author : Frank.Chang
 * Description : Contract 的 Service
 */
@Service
@RequiredArgsConstructor
public class ContactsService {

    private final ContactsRepository contactsRepository;

    public void save(ContactsEntity contacts) {
        contactsRepository.save(contacts);
    }
}
