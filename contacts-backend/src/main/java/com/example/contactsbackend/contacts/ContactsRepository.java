package com.example.contactsbackend.contacts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * FileName : ContractRepository
 * CreatTime : 2021/10/31
 * Author : Frank.Chang
 * Description : Contract JPA
 */
public interface ContactsRepository extends JpaRepository<ContactsEntity, Long> {

    List<ContactsEntity> findAllByLastVersionIsTrue();

    List<ContactsEntity> findAllByLastVersionIsTrueOrderByEmpId();

    ContactsEntity findByEmpIdAndLastVersionIsTrue(Long empId);

    @Query(value = "select max(empId) from #{#entityName}")
    long findMaxEmpid();

    void deleteByEmpId(long empId);

}
