package com.example.contactsbackend.contacts;

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
public class ContactsService {

    private final ContractRepository contractRepository;

    public void save(Contacts contract) {
        ContactsEntity entity = ContractMapper.INSTANCE.toEntity(contract);
        contractRepository.save(entity);
    }
}
