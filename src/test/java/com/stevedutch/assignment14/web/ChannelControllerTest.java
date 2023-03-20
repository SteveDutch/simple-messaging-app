package com.stevedutch.assignment14.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
		verify(model).put("user", model);
	}

	@Test
	public void shouldShowChannel() {

		String result = channelController.showChannel(model);
		assertEquals("/channel", result);
		verify(model).put("user", model);
	}

	@InjectMocks
	private ChannelController channelController;

	@Test
	void myShowChannelTest() {
		ModelMap sut = new ModelMap();
		ChannelController sut2 = new ChannelController();

		String expectedResult = sut2.showChannel(sut);

		assertEquals("/channel", expectedResult);
		assertTrue(sut.containsAttribute("user"));
	}

	@Mock
	private ModelMap modelMap;

	@InjectMocks
	ChannelController underTest;

	@Test
	public void testShowChannel() {
		String viewName = channelController.showChannel(modelMap);
		verify(modelMap, times(1)).put("user", modelMap);
		assertEquals("/channel", viewName);
	}

}
