package org.javadev.app.authentication;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

@Controller
public class Authentication {
    private BCryptPasswordEncoder passwordEncoder;

    Authentication(){
        this.passwordEncoder = new BCryptPasswordEncoder();
    }


    public String generateEncodedPassword(String rawPassword){
        return passwordEncoder.encode(rawPassword);
    }

    public boolean passwordsAreMatch(String rawPassword, String encodedPassword){
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
