package com.slovd.CarinaMyFakeAPI.api.post;

import com.slovd.CarinaMyFakeAPI.api.model.User;
import com.slovd.CarinaMyFakeAPI.service.JsonUtil;
import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.Header;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.api_url}/signup", methodType = HttpMethodType.POST)
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
@Header(key ="Content-Type", value ="application/json")
@ResponseTemplatePath(path = "api/post/signup.json")
public class Signup extends AbstractApiMethodV2 {

  public Signup(User user) {
    setBodyContent(JsonUtil.toJson(user));
    addProperty("user", user);
    ignorePropertiesProcessor(NotStringValuesProcessor.class);
  }

}
