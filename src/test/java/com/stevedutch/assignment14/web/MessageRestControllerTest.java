package com.stevedutch.assignment14.web;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.stevedutch.assignment14.service.MessageService;

@ExtendWith(MockitoExtension.class)
 class MessageRestControllerTest{

	@InjectMocks
	MessageRestController underTest;
	@Mock
	MessageService messageService;
	@Test
	 void testGetLast10Messages() throws Exception {
	// given
	// when
	String actual = underTest.getLast10Messages();
	// then
	assertThat(actual).isEqualTo("TestExpected");
	} 
}