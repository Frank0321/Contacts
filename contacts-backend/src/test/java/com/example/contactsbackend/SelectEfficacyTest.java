package com.example.contactsbackend;

import com.example.contactsbackend.contacts.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static com.example.contactsbackend.contacts.BloodType.*;

/**
 * FileName : SelectEfficacyTest
 * CreatTime : 2022/1/17
 * Author : Frank.Chang
 * Description :
 */
@Slf4j
@SpringBootTest
public class SelectEfficacyTest {

    @Autowired
    ContactsService service;

    @Test
    void findAll(){
        service.createContacts(Contacts.builder()
                .name("ABC")
                .birthday(LocalDate.now())
                .bloodType(A)
                .phone("0945852123")
                .build());
        log.info(String.valueOf(service.findAllLastVersionIsTrueDeleteFalse().size()));
    }

}
