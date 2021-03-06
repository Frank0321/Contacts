package com.example.contactsbackend.contacts;

import com.sun.xml.bind.v2.TODO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * FileName : ContractService
 * CreatTime : 2021/10/31
 * Author : Frank.Chang
 * Description : Contract 的 Service
 */
//TODO : 在適當的方法加上 Transactional
//TODO : 新增 log 的管理
@Service
@RequiredArgsConstructor
@Slf4j
public class ContactsService {

    private final ContactsRepository contactsRepository;
    private final ContactsMapper contactsMapper;
    /**
     * 新增一筆資料
     * 新增一筆資料時，先判斷目前員工編號最大值，再依序往後遞增
     * TODO 有時候 Mapper 會失敗 ?!
     * @param contacts
     */
    public void createContacts(Contacts contacts) {
        long maxEmpid = contactsRepository.findMaxEmpid().orElse(220100L);
        contacts.setEmpId(maxEmpid+1);
        log.info("contacts maxEmpid", contacts.getEmpId());
        ContactsEntity entity = contactsMapper.toEntity(contacts);
        log.info("entity maxEmpid", entity.getEmpId());
        contactsRepository.save(entity);
    }

    /**
     * 找尋全部的有效資料，用欄位 last_Version 為 true 來判斷為最新的資料
     */
    public List<Contacts> findAllLastVersionIsTrueDeleteFalse() {
//        List<ContactsEntity> contactsEntityList = contactsRepository.findAllByLastVersionIsTrue();
//        List<ContactsEntity> contactsEntityList = contactsRepository.findAllByLastVersionIsTrueOrderByEmpId();
        List<ContactsEntity> contactsEntityList = contactsRepository.findAllByLastVersionIsTrueAndDeletedIsFalseOrderByEmpId();
        List<Contacts> contactsList = contactsMapper.fromEntityList(contactsEntityList);
        return contactsList;
    }

    /**
     * 找尋全部的有效資料，用仔查詢的方式查詢
     * @return
     */
    public List<Contacts> findAllByUsingSubQuery(){
        List<ContactsEntity> contactsEntityList = contactsRepository.findAllBySubQuery();
        return contactsMapper.fromEntityList(contactsEntityList);
    }

    /**
     * 查詢單一筆資料，用欄位 last_Version 為 true 來判斷為最新的資料
     * @param empId
     * @return
     */
    public Contacts findContacts(Long empId) {
//        ContactsEntity contactsEntity = contactsRepository.findByEmpIdAndLastVersionIsTrue(empId);
        ContactsEntity contactsEntity = contactsRepository.findByEmpIdAndLastVersionIsTrueAndDeletedIsFalse(empId);
        Contacts contacts = contactsMapper.fromEntity(contactsEntity);
        return contacts;
    }

    /**
     * 更新資料
     * 使用 @Version 的時候，需要將資料從資料庫讀出來，在存回去，version 則會自動加 1
     * 但是原本的資料會被 update (會被更新)
     */
    public void updateContacts(Contacts contacts) {
        //將原本資料的 LastVersion 改成 false
//        ContactsEntity contactsEntity = contactsRepository.findByEmpIdAndLastVersionIsTrue(contacts.getEmpId());
        ContactsEntity contactsEntity = contactsRepository.findByEmpIdAndLastVersionIsTrueAndDeletedIsFalse(contacts.getEmpId());
        contactsEntity.setLastVersion(false);
        contactsRepository.save(contactsEntity);

        //將傳入的資料，版本號 + 1
        ContactsEntity requestsContacts = contactsMapper.toEntity(contacts);
        requestsContacts.setSeq(contactsEntity.getSeq()+1);
        contactsRepository.save(requestsContacts);
    }

    /**
     * 刪除資料
     * 不需要直接刪除資料，需要保留起來
     */
    public void deleteContacts(long id) {
        ContactsEntity contactsEntity = contactsRepository.findByEmpIdAndLastVersionIsTrue(id);
        contactsEntity.setDeleted(true);
        contactsRepository.save(contactsEntity);
//        contactsRepository.deleteByEmpId(id);
        //No EntityManager with actual transact ion available for current thread - cannot reliably process 'remove' call
    }

    /**
     * 以分頁回傳資資料
     * @param page
     * @return
     */
    public Page<Contacts> findContactsByPage(Pageable page) {
        return contactsRepository.findAllByLastVersionIsTrueAndDeletedIsFalseOrderByEmpId(page)
                .map(contactsMapper::fromEntity);
    }
}
