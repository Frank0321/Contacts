package com.example.contractbackend.contract;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * FileName : ContractRepository
 * CreatTime : 2021/10/31
 * Author : Frank.Chang
 * Description : Contract JPA
 */
public interface ContractRepository extends JpaRepository<ContractEntity, Long> {

}
