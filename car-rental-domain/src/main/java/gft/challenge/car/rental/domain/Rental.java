package gft.challenge.car.rental.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Rental {
  private Car car;
  private LocalDateTime pickupDate;
  private LocalDateTime returnDate;
  private UUID travelReservationId;
  private Status status;

  public void confirm() {
    this.status = Status.CONFIRMED;
  }
}
