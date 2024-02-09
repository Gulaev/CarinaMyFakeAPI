package com.slovd.CarinaMyFakeAPI.api.delete;

import com.slovd.CarinaMyFakeAPI.api.model.Product;
import org.testng.annotations.Test;

public class ProductDeleteTest {

  @Test
  public void verifyCanDeleteProductByIdTest() {
    Product product = new Product();
    product.setId(1);
    product.setPrice(109.95);
    product.setTitle("Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops");
    product.setImage("https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg");
    product.setCategory("men's clothing");
    product.setDescription("Your perfect pack for everyday use and walks in the forest. Stash your "
        + "laptop (up to 15 inches) in the padded sleeve, your everyday");
    DeleteProductByIdMethod deleteProductByIdMethod = new DeleteProductByIdMethod(product);
    deleteProductByIdMethod.callAPIExpectSuccess();
    deleteProductByIdMethod.validateResponse();
  }
}
