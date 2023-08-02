package com.example.finalproject.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
@Service
@Slf4j
@RequiredArgsConstructor
public class EmailService {
    private final ThreadLocal<JavaMailSender> javaMailSender = new ThreadLocal<JavaMailSender>();
    private final JavaMailSender mailSender;
//
//    @Scheduled(fixedRate = 600000)
    public void mailSender() throws MessagingException, IOException {
        sendEmail();
//        sendEmailWithAttachment();
        log.info("Email sent successfully!");
    }
    void sendEmail() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("fuad.jabrayilovv@gmail.com");
        msg.setFrom("fuad.vidadi12@gmail.com");
        msg.setSubject("Testing from Spring Boot");
        msg.setText(" \n Spring Boot Email");

        mailSender.send(msg);
    }
    void sendEmailWithAttachment() throws MessagingException, IOException {
        MimeMessage msg = javaMailSender.get().createMimeMessage();
        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo("fuad.jabrayilovv@gmail.com");
        helper.setFrom("fuad.jabrayilovv@gmail.com");
        helper.setSubject("Testing from Spring Boot");
        // default = text/plain
        //helper.setText("Check attachment for image!");
        // true = text/html
        helper.setText("<h1>Check attachment for image!</h1>", true);
        //FileSystemResource file = new FileSystemResource(new File("classpath:android.png"));

        //Resource resource = new ClassPathResource("android.png");
        //InputStream input = resource.getInputStream();

        //ResourceUtils.getFile("classpath:android.png");

        helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));

        javaMailSender.get().send(msg);
    }
}

