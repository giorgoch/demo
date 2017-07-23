package com.giorgo.demoboot.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.giorgo.demoboot.model.Shipwreck;
import com.giorgo.demoboot.repository.ShipwreckRepository;

@RestController
@RequestMapping("api/v1")
public class ShipwreckController {

	@Autowired
	private ShipwreckRepository shipwreckrepository;

	@RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
	public List<Shipwreck> list() {
		return shipwreckrepository.findAll();
	}

	@PostMapping("shipwrecks")
	public Shipwreck create(@RequestBody Shipwreck shipwreck) {
		return shipwreckrepository.saveAndFlush(shipwreck);
	}

	@GetMapping("shipwrecks/{id}")
	public Shipwreck get(@PathVariable Long id) {
		return shipwreckrepository.findOne(id);
	}

	@PutMapping("shipwreck/{id}")
	public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipwreck) {
		Shipwreck existingShipwreck = shipwreckrepository.findOne(id);
		BeanUtils.copyProperties(shipwreck, existingShipwreck);
		return shipwreckrepository.saveAndFlush(existingShipwreck);

	}

	@DeleteMapping("shipwrecks/{id}")
	public Shipwreck delete(@PathVariable Long id) {
		Shipwreck existingShipwreck = shipwreckrepository.findOne(id);
		shipwreckrepository.delete(existingShipwreck);
		return existingShipwreck;// ShipwreckStub.delete(id);
	}

}
