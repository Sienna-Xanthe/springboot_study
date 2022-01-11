package com.kuang;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot09EmailTestApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {

        //一个简单的邮件
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setSubject("哈哈哈哈");
        mailMessage.setText("java发送邮件测试-简单邮件");

        mailMessage.setTo("3043015301@qq.com");
        mailMessage.setFrom("3043015301@qq.com");

        mailSender.send(mailMessage);
    }

    @Test
    void contextLoads2() throws MessagingException {

        //一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        helper.setSubject("第二次测试");
        helper.setText("<p style='color:red'>哈哈哈哈哈哈哈哈哈哈2</p>",true);

        //附件
        helper.addAttachment("wallhaven-j3lelq_1920x1080.png",new File("C:\\Users\\billkin\\Pictures\\Saved Pictures\\壁纸\\wallhaven-j3lelq_1920x1080.png"));
        helper.addAttachment("1.png",new File("C:\\Users\\billkin\\Pictures\\Saved Pictures\\壁纸\\wallhaven-j3lelq_1920x1080.png"));

        helper.setTo("3043015301@qq.com");
        helper.setFrom("3043015301@qq.com");

        mailSender.send(mimeMessage);

    }

}
