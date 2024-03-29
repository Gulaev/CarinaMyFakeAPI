package com.slovd.CarinaMyFakeAPI.api.get;

import com.slovd.CarinaMyFakeAPI.api.model.Product;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;

public class ProductGetTest {

  @Test
  public void verifyCanGetAllProductTest() {
    List<Product> products = new ArrayList<>();
    for (int i = 0; i < 20; i++) {
      products.add(new Product());
    }
    GetAllProductsMethod getAllProductsMethod = new GetAllProductsMethod();
    getAllProductsMethod.callAPIExpectSuccess();
    getAllProductsMethod.addProperty("products", products);
    getAllProductsMethod.validateResponse();
  }
}
