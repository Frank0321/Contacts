package com.example.contactsbackend.contacts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


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
    Optional<Long> findMaxEmpid();

    void deleteByEmpId(long empId);

    Page<ContactsEntity> findAllByLastVersionIsTrueAndDeletedIsFalseOrderByEmpId(Pageable pageable);

    @Query(value = "select u.* from #{#entityName} u where u.delete = 0 and u.id = (select max(t.id) from #{#entityName} t where t.empid = u.empid)",
            nativeQuery = true)
    List<ContactsEntity> SubQuery();

}
