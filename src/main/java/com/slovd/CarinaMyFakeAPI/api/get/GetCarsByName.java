package com.slovd.CarinaMyFakeAPI.api.get;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.api_url}/cars/name/${name}", methodType = HttpMethodType.GET)
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
@ResponseTemplatePath(path = "api/get/get_cars_by_name_rs.json")
public class GetCarsByName extends AbstractApiMethodV2 {

  public GetCarsByName(String name) {
    replaceUrlPlaceholder("name", name);
    ignorePropertiesProcessor(NotStringValuesProcessor.class);
  }
}
