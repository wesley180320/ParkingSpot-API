package com.api.ParkingControll;

import com.api.ParkingControll.controller.ParkingSpotController;
import com.api.ParkingControll.models.EmailModel;
import com.api.ParkingControll.models.ParkingSpotModel;
import com.api.ParkingControll.models.StatusEmail;
import com.api.ParkingControll.models.UserModel;
import com.api.ParkingControll.repositories.ParkingSpotRepository;
import com.api.ParkingControll.repositories.UserModelRepository;
import com.api.ParkingControll.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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


		@Autowired
		private UserModelRepository userModelRepository;

	@Autowired
	private EmailService emailService;

	@Override
	public void run(String... args) throws Exception {

		//LocalDate l1 = LocalDate.from(LocalDateTime.now());
		//ParkingSpotModel pk = new ParkingSpotModel(null, "25", "789045","audi","a5","black",l1,"wesley","129","5");
		//parkingSpotRepository.save(pk);
//				PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//				UserModel userModel = new UserModel("wesley2", passwordEncoder.encode("180320"), "estevaoowesley@gmail.com");
//				userModelRepository.save(userModel);
//
//			EmailModel emailModel = new EmailModel(null, "Wesley", "estevaoowesley@gmail.com", "joao15@gmail.com", "gay", "gay", LocalDate.now(), StatusEmail.ENVIADO);
//			emailService.sendEmail(emailModel);
//		}
	}
}
