package org.talent.talentpay.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.talent.talentpay.domain.OTPValidateRequest;
import org.talent.talentpay.domain.TalentResponse;
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

    @PostMapping("/validateOTP")
    public ResponseEntity<TalentResponse<Boolean>> validateOTP(@RequestBody OTPValidateRequest request){
        boolean isValidate = authService.validateOTP(request);
        TalentResponse<Boolean> response = new TalentResponse<>(isValidate, "OK", HttpStatus.OK);

        return ResponseEntity.ok(response);
    }
}
