package com.example.clientsservice.services.mail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MailingServiceImplementTest {
    @Autowired
    private MailingServiceImplement mailingServiceImpl;

    @Test
    void sendAccountInfo() {
        mailingServiceImpl.sendAccountInfo("cherryhoddieboi1337@gmail.com", "Are you using this email for this project nobody knows and never will???");
    }
}