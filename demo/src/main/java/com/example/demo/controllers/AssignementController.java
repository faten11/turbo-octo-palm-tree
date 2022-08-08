package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AssignementService;

@RestController
@RequestMapping("/api")
public class AssignementController {
	@Autowired
	private AssignementService assignementService;

	@GetMapping("/assign")
	public String assignCitizenToPlace(@RequestParam int idCitizen, @RequestParam int idPlace) {

		assignementService.assignCitizenToPlace(idCitizen, idPlace);
		return "ok";

	}

}
