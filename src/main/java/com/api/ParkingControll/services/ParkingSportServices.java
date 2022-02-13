package com.api.ParkingControll.services;

import com.api.ParkingControll.models.ParkingSpotModel;
import com.api.ParkingControll.repositories.ParkingSportRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingSportServices {

   final ParkingSportRepository parkingsportrepository;

    public ParkingSportServices(ParkingSportRepository parkingsportrepository) {
        this.parkingsportrepository = parkingsportrepository;
    }

    @Transactional
    public Optional<ParkingSpotModel> findByID(UUID id){

        return parkingsportrepository.findById(id);
    }

    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel){

        return parkingsportrepository.save(parkingSpotModel);
    }


    @Transactional
    public Page<ParkingSpotModel> findAll(Pageable pageable){

        return parkingsportrepository.findAll(pageable);

    }

    @Transactional
    public void delet(UUID id){

        parkingsportrepository.deleteById(id);
    }

}
