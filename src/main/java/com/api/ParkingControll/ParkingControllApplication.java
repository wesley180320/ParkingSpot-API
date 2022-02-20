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

	@Autowired
	private ParkingSpotRepository parkingSpotRepository;

	@Override
	public void run(String... args) throws Exception {


		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		ParkingSpotModel parkingSpotModel = new ParkingSpotModel(null,"10","123w45","Audi","q5","preto",null,"Wesley","125","A");
		ParkingSpotModel parkingSpotModel2 = new ParkingSpotModel(null,"12","124w47","Audi","q6","branco",null,"joao","135","B");


		parkingSpotRepository.saveAll(Arrays.asList(parkingSpotModel,parkingSpotModel2));
	}
}
