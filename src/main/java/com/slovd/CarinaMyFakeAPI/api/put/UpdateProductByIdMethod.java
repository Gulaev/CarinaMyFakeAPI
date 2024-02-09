package com.slovd.CarinaMyFakeAPI.api.put;

import com.slovd.CarinaMyFakeAPI.api.model.Product;
import com.slovd.CarinaMyFakeAPI.service.JsonUtil;
import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;


@Endpoint(url = "${config.api_url}/products/${id}", methodType = HttpMethodType.PUT)
@ResponseTemplatePath(path = "api/put/update_product_by_id_rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class UpdateProductByIdMethod extends AbstractApiMethodV2 {

  public UpdateProductByIdMethod(Product product) {
    setBodyContent(JsonUtil.toJson(product));
    addProperty("product", product);
    replaceUrlPlaceholder("id",
        String.valueOf(product.getId()));
    ignorePropertiesProcessor(NotStringValuesProcessor.class);
  }
}
