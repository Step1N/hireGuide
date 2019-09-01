package com.hireguide.model;


public class Page {

  public void setContent(String content) {
    this.content = content;
  }

  private String content;

  public Page(final String content) {
    this.content = content;
  }

  public String getContent() {
    return content;
  }

}
