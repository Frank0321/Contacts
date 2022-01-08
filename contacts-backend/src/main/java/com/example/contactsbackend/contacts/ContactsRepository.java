package com.example.contactsbackend.contacts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    List<ContactsEntity> findAllByLastVersionIsTrueAndDeletedIsFalseOrderByEmpId();

    ContactsEntity findByEmpIdAndLastVersionIsTrue(Long empId);

    ContactsEntity findByEmpIdAndLastVersionIsTrueAndDeletedIsFalse(Long empId);

    @Query(value = "select max(empId) from #{#entityName}")
    long findMaxEmpid();

    void deleteByEmpId(long empId);

    Page<ContactsEntity> findAllByLastVersionIsTrueAndDeletedIsFalseOrderByEmpId(Pageable pageable);

}
