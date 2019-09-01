package com.hireguide.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Page {
  private String content;

  public Page(String content) {
    this.content = content;
  }

  public String getContent() {
    return content;
  }

}
