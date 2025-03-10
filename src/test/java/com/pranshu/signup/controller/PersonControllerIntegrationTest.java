//package com.pranshu.crudbasic.controller;
//
//import com.pranshu.crudbasic.model.Person;
//import com.pranshu.crudbasic.repository.PersonRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.test.web.server.LocalServerPort;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//class PersonControllerIntegrationTest {
//
//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Autowired
//    private PersonRepository personRepository;
//
//    private String baseUrl;
//
//    @BeforeEach
//    void setUp() {
//        baseUrl = "http://localhost:" + port + "/PersonDetails";
//        personRepository.deleteAll(); // Clean up database before each test
//
//        personRepository.save(new Person(null, "A", "IT"));
//        personRepository.save(new Person(null, "B", "HR"));
//    }
//
//    @Test
//    void getAllPersonDetails_ShouldReturnAllPersons() {
//        List<?> response = restTemplate.getForObject(baseUrl, List.class);
//        assertThat(response).hasSize(2);
//    }
//
//    @Test
//    void getPersonDetails_ShouldReturnPersonById() {
//        Person person = personRepository.findAll().get(0);
//        Person response = restTemplate.getForObject(baseUrl + "/" + person.getId(), Person.class);
//        assertThat(response).isNotNull();
//        assertThat(response.getName()).isEqualTo(person.getName());
//    }
//
//    @Test
//    void createPerson_ShouldAddNewPerson() {
//        Person newPerson = new Person(null, "C", "Finance");
//        restTemplate.postForObject(baseUrl, newPerson, String.class);
//
//        List<Person> allPersons = personRepository.findAll();
//        assertThat(allPersons).hasSize(3);
//        assertThat(allPersons).extracting(Person::getName).contains("C");
//    }
//
//    @Test
//    void deletePerson_ShouldRemovePerson() {
//        Person person = personRepository.findAll().get(0);
//        restTemplate.delete(baseUrl + "/" + person.getId());
//        List<Person> remainingPersons = personRepository.findAll();
//        assertThat(remainingPersons).hasSize(1);
//        assertThat(remainingPersons).extracting(Person::getName).doesNotContain(person.getName());
//    }
//}
