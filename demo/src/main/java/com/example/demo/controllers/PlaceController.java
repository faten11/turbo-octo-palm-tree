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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Place;
import com.example.demo.repository.PlaceRepository;

@RestController
@RequestMapping("/place")
public class PlaceController {
	@Autowired
	private PlaceRepository placeRepository;

	@GetMapping("/find")
	public ResponseEntity<List<Place>> getAlllPlaces() {
		try {
			List<Place> places = new ArrayList<Place>();
			places = placeRepository.findAll();
			return new ResponseEntity<>(places, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/add")
	public Place createPlace(@RequestBody Place place) {
		return placeRepository.save(place);
	}

	@PutMapping("/update")
	public Place place(@RequestBody Place place) {
		return placeRepository.saveAndFlush(place);
	}

	@DeleteMapping("/delete")
	public void deletePlace(@RequestBody Place place) {
		placeRepository.delete(place);
	}

}
