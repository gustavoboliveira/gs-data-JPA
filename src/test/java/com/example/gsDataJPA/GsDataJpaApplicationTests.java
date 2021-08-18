package com.example.gsDataJPA;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class GsDataJpaApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	void testControllerFindAll() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/customers/"))
			.andExpect(status().isOk())
			.andExpect(content().json("[{\"id\":1,\"firstName\":\"Jack\",\"lastName\":\"Bauer\"},{\"id\":2,\"firstName\":\"Chloe\",\"lastName\":\"O'Brian\"},{\"id\":3,\"firstName\":\"Kim\",\"lastName\":\"Bauer\"},{\"id\":4,\"firstName\":\"David\",\"lastName\":\"Palmer\"},{\"id\":5,\"firstName\":\"Michelle\",\"lastName\":\"Dessler\"}]"));
	}
	
	@Test
	void testControllerFindById() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/customers/id/2"))
				.andExpect(status().isOk())
				.andExpect(content().string("{\"id\":2,\"firstName\":\"Chloe\",\"lastName\":\"O'Brian\"}"));
	}
	
	@Test
	void testControllerFindByLastName() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/customers/name/Bauer"))
			.andExpect(status().isOk())
			.andExpect(content().string("[{\"id\":1,\"firstName\":\"Jack\",\"lastName\":\"Bauer\"},{\"id\":3,\"firstName\":\"Kim\",\"lastName\":\"Bauer\"}]"));
	}
		
}
