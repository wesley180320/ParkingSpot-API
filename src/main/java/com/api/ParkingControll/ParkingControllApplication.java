package com.api.ParkingControll;

import com.api.ParkingControll.models.ParkingSpotModel;
import com.api.ParkingControll.repositories.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class ParkingControllApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ParkingControllApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {


	}
}
