package com.slovd.CarinaMyFakeAPI.api.post;

import com.slovd.CarinaMyFakeAPI.api.model.Product;
import org.testng.annotations.Test;

public class ProductPostTest {

  @Test
  public void verifyIfCanCreateNewProduct() {
    Product product = new Product();
    product.setId(21);
    product.setCategory("Mens Hats");
    product.setTitle("Some title");
    product.setImage("Some image");
    product.setPrice(100.00);
    product.setDescription("Some description");
    AddNewProduct addNewProduct = new AddNewProduct(product);
    addNewProduct.callAPIExpectSuccess();
    addNewProduct.validateResponse();
  }

}
