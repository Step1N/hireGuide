package com.hireguide.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.hireguide.dto.HireGuideDTO;
import com.hireguide.model.HireGuideDetail;

/**
 * @author Rahul.Jaiswal5
 *
 */
@Repository
public interface HireGuideRepository extends MongoRepository<HireGuideDetail, String> {
	
	List<HireGuideDTO> findByPartyId(int partyId);
	
	HireGuideDetail findById(long id);
	
	HireGuideDetail save(HireGuideDetail hireGuideDetail);

}
