package gft.challenge.car.rental.persistence.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "rentals")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RentalEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(columnDefinition = "UUID")
  private UUID id;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "car_id")
  private CarEntity car;

  @Column(name = "pickup_date")
  private LocalDateTime pickupDate;

  @Column(name = "return_date")
  private LocalDateTime returnDate;

  @Column(name = "travel_reservation_id")
  private UUID travelReservationId;
}
