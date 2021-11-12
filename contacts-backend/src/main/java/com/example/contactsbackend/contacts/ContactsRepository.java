package com.example.contactsbackend.contacts;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


/**
 * FileName : ContractRepository
 * CreatTime : 2021/10/31
 * Author : Frank.Chang
 * Description : Contract JPA
 */
public interface ContactsRepository extends JpaRepository<ContactsEntity, Long> {

    List<ContactsEntity> findAllByLastVersionIsTrue();

    ContactsEntity findByEmpIdAndLastVersionIsTrue(Long empId);

}
