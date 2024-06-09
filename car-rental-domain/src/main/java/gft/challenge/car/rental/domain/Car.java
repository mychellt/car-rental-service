package gft.challenge.car.rental.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Car {
  private String plate;
  private String model;
  private boolean available;
  private BigDecimal pricePerDay;
}
