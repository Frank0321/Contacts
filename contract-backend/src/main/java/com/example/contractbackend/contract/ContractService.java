package com.example.contractbackend.contract;

import lombok.AllArgsConstructor;
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
public class ContractService {

    private final ContractRepository contractRepository;

    public void save(ContractEntity contract) {
        contractRepository.save(contract);
    }
}
