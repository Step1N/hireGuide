package com.hireguide.service.Impl;

import java.util.List;

import com.hireguide.model.HireGuideDetail;
import org.springframework.beans.factory.annotation.Autowired;

import com.hireguide.dto.HireGuideDTO;
import com.hireguide.repository.HireGuideRepository;
import com.hireguide.service.HireGuideService;
import org.springframework.stereotype.Service;

@Service
public class HireGuideServiceImpl implements HireGuideService{
	
	@Autowired
	HireGuideRepository hireGuideRepository; 
	
	@Override
	public HireGuideDTO create(HireGuideDTO dto) {

		HireGuideDetail hireGuideDetail = new HireGuideDetail();
		hireGuideDetail.setCandidateId(dto.getCandidateId());
		hireGuideRepository.save(hireGuideDetail);

		return dto;
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
