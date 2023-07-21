package com.api.ParkingControll.services;

import com.api.ParkingControll.models.EmailModel;
import com.api.ParkingControll.models.StatusEmail;
import com.api.ParkingControll.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    private JavaMailSender emailSender;
    public void sendEmail(EmailModel emailModel){
        emailModel.setSendDateEmail(LocalDate.from(LocalDateTime.now()));
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmailFrom());
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            emailSender.send(message);

            emailModel.setStatusEmail(StatusEmail.ENVIADO);
        } catch (MailException e){
            System.out.println(e.getMessage());
            emailModel.setStatusEmail(StatusEmail.ERRO);
        } finally {
            emailRepository.save(emailModel);
        }
    }
}
