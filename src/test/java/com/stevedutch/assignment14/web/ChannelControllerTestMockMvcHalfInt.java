package com.stevedutch.assignment14.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;


// XXX Integration Test deactivated

@WebMvcTest(ChannelController.class)
public class ChannelControllerTestMockMvcHalfInt {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testShowChannel() throws Exception {
        mockMvc.perform(get("/channel"))
                .andExpect(status().isOk())
                .andExpect(view().name("/channel"))
                .andExpect(model().attributeExists("user"));
    }
}
