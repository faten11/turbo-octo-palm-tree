package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Citizen;
import com.example.demo.repository.CitizenRepositry;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
	@Autowired
	private CitizenRepositry citizenRepositry;

	@GetMapping("/findall")
	public ResponseEntity<List<Citizen>> getAllCitisens(@RequestParam(required = false) String title) {
		try {
			List<Citizen> citizens = new ArrayList<Citizen>();
			citizens = citizenRepositry.findAll();
			return new ResponseEntity<>(citizens, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/add")
	public Citizen createCitizen(@RequestBody Citizen citizen) {
		return citizenRepositry.save(citizen);
	}

	@PutMapping("/update")
	public Citizen citizen(@RequestBody Citizen citizen) {
		return citizenRepositry.saveAndFlush(citizen);

	}

	@DeleteMapping("/delete")
	public void deleteCitizen(@RequestBody Citizen citizen) {
		citizenRepositry.delete(citizen);
	}

}
