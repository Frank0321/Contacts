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

    //SELECT * FROM CONT_CONTACTS WHERE LAST_VERSION = 1 AND DELETED = 0
    List<ContactsEntity> findAllByLastVersionIsTrueAndDeletedIsFalseOrderByEmpId();

    ContactsEntity findByEmpIdAndLastVersionIsTrue(Long empId);

    ContactsEntity findByEmpIdAndLastVersionIsTrueAndDeletedIsFalse(Long empId);

    @Query(value = "select max(empId) from #{#entityName}")
    Optional<Long> findMaxEmpid();

    void deleteByEmpId(long empId);

    Page<ContactsEntity> findAllByLastVersionIsTrueAndDeletedIsFalseOrderByEmpId(Pageable pageable);

    //SELECT * FROM CONT_CONTACTS WHERE SEQ = (SELECT MAX(C.SEQ) FROM CONT_CONTACTS C WHERE C.EMP_ID = EMP_ID)
    @Query(value = "select f.* from cont_contacts f where f.seq = (select max(t.seq) from cont_contacts t where t.emp_id = f.emp_id)",
            nativeQuery = true)
    List<ContactsEntity> findAllBySubQuery();

}
