package com.hireguide.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hireguide.dto.HireGuideDTO;
import com.hireguide.repository.HireGuideRepository;
import com.hireguide.service.HireGuideService;

public class HireGuideServiceImpl implements HireGuideService{
	
	@Autowired
	HireGuideRepository hireGuideRepository; 
	
	@Override
	public HireGuideDTO create(HireGuideDTO dto) {

		return null;
	}
	@Override
	public List<HireGuideDTO> fetchList() {

		return null;
	}
	
	@Override
	public List<HireGuideDTO> search(HireGuideDTO dto) {

		return null;
	}
}
