package com.example.contactsbackend.contacts;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * FileName : ContractService
 * CreatTime : 2021/10/31
 * Author : Frank.Chang
 * Description : Contract 的 Service
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ContactsService {

    private final ContactsRepository contactsRepository;

    public void save(ContactsEntity contacts) {
        contactsRepository.save(contacts);
    }


    public void save(Contacts contacts) {
        ContactsEntity entity = ContactsMapper.INSTANCE.toEntity(contacts);
        contactsRepository.save(entity);
    }

    public List<Contacts> findAll() {
        List<ContactsEntity> contactsEntityList = contactsRepository.findAll();
        List<Contacts> contactsList = ContactsMapper.INSTANCE.fromEntityList(contactsEntityList);
        return contactsList;
    }

    /**
     * 新增一筆資料時，先判斷目前員工編號最大值，再依序往後遞增
     */
}
