package com.stevedutch.assignment14.web;


import static org.assertj.core.api.Assertions.assertThat;

import com.stevedutch.assignment14.dto.MessageTextAndUserDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.stevedutch.assignment14.service.MessageService;

import java.util.List;

@ExtendWith(MockitoExtension.class)
 class MessageControllerTest {

	@InjectMocks
	MessageController underTest;
	@Mock
	MessageService messageService;
	@Test
	 void testGetLast10Messages() throws Exception {
	// given
	// XXX ok, it's running, but ... 
	// when
	List<MessageTextAndUserDTO> actual = underTest.getLast10Messages();
	// then
	assertThat(actual.size()).isEqualTo(0);
	} 
}