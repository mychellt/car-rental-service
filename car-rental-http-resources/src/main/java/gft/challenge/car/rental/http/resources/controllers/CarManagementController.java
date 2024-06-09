package gft.challenge.car.rental.http.resources.controllers;

import gft.challenge.car.rental.core.business.ConsultCarPort;
import gft.challenge.car.rental.core.business.CreateCarPort;
import gft.challenge.car.rental.core.business.ListCarsPort;
import gft.challenge.car.rental.core.command.Context;
import gft.challenge.car.rental.http.resources.dto.ConsultCarDTO;
import gft.challenge.car.rental.http.resources.dto.CreateCarDTO;
import gft.challenge.car.rental.http.resources.mappers.HttpResourceModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/car")
public class CarManagementController {
  private final HttpResourceModelMapper mapper;
  private final ListCarsPort listCarsPort;

  private final ConsultCarPort consultCarPort;

  private final CreateCarPort createCarPort;

  @Autowired
  public CarManagementController(final HttpResourceModelMapper mapper,
                                 final ListCarsPort listCarsPort,
                                 final ConsultCarPort consultCarPort,
                                 final CreateCarPort createCarPort) {
    this.mapper = mapper;
    this.listCarsPort = listCarsPort;
    this.consultCarPort = consultCarPort;
    this.createCarPort = createCarPort;
  }

  @GetMapping(value = "{id}")
  public ResponseEntity<ConsultCarDTO> get(@PathVariable(value = "id") final UUID id) {
    final Context context = new Context();
    context.setData(id);

    final ConsultCarDTO response = consultCarPort.process(context).map(mapper::from).orElse(null);
    return Objects.nonNull(response) ?
        ResponseEntity.ok().body(response) :
        ResponseEntity.notFound().build();
  }

  @GetMapping(value = "/all")
  public ResponseEntity<List<ConsultCarDTO>> getAll() {
    final List<ConsultCarDTO> response = listCarsPort.process(new Context())
        .stream()
        .map(mapper::from)
        .toList();
    return ResponseEntity.ok().body(response);
  }

  @PostMapping
  public ResponseEntity<Void> create(@RequestBody final CreateCarDTO body) {
    final Context context = new Context();
    context.setData(mapper.from(body));

    createCarPort.process(context);
    return ResponseEntity.ok().build();
  }
}
