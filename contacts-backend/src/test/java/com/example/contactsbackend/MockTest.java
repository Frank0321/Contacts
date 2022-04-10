
package com.example.contactsbackend;

import static com.example.contactsbackend.contacts.BloodType.A;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.contactsbackend.contacts.Contacts;
import com.example.contactsbackend.contacts.ContactsEntity;
import com.example.contactsbackend.contacts.ContactsMapper;
import com.example.contactsbackend.contacts.ContactsRepository;
import com.example.contactsbackend.contacts.ContactsService;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @file MockTest.java
 * @Create 2022年4月10日
 * @Author Frank
 * @@Description : 使用 Mock 的方式進行測試
 */

@SpringBootTest
@Slf4j
public class MockTest {

	@Autowired
	ContactsService service;
	
	@Autowired
	ContactsRepository repository;
	
	@MockBean
	private ContactsMapper mapper;
	
	
	@Test
	void SaveEntityTest() {
		log.info("create new contact");
        Contacts contacts = Contacts.builder().empId(1L)
        		.name("EffectTest")
                .birthday(LocalDate.now())
                .bloodType(A)
                .phone("0912456789")
                .build();
        
        log.info("new contact : {}", contacts.toString());
        Mockito.when(mapper.toEntity(contacts))
        .thenReturn(ContactsEntity.builder()
        		.empId(1L)
				.name(contacts.getName())
				.birthday(LocalDate.now())
				.bloodType(A)
				.phone("0912456789")
				.build());
        
        ContactsEntity entity = mapper.toEntity(contacts);
		log.info("new entity : {}", entity.toString());
		
//		repository.save(entity);
		
		service.createContacts(contacts);
		
		log.info("save is finish");
		
		List<ContactsEntity> list = repository.findAll();
		log.info("find from entity : {}", list.get(0).toString());
		
        
		
	}
}
