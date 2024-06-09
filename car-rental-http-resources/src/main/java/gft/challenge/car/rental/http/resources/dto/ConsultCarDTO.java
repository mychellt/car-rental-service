package gft.challenge.car.rental.http.resources.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConsultCarDTO {
  private String plate;
  private String model;
  private boolean available;

  @JsonAlias(value = "price_per_day")
  private BigDecimal pricePerDay;
}
