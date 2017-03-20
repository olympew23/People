package com.theironyard.novauc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.theironyard.novauc.entities.Person;
import com.theironyard.novauc.services.PersonRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedWebApplicationContext;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PeopleApplicationTests {




	@Autowired
	WebApplicationContext wap;

	@Autowired
	PersonRepository persons;

	MockMvc mockMvc;


	@Before
	public void before(){
		mockMvc = MockMvcBuilders.webAppContextSetup(wap).build();
	}

	@Test
	public void addPerson()  throws Exception{
		Person person = new Person();
		person.setName("Terrell");
		person.setAddress("555 MaryLane");
		person.setPhone("773-234-5081");
		person.setBirthDay("12/25/1985");
		person.setEmail("terrell@pickle.com");

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(person);

		mockMvc.perform(
				MockMvcRequestBuilders.post("/person")
						.content(json)
						.contentType("application/json")
		);

		Assert.assertTrue(persons.count() == 2);
	}


	@Test
	public void updatePerson() throws Exception{
		Person p = new Person();
		Person person = new Person();
		person.setName("Terrell");
		person.setAddress("555 MaryLane");
		person.setPhone("773-234-5081");
		person.setBirthDay("12/25/1985");
		person.setEmail("terrell@pickle.com");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(p);

		mockMvc.perform(MockMvcRequestBuilders.put("/person").content(json).contentType("application/json")

		);
	Assert.assertTrue(persons.count() == 1);
// is a poorly written test
	}



	@Test
	public void getPerson() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/person/1"));


	}

	@Test
	public void deletePerson() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.delete("/person/1")
		);

		Assert.assertTrue(persons.count() == 1);
	}



}


