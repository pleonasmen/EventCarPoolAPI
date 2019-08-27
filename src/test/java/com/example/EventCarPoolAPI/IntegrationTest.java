package com.example.EventCarPoolAPI;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testGetUsers() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/user")
        )
                .andExpect(status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.content().string(containsString("Mock")))
                .andExpect(MockMvcResultMatchers.content().string(containsString("Barbar")));
    }
/*
    @Test
    public void testGetBookById() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/message/1")
        )
                .andExpect(status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.content().string(containsString("Batman")));
    }

    @Test
    public void testPostBook() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/message")
        )
                .andExpect(status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.content().string(not(containsString("Captain Marvel"))));

        mvc.perform(
                MockMvcRequestBuilders.post("/message")
                        .content(mapper.writeValueAsString(new Message(null, "Good evening", "Captain Marvel")))
                        .contentType(MediaType.APPLICATION_JSON_UTF8));

        mvc.perform(
                MockMvcRequestBuilders.get("/user")
        )
                .andExpect(status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.content().string(containsString("Mock User")));
    }

    @Test
    public void testPutBook() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/message/2")
        )
                .andExpect(status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.content().string(containsString("Goodbye")));

        mvc.perform(
                MockMvcRequestBuilders.put("/message/2")
                        .content(mapper.writeValueAsString(new Message(2L, "Bye bye", "Superman")))
                        .contentType(MediaType.APPLICATION_JSON_UTF8));

        mvc.perform(
                MockMvcRequestBuilders.get("/message/2")
        )
                .andExpect(status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.content().string(containsString("Bye bye")));
    }

    @Test
    public void testDeleteBook() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/message/3")
        )
                .andExpect(status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.content().string(containsString("Good morning")));

        mvc.perform(
                MockMvcRequestBuilders.delete("/message/3")
        );

        mvc.perform(
                MockMvcRequestBuilders.get("/message")
        )
                .andExpect(status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.content().string(not(containsString("Good morning"))));
    }*/
}
