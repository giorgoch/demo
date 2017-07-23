package com.giorgo.demoboot;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.giorgo.demoboot.controller.ShipwreckController;
import com.giorgo.demoboot.model.Shipwreck;
import com.giorgo.demoboot.repository.ShipwreckRepository;

public class ShipwreckControllerHamcrest {

	@InjectMocks
	private ShipwreckController sc;

	@Mock
	private ShipwreckRepository shipwreckrepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testShipwreckGet() {
		Shipwreck sw = new Shipwreck();
		sw.setId(1L);
		when(shipwreckrepository.findOne(1L)).thenReturn(sw);

		Shipwreck wreck = sc.get(1L);
		// assertEquals(1, wreck.getId().longValue());
		assertThat(wreck.getId(), is(1L));
	}

}
