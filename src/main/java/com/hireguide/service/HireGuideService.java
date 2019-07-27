package com.hireguide.service;

import java.util.List;

import com.hireguide.dto.HireGuideDTO;

public interface HireGuideService {

	HireGuideDTO create(HireGuideDTO dto);

	List<HireGuideDTO> fetchList();

	List<HireGuideDTO> search(HireGuideDTO dto);
}
