package org.talent.talentpay.service;

import org.talent.talentpay.dto.UserInfo;
import org.talent.talentpay.dto.UserValidateRequest;

public interface UserService {

    UserInfo validateUser(UserValidateRequest request);
}
