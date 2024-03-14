package org.talent.talentpay.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.apache.catalina.User;
import org.talent.talentpay.domain.UserRequest;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String firstName;
    private String lastName;
    private String userName;
    private String phoneNumber;
    private String mail;
    private String address;
    private String nrc;
    private String profileImage;
    private LocalDate dob;

    private boolean isDeleted;

    public static Users of(UserRequest request){
        Users users = new UsersBuilder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .userName(request.getUserName())
                .phoneNumber(request.getPhoneNumber())
                .mail(request.getMail())
                .address(request.getAddress())
                .nrc(request.getNrc())
                .dob(request.getDob())
                .build();

        return users;
    }

}
