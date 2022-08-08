package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Citizen;

public interface CitizenRepositry extends JpaRepository<Citizen, Integer> {

}
