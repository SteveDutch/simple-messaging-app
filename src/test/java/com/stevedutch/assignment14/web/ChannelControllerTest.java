package com.stevedutch.assignment14.web;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.ModelMap;

@ExtendWith(MockitoExtension.class)
@WebAppConfiguration
@AutoConfigureMockMvc
class ChannelControllerTest extends ChannelController {

	@Mock
	private ModelMap model;

	@InjectMocks
	private ChannelController controller;

	@Test
	public void showChannelTest() {

		model.addAttribute("user", model);

		String view = controller.showChannel(model);

		assertEquals("/channel", view);
	}

	@Test
	public void shouldShowChannel() {

		String result = controller.showChannel(model);
		assertEquals("/channel", result);
	}

	@Test
	void myShowChannelTest() {
		ModelMap sut = new ModelMap();
		ChannelController sut2 = new ChannelController();

		String expectedResult = sut2.showChannel(sut);

		assertEquals("/channel", expectedResult);
		assertFalse(sut.containsAttribute("user"));
	}

	@Test
	public void testShowChannel() {
		String viewName = controller.showChannel(model);
		verify(model, never()).put("user", model);
		assertEquals("/channel", viewName);
	}

}
