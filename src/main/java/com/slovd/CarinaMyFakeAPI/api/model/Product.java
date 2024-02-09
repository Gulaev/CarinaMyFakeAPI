package com.slovd.CarinaMyFakeAPI.api.model;

import lombok.Data;

@Data
public class Product {

  private Integer id;
  private String title;
  private Double price;
  private String category;
  private String image;
  private String description;
}
