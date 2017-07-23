package com.giorgo.demoboot;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.giorgo.demoboot.model.Shipwreck;
import com.giorgo.demoboot.repository.ShipwreckRepository;

import com.giorgo.demoboot.DemoBootApplication;

@RunWith(SpringJUnit4ClassRunner.class)
public class ShipwreckRepositoryIntegrationTest {

	@Autowired
	private ShipwreckRepository shipwreckrepository;

	@Test
	public void testFindAll() {// edo xtypa theli alo annotation
		List<Shipwreck> wrecks = shipwreckrepository.findAll();
		assertThat(wrecks.size(), is(greaterThanOrEqualTo(0)));
	}

}
