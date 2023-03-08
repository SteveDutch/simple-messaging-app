package com.stevedutch.assignment14.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.ModelMap;

// TODO Aufräumen

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
@AutoConfigureMockMvc
class ChannelControllerTest extends ChannelController {
	
	// powered by YouCom
	    @Mock
	    private ModelMap model;

	    @InjectMocks
	    private ChannelController controller;

	    @Test
	    public void showChannelTest() {
	    	// XXX MockitoAnnotations.initMocks(this); --> deprecated, stattdessen siehe oben, @extend...
	    	// ansonsten werden die mocks nicht initialisiert und liefern null zurück
	    	model.addAttribute("user", model);

	    	String view = controller.showChannel(model);
	        
	        assertEquals("/channel", view);
	        verify(model).put("user", model);
	    }
	    // powered by You.Com 2. Runde
	    @Test
	    public void shouldShowChannel() {
	        //when(model.put("user", model)).thenReturn(true); --> da mock initialisiert (s.o.) nicht mehr notwendig
	        String result = channelController.showChannel(model);
	        assertEquals("/channel", result);
	        verify(model).put("user", model);
	    }
	// powered by ChatGPT  --> ist eher ein Integrationtest! Deshalb läuft es hier wohl nicht, bzw.mit NullPointerException:
	// kein @WebMvcTest(ChannelController.class)-Annotation, also läuft SPRING nicht, also keinController,
	    // also mockMVC leer ---> CODE GELÖSCHT, BEIZEITEN NACHVOLLZIEHEN

	    @InjectMocks
	    private ChannelController channelController;
	    
	    @Test
	    void myShowChannelTest() {
	    	ModelMap sut = new ModelMap();
	    	ChannelController sut2= new ChannelController();
	    	
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

