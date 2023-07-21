package com.api.ParkingControll.controller;


import com.api.ParkingControll.dtos.ParkingSpotDto;
import com.api.ParkingControll.models.ParkingSpotModel;
import com.api.ParkingControll.services.ParkingSpotServices;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController {


    final ParkingSpotServices parkingSportServices;

    public ParkingSpotController(ParkingSpotServices parkingSportServices) {
        this.parkingSportServices = parkingSportServices;
    }

    @PostMapping
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto){

        ParkingSpotModel parkingSpotModel = new ParkingSpotModel();
        BeanUtils.copyProperties(parkingSpotDto,parkingSpotModel);
        parkingSpotModel.setRegistrationDate(LocalDate.from(LocalDateTime.now(ZoneId.of("UTC"))));

        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSportServices.save(parkingSpotModel));

    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Object> findByID(@PathVariable UUID id){

        Optional<ParkingSpotModel> parkingSpotModel = parkingSportServices.findByID(id);

        // Verificando se o ID existe
        if (!parkingSpotModel.isPresent()){

          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found");
        }

        return ResponseEntity.ok().body(parkingSpotModel);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deletById(@PathVariable UUID id){

        Optional<ParkingSpotModel> parkingSpotModel = parkingSportServices.findByID(id);

        // Verificando se o ID existe
        if (!parkingSpotModel.isPresent()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found");
        }

        parkingSportServices.delete(id);

        return ResponseEntity.ok().body("Id deleted successfully." + id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    ResponseEntity<Object> update(@PathVariable UUID id, @RequestBody @Valid ParkingSpotDto parkingSpotDto){

        Optional<ParkingSpotModel> parkingSpotModel = parkingSportServices.findByID(id);

        // Verificando se o ID existe
        if (!parkingSpotModel.isPresent()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found");
        }

        ParkingSpotModel parkingSpotModel1 = parkingSpotModel.get();
        parkingSpotModel1.setParkingSpotnumber(parkingSpotDto.getParkingSpotnumber());
        parkingSpotModel1.setLicenseplatecar(parkingSpotDto.getLicenseplatecar());
        parkingSpotModel1.setModelCar(parkingSpotDto.getModelCar());
        parkingSpotModel1.setBrandCar(parkingSpotDto.getBrandCar());
        parkingSpotModel1.setColorCar(parkingSpotDto.getColorCar());
        parkingSpotModel1.setResponsibleName(parkingSpotDto.getResponsibleName());
        parkingSpotModel1.setApartment(parkingSpotDto.getApartment());
        parkingSpotModel1.setBlock(parkingSpotDto.getBlock());

        return ResponseEntity.ok().body(parkingSportServices.save(parkingSpotModel1));
    }

    @GetMapping
    public ResponseEntity<Page<ParkingSpotModel>> getOneParkingSpot(@PageableDefault(page = 0,size = 10, sort = "id", direction = Sort.Direction.ASC)Pageable pageable){

        return ResponseEntity.ok().body(parkingSportServices.findAll(pageable));
    }

}
