package com.slovd.CarinaMyFakeAPI.model;

import lombok.Data;

@Data
public class User {

  private String userName;
  private String firstName;
  private String password;
  private String lastName;
  private String message;
  private Integer contact;
  private Integer mobile;
  private String country;
  private Boolean edm;
  private Boolean verified;
}
