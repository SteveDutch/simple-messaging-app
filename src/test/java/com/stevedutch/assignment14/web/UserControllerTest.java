package com.stevedutch.assignment14.web;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.ModelMap;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

	@Mock
	private ModelMap model;

	@InjectMocks
	private UserController controller;

	@Test
	public void testWelcomeUser() {

		model.addAttribute("user", model);

		String view = controller.welcomeUser(model);

		assertEquals("/welcome", view);
		verify(model).put("user", model);
	}

}
