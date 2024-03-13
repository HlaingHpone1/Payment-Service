package org.talent.talentpay.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.talent.talentpay.service.AuthService;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@CrossOrigin
public class AuthController {

    @Autowired
    private final AuthService authService;

    @GetMapping("/verify")
    public void verifyEmail(@RequestParam String mail){
        authService.verifyMailToRegister(mail);
//        System.out.println("Verfifying mail " + mail);
    }
}
