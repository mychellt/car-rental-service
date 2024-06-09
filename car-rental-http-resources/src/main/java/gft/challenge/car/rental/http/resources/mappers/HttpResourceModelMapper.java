package gft.challenge.car.rental.http.resources.mappers;

import gft.challenge.car.rental.domain.Car;
import gft.challenge.car.rental.http.resources.dto.ConsultCarDTO;
import gft.challenge.car.rental.http.resources.dto.CreateCarDTO;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface HttpResourceModelMapper {
  ConsultCarDTO from(final Car source);
  Car from(final CreateCarDTO source);
}
