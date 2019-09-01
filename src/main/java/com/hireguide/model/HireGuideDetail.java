package com.hireguide.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "candidates")
public class HireGuideDetail {

  @Id
  private String candidateId;
  private String contactNumber;
  private String email;
  private String name;
  private List<Page> pages;

  public HireGuideDetail(final String contactNumber,
                              final String email,
                              final String name,
                              final List<Page> pages) {
    this.candidateId = candidateId;
    this.contactNumber = contactNumber;
    this.email = email;
    this.name = name;
    this.pages = pages;

  }

  public List<Page> getPages() {
    if (null == pages) {
      return new ArrayList<Page>();
    }
    return pages;
  }

  public String getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getCandidateId() {
    return candidateId;
  }

  public void setCandidateId(String candidateId) {
    this.candidateId = candidateId;
  }
}
