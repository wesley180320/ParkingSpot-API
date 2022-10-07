package com.api.ParkingControll;

import com.api.ParkingControll.controller.ParkingSpotController;
import com.api.ParkingControll.models.ParkingSpotModel;
import com.api.ParkingControll.repositories.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@SpringBootApplication
public class ParkingControllApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ParkingControllApplication.class, args);
	}


	//@Autowired
	//private ParkingSpotRepository parkingSpotRepository;

	@Override
	public void run(String... args) throws Exception {

		//LocalDate l1 = LocalDate.from(LocalDateTime.now());


		//ParkingSpotModel pk = new ParkingSpotModel(null, "25", "789045","audi","a5","black",l1,"wesley","129","5");


		//parkingSpotRepository.save(pk);
	}
}
