/**
 * 
 */
package com.stevedutch.assignment14.web;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author jeg
 *
 */
class MessageRestControllerTest {

	/**
	 * Test method for {@link com.stevedutch.assignment14.web.MessageRestController#getLast10Messages(java.lang.String)}.
	 * @throws JsonProcessingException 
	 */
	@Test
	final void testGetLast10Messages() throws JsonProcessingException {
		MessageRestController sut = new MessageRestController();
		
		String exspectedResult = sut.getLast10Messages();
		
		assertEquals("evoked", exspectedResult);
	}

}
