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

    public void save(Contacts contacts) {
        ContactsEntity entity = ContactsMapper.INSTANCE.toEntity(contacts);
        contactsRepository.save(entity);
    }

    /**
     * 找尋全部的有效資料
     */
    public List<Contacts> findAllLastVersionIsTrue() {
        List<ContactsEntity> contactsEntityList = contactsRepository.findAllByLastVersionIsTrue();
        List<Contacts> contactsList = ContactsMapper.INSTANCE.fromEntityList(contactsEntityList);
        return contactsList;
    }

    /**
     * 查詢單一筆資料
     * @param empId
     * @return
     */
    public Contacts findContacts(Long empId) {
        ContactsEntity contactsEntity = contactsRepository.findByEmpIdAndLastVersionIsTrue(empId);
        Contacts contacts = ContactsMapper.INSTANCE.fromEntity(contactsEntity);
        return contacts;
    }

    /**
     * 更新資料
     *
     */
    public void updateContacts(Contacts contacts) {
        //將原本資料的 LastVersion 改成 false
        ContactsEntity contactsEntity = contactsRepository.findByEmpIdAndLastVersionIsTrue(contacts.getEmpId());
        contactsEntity.setLastVersion(false);
        contactsRepository.save(contactsEntity);

        //將傳入的資料，版本號 + 1
        ContactsEntity requestsContacts = ContactsMapper.INSTANCE.toEntity(contacts);
        requestsContacts.setSeq(contactsEntity.getSeq()+1);
        contactsRepository.save(requestsContacts);


    }

    /**
     * 新增一筆資料
     * 新增一筆資料時，先判斷目前員工編號最大值，再依序往後遞增
     */




    /**
     * 刪除資料
     */
}
