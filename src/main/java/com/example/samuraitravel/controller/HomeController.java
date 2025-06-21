package com.example.samuraitravel.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.samuraitravel.entity.House;
import com.example.samuraitravel.service.HouseService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
	private final HouseService houseService;
	
	@GetMapping("/")
	public String index(Model model) {
		List<House> newHouses = houseService.findTop10HousesByOrderByCreatedAtDesc();
		model.addAttribute("newHouses", newHouses); 
		
		return "index";
	}
	
	
}
