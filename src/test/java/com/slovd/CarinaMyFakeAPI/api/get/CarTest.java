package com.slovd.CarinaMyFakeAPI.api.get;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.slovd.CarinaMyFakeAPI.api.model.Car;
import com.zebrunner.carina.api.apitools.validation.JsonComparatorContext;
import java.time.Year;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.testng.annotations.Test;

public class CarTest {

  @Test
  public void verifyGetCarByCarIdTest() {
    Car car = new Car();
    car.setId(1);
    car.setColor("Yellow");
    car.setName("Mitsubishi");
    car.setModel("Montero");
    Map<String, Object> carMap = convertObjectToMap(car);
    GetCarById getCarById = new GetCarById("1");
    getCarById.addProperty("car", carMap);
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
  public void verifyGetCarsByNameTest() {
    Car car = new Car();
    car.setId(1);
    car.setColor("Yellow");
    car.setName("Mitsubishi");
    car.setModel("Montero");
    GetCarsByName getCarsByName = new GetCarsByName(car.getName());
    getCarsByName.callAPIExpectSuccess();
    List<Car> cars = new ArrayList<>();
    if(cars.isEmpty()) {
      for (int i = 0; i < 37; i++) {
        cars.add(new Car());
      }
    }
    getCarsByName.addProperty("cars", cars);
    getCarsByName.validateResponse();
  }

  private Map<String, Object> convertObjectToMap(Object obj) {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.convertValue(obj, new TypeReference<Map<String, Object>>() {
    });
  }
}
