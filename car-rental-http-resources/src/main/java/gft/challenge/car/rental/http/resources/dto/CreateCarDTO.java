package gft.challenge.car.rental.http.resources.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateCarDTO {
  private String plate;
  private String model;

  @JsonAlias(value = "price_per_day")
  private BigDecimal pricePerDay;
}
