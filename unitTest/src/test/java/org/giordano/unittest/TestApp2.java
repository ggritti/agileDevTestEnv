package org.giordano.unittest;

import org.giordano.test.App;
import org.junit.Assert;
import org.junit.Test;

public class TestApp2 {

	@Test
	public void testPrintHelloWorld2() {
		
		Assert.assertEquals(App.getHelloWorld2(), "Hello World 2");

	}

}
