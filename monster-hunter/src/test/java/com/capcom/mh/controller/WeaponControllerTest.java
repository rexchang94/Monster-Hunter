package com.capcom.mh.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class WeaponControllerTest {

    @Autowired
    MockMvc mockMVvc;

//    @Before
//    public void setup() throws JsonProcessingException {
//    }

//    @Test
//    @WithMockUser
//    public void testController(){
//
//    }


}
