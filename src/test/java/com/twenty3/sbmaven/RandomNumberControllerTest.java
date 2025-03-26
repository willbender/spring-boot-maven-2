package com.twenty3.sbmaven;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(RandomNumberController.class)
class RandomNumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetRandomNumbers_validNumber() throws Exception {
        int number = 5;
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/random")
                .param("number", String.valueOf(number)))
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        assertNotNull(responseContent, "Response should not be null");

        String[] numbers = responseContent.replace("[", "").replace("]", "").split(",");
        assertEquals(number, numbers.length, "The number of random integers should match the requested number");
    }

    @Test
    void testGetRandomNumbers_zeroNumber() throws Exception {
        int number = 0;
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/random")
                .param("number", String.valueOf(number)))
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        assertEquals("[]", responseContent, "Response should be an empty array for zero input");
    }

}