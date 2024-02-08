package com.slovd.CarinaMyFakeAPI.api.get;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.slovd.CarinaMyFakeAPI.api.model.Car;
import com.zebrunner.carina.api.apitools.validation.JsonComparatorContext;
import java.time.Year;
import java.time.format.DateTimeParseException;
import java.util.Map;
import org.testng.annotations.Test;

public class CarTest {

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
    getCarById.callAPI();

    JsonComparatorContext comparatorContext = JsonComparatorContext.context()
        .<Integer>withPredicate("datePredicate", date -> {
          try {
            return Year.of(date).isAfter(Year.parse("1886"));
          } catch (DateTimeParseException e) {
            return false;
          }
        });
    getCarById.callAPIExpectSuccess();
    getCarById.validateResponse(comparatorContext);
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
    return objectMapper.convertValue(obj, new TypeReference<Map<String, Object>>() {
    });
  }

}
