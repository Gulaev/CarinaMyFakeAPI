package com.slovd.CarinaMyFakeAPI.api.get;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;


@Endpoint(url = "${config.api_url}/products", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/get/get_all_product_rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetAllProducts extends AbstractApiMethodV2 {

  public GetAllProducts() {
    ignorePropertiesProcessor(NotStringValuesProcessor.class);
  }
}
