package com.slovd.CarinaMyFakeAPI.api.put;

import com.slovd.CarinaMyFakeAPI.api.model.Product;
import org.testng.annotations.Test;

public class ProductPutTest {

  @Test
  public void verifyIfProductCanUpdateTest() {
    Product product = new Product();
    product.setId(1);
    product.setPrice(100.00);
    product.setTitle("Some title");
    product.setImage("Some image");
    product.setCategory("Some category");
    product.setDescription("Some description");
    UpdateProductByIdMethod updateProductByIdMethod = new UpdateProductByIdMethod(product);
    updateProductByIdMethod.callAPIExpectSuccess();
    updateProductByIdMethod.validateResponse();
  }

}