package com.hireguide.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hireguide.dto.HireGuideDTO;
import com.hireguide.service.HireGuideService;

public abstract class HireGuideController {
	
	@Autowired
	HireGuideService guideService;

	org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(HireGuideController.class);
	
	@PostMapping("/create")
	public HireGuideDTO create(@RequestBody HireGuideDTO dto){
		logger.trace("Entering HireGuideController.create()");
		return guideService.create(dto);
	}

	@GetMapping("/list")
	public List<HireGuideDTO> fetchList(){
		logger.trace("Entering HireGuideController.fetchList()");
		return guideService.fetchList();
	}

	@GetMapping("/search")
	public List<HireGuideDTO> search(@RequestBody HireGuideDTO dto){
		logger.trace("Entering HireGuideController.search()");
		return guideService.search(dto);
	}
	
}
