package com.hireguide.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class HireGuideDetail {

	private String candidateId;

	public String getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}
}
