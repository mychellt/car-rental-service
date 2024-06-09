package gft.challenge.car.rental.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Rental {
  private Car car;
  private Customer customer;
  private LocalDateTime checkInDate;
  private LocalDateTime checkOutDate;
  private Integer numberOfDays;
}
