package gft.challenge.car.rental.persistence.mappers;

import gft.challenge.car.rental.domain.Car;
import gft.challenge.car.rental.persistence.model.CarEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface PersistenceEntityMapper {
  Car from(final CarEntity source);
  CarEntity from(final Car source);
}
