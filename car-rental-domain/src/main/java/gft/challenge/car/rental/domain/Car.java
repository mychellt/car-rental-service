package gft.challenge.car.rental.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Car {
  private UUID id;
  private String plate;
  private String model;
  private boolean available;
  private BigDecimal pricePerDay;
}
