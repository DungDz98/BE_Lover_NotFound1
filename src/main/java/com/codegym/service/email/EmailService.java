package com.codegym.service.email;

import com.codegym.model.entity.User;
import com.codegym.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Optional;

@Service
public class EmailService {
    @Autowired
    JavaMailSender mailSender;

    @Autowired
    IUserService userService;
    public void sendVerificationEmail(User user)
            throws MessagingException {
        String subject = "Register notification";
        String senderName = "admin";
        String mailContent = "<p>Dear " + user.getUserName() + ",</p>";
//        mailContent += "<p> Bạn đã đăng ký thành công </p>";
        mailContent += "<p> Bạn đã đăng ký thành công truy cập link để tiếp tục sử dụng dịch vụ: ";
        mailContent += "<a href ='http://localhost:4200/login'> Click here </a> </p>" ;
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");

        helper.setFrom(senderName);
        helper.setTo(user.getEmail());
        helper.setSubject(subject);
        helper.setText(mailContent, true);
        mailSender.send(message);
    }

}
