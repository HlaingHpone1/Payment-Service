package org.talent.talentpay.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.talent.talentpay.dto.UserInfo;
import org.talent.talentpay.dto.UserValidateRequest;
import org.talent.talentpay.service.UserService;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @PostMapping("/validate")
    public ResponseEntity<UserInfo> validateUser(@RequestBody UserValidateRequest request){

        return ResponseEntity.ok(userService.validateUser(request));
    }

}
