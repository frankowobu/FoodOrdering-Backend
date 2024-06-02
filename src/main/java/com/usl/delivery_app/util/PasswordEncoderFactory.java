package com.usl.delivery_app.util;

import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderFactory {
    PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        passwordEncoder = new BCryptPasswordEncoder(11);
    }
    public PasswordEncoder passwordEncoder() {
        return passwordEncoder;
    }
}
