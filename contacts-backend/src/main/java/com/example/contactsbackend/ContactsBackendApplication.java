package com.example.contactsbackend;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
@Slf4j
public class ContactsBackendApplication {

//	@Autowired
//	ContactsMapper contactsMapper;


	public static void main(String[] args) {
		SpringApplication.run(ContactsBackendApplication.class, args);
	}

	//啟動時，先給一些值
//	@Bean
//	ApplicationRunner init(ContactsRepository repository){
//		return (ApplicationArguments args) -> dataSetup(repository);
//	}
//
//	private void dataSetup(ContactsRepository repository) {
//		List<Contacts> contactsList = List.of(Contacts.builder()
//														.empId(211101L)
//														.name("ABC")
//														.birthday(LocalDate.of(2003, 01, 12))
//														.bloodType(A)
//														.phone("0911321456")
//														.build(),
//											Contacts.builder()
//													.empId(211102L)
//													.name("Peter")
//													.birthday(LocalDate.of(2005, 03, 02))
//													.bloodType(A)
//													.phone("0911321789")
//													.build(),
//											Contacts.builder()
//													.empId(211103L)
//													.name("John")
//													.birthday(LocalDate.of(2007, 06, 05))
//													.bloodType(O)
//													.phone("0911321741")
//													.build());
//		List<ContactsEntity> contactsEntities = contactsMapper.toEntityList(contactsList);
//		log.info(String.valueOf(contactsEntities.get(0).isLastVersion()));
//		repository.saveAll(contactsEntities);
//
//	}

	//建立使用者權限
//	@Bean
//	ApplicationRunner init(UserRepository repository){
//		return (ApplicationArguments args) -> dataSetup(repository);
//	}
//
//	private void dataSetup(UserRepository repository) {
//		repository.save(User.builder().userName("Admin").password("Admin").active(true).roles("ROLE_USER,ROLE_ADMIN").build());
//		repository.save(User.builder().userName("User").password("abc123").active(true).roles("ROLE_USER").build());
//		repository.save(User.builder().userName("test").password("test1234").active(true).roles("ROLE_USER").build());
//	}

//	@Bean
//	public AuditorAware<String> auditorAware(){
//		return new AuditorAwareImpl();
//	}


}
