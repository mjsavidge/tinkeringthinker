package com.infosys.thecookbook.service;

import com.infosys.thecookbook.email.EmailSender;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ResetPassword {
    private final EmailSender emailSender;

    public void reset(String email){
        String link = "resetpassword.html";
        emailSender.send(email, buildEmail(link));
    }

    private String buildEmail(String link){
        return "<div> <a href=\""+ link + "\"> </div>";
    }
}
