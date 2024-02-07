package com.slovd.CarinaMyFakeAPI.api.post;


import com.slovd.CarinaMyFakeAPI.model.User;
import com.slovd.CarinaMyFakeAPI.service.JsonUtil;
import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.Header;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.api_url}/login", methodType = HttpMethodType.POST)
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
@Header(key ="Content-Type", value ="application/json" )
@ResponseTemplatePath(path = "api/post/login.json")
public class Login extends AbstractApiMethodV2 {

  public Login(User user) {
    setBodyContent(JsonUtil.toJson(user));
    addProperty("user", user);
    ignorePropertiesProcessor(NotStringValuesProcessor.class);
  }
}
