package org.talent.talentpay.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.talent.talentpay.domain.TalentResponse;
import org.talent.talentpay.domain.UserRequest;
import org.talent.talentpay.domain.UserResponse;
import org.talent.talentpay.dto.UserInfo;
import org.talent.talentpay.dto.UserValidateRequest;
import org.talent.talentpay.entity.Users;
import org.talent.talentpay.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@CrossOrigin
public class UserController {

    @Autowired
    private final UserService userService;

    @PostMapping("/validate")
    public ResponseEntity<UserInfo> validateUser(@RequestBody UserValidateRequest request){

        return ResponseEntity.ok(userService.validateUser(request));
    }

    @GetMapping("")
    public ResponseEntity<TalentResponse<List<Users>>> findAll(){
        List<Users> usersList = userService.findAll();
        TalentResponse<List<Users>> response = new TalentResponse<>(usersList, "OK", HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);

//        return ResponseEntity.ok(response);
    }

    @PostMapping("")
    public ResponseEntity<TalentResponse<UserResponse>> createAcc(@RequestBody UserRequest userRequest){
        UserResponse users = userService.createAcc(userRequest);
        TalentResponse<UserResponse> response = new TalentResponse<>(users,"CREATED", HttpStatus.CREATED);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
