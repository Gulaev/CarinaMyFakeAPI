package com.slovd.CarinaMyFakeAPI.api.post;

import com.slovd.CarinaMyFakeAPI.api.model.Product;
import com.slovd.CarinaMyFakeAPI.service.JsonUtil;
import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.api_url}/products", methodType = HttpMethodType.POST)
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
@ResponseTemplatePath(path = "api/post/add_new_product_rs.json")
public class AddNewProduct extends AbstractApiMethodV2 {

  public AddNewProduct(Product product) {
    setBodyContent(JsonUtil.toJson(product));
    addProperty("product", product);
    ignorePropertiesProcessor(NotStringValuesProcessor.class);
  }
}
