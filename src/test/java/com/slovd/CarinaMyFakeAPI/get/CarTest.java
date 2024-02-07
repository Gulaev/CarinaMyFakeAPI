package com.slovd.CarinaMyFakeAPI.get;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.slovd.CarinaMyFakeAPI.api.get.GetCarById;
import com.slovd.CarinaMyFakeAPI.api.get.GetCarsByName;
import com.slovd.CarinaMyFakeAPI.model.Car;
import com.zebrunner.carina.api.apitools.validation.JsonComparatorContext;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import java.time.Year;
import java.time.format.DateTimeParseException;
import java.util.Map;
import org.testng.annotations.Test;

public class CarTest {


  private static boolean isDateIsValid(Integer date) {
    try {
      Year.of(date);
      return true;

    } catch (DateTimeParseException e) {
      return false;
    }
  }

  @Test
  public void verifyGetCarByCarId() {
    Car car = new Car();
    car.setId(1);
    car.setColor("Yellow");
    car.setName("Mitsubishi");
    car.setModel("Montero");
    Map<String, Object> carMap = convertObjectToMap(car);
    GetCarById getCarById = new GetCarById("1");
    getCarById.addProperty("car", carMap);
    getCarById.expectResponseStatus(HttpResponseStatusType.OK_200);
    getCarById.callAPI();
    JsonComparatorContext comparatorContext = JsonComparatorContext.context()
        .<Integer>withPredicate("datePredicate", date ->
           isDateIsValid(date) && Year.of(date).isAfter(Year.parse("1886"))
        );

    getCarById.validateResponse(comparatorContext);
    getCarById.callAPIExpectSuccess();
    getCarById.callAPIExpectSuccess();
  }

  @Test
  public void verifyCarsByName() {
    Car car = new Car();
    car.setId(1);
    car.setColor("Yellow");
    car.setName("Mitsubishi");
    car.setModel("Montero");
    GetCarsByName getCarsByName = new GetCarsByName(car.getName());
    getCarsByName.callAPI();
    getCarsByName.callAPIExpectSuccess();
  }

  public Map<String, Object> convertObjectToMap(Object obj) {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.convertValue(obj, new TypeReference<Map<String, Object>>() {});
  }

}
