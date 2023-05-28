package com.arthycode.obspringsecuritycifrado;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

public class EncryptionTest {

    /**
     * BCrypt genera su propio salt de 16 bits
     * El resultado de cifrar con bcrypt será un String de 60 caracteres:
     * $a version
     * $10 fuerza (valor de 4 a 31, por defecto vale 10)
     * Los 22 siguientes caracteres son el salt generado
     */
    @Test
    void bcryptTest() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String psw = passwordEncoder.encode("admin");
        System.out.println(psw);
        System.out.println(passwordEncoder.matches("admin", psw));
    }

    @Test
    void bcryptCheckMultiplePasswords() {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        for (int i = 0; i < 30; i++) {
            System.out.println(passwordEncoder.encode("admin"));
        }
    }

    @Test
    void pbkdf2() {

        Pbkdf2PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder("", 8, 185000, 256);
        for (int i = 0; i < 30; i++) {
            System.out.println(passwordEncoder.encode("admin"));
        }
    }
    @Test
    void argon() {

        Argon2PasswordEncoder passwordEncoder = new Argon2PasswordEncoder(16, 32, 1, 4096, 3);
        for (int i = 0; i < 30; i++) {
            System.out.println(passwordEncoder.encode("admin"));
        }
    }

    @Test
    void scrypt() {
        SCryptPasswordEncoder passwordEncoder = new SCryptPasswordEncoder(16384, 8, 1, 32, 64);
        for (int i = 0; i < 30; i++) {
            System.out.println(passwordEncoder.encode("admin"));
        }
    }

    @Test
    void springPasswordEncoders() {
        String idForEncode = "bcrypt";
        Map<String, PasswordEncoder> passwordEncoderMap = new HashMap<>();
        passwordEncoderMap.put("bcrypt", new BCryptPasswordEncoder());
        passwordEncoderMap.put("pbkdf2", new Pbkdf2PasswordEncoder("", 8, 185000, 256));
        passwordEncoderMap.put("argon2", new Argon2PasswordEncoder(16, 32, 1, 4096, 3));

        PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("bcrypt", passwordEncoderMap);

        String hashedPassword = passwordEncoder.encode("admin");
        System.out.println(hashedPassword);
    }
}
