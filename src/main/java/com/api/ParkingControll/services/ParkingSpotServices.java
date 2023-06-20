package com.api.ParkingControll.services;

import com.api.ParkingControll.models.ParkingSpotModel;
import com.api.ParkingControll.repositories.ParkingSpotRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingSpotServices {

   final ParkingSpotRepository parkingsportrepository;

    public ParkingSpotServices(ParkingSpotRepository parkingsportrepository) {
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
    public void delete(UUID id){
        parkingsportrepository.deleteById(id);
    }

}
