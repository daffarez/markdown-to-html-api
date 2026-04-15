package com.daffarez.markdown_to_html_api.controller;

import com.daffarez.markdown_to_html_api.service.MarkdownService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ConverterControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new ConverterController(new MarkdownService())).build();
    }

    @Test
    void testSimple() throws Exception {
        mockMvc.perform(post("/api/v1/convert")
                        .contentType("application/json")
                        .content("{\"markdown\":\"# Hello\"}"))
                .andExpect(status().isOk());
    }
}