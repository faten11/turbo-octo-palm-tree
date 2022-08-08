package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Place;

public interface PlaceRepository extends JpaRepository<Place, Integer> {

}
