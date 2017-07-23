package com.giorgo.demoboot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.giorgo.demoboot.controller.HomeController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoBootApplicationTests {

	@Test
	public void testApp() {
		HomeController hc = new HomeController();
		String result = hc.getHome();
		assertEquals(result, "das boot");
	}

}
