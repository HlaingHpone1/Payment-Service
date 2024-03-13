package org.talent.talentpay.service;

import org.talent.talentpay.domain.OTPValidateRequest;

public interface AuthService {
    void verifyMailToRegister(String mail);

    boolean validateOTP(OTPValidateRequest request);
}
