package org.talent.telentpay.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private long balance;
    private long point;
    private  String qrCode;

    private boolean isDisable;
    private boolean isDeleted;

    @OneToOne
    private Users owner;

}
