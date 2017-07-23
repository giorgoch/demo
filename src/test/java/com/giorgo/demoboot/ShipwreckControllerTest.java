package com.giorgo.demoboot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.giorgo.demoboot.controller.ShipwreckController;
import com.giorgo.demoboot.model.Shipwreck;
import com.giorgo.demoboot.repository.ShipwreckRepository;

public class ShipwreckControllerTest {

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
		assertEquals(1, wreck.getId().longValue());
	}

	@Test
	public void testgetr() {
		RestTemplate rest = new RestTemplate();

		String id = "1";
		ResponseEntity<String> response = rest.getForEntity("http://localhost:8080/api/v1/shipwrecks", String.class);
		System.out.println(response+"edo");
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}
	
	@Test
	public void testpost() {
		RestTemplate rest = new RestTemplate();

		String id = "1";
		ResponseEntity<String> response = rest.getForEntity("http://localhost:8080/api/v1/shipwrecks.1", String.class);
		System.out.println(response+"edo");
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}


}
