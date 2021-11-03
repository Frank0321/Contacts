package com.example.contactsbackend;

import com.example.contactsbackend.contacts.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static com.example.contactsbackend.contacts.BloodType.*;

@SpringBootApplication
public class ContactsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactsBackendApplication.class, args);
	}

	//啟動時，先給一些值
	@Bean
	ApplicationRunner init(ContactsRepository repository){
		return (ApplicationArguments args) -> dataSetup(repository);
	}

	private void dataSetup(ContactsRepository repository) {
//		repository.save(ContactsEntity.builder()
//				.empId(211103L)
//				.name("Rhys")
//				.birthday(LocalDate.of(2021,11,05))
//				.bloodType(A)
//				.phone("0963101110")
//				.build());

		List<Contacts> contactsList = List.of(Contacts.builder()
														.empId(211101L)
														.name("Matt")
														.birthday(LocalDate.of(2003, 01, 12))
														.bloodType(A)
														.phone("0911321456")
														.build(),
											Contacts.builder()
													.empId(211102L)
													.name("Rhys")
													.birthday(LocalDate.of(2005, 03, 02))
													.bloodType(A)
													.phone("0911321789")
													.build(),
											Contacts.builder()
													.empId(211103L)
													.name("John")
													.birthday(LocalDate.of(2007, 06, 05))
													.bloodType(O)
													.phone("0911321741")
													.build());
		List<ContactsEntity> contactsEntities = ContactsMapper.INSTANCE.toEntityList(contactsList);
		repository.saveAll(contactsEntities);

	}

}
