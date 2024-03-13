package org.talent.talentpay.cache;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OTP {
    private String mail;
    private String otp;
    private LocalDateTime expiredTIme;
}
