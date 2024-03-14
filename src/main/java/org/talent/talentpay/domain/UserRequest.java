package org.talent.talentpay.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserRequest {
    private String firstName;
    private String lastName;
    private String userName;
    private String phoneNumber;
    private String mail;
    private String address;
    private String nrc;
    private String profileImage;
    private LocalDate dob;
}
