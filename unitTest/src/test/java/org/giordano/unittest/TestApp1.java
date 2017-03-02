package org.giordano.unittest;

import org.giordano.test.App;
import org.junit.Assert;
import org.junit.Test;

public class TestApp1 {

	@Test
	public void testPrintHelloWorld() {
		
		Assert.assertEquals(App.getHelloWorld(), "Hello World");

	}
}
