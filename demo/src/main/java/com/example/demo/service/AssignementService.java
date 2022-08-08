package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Citizen;
import com.example.demo.entities.Place;
import com.example.demo.repository.CitizenRepositry;
import com.example.demo.repository.PlaceRepository;

@Service
public class AssignementService {

	@Autowired
	private CitizenRepositry citizenRepositry;
	@Autowired
	private PlaceRepository placeRepository;

	public void assignCitizenToPlace(int citizenId, int placeId) {
		Citizen citizen = citizenRepositry.getById(citizenId);
		Place place = placeRepository.getById(placeId);

		citizen.setPlace(place);

		citizenRepositry.save(citizen);

	}

}
