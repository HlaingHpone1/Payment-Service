package org.talent.talentpay.service;

import org.talent.talentpay.domain.UserRequest;
import org.talent.talentpay.domain.UserResponse;
import org.talent.talentpay.dto.UserInfo;
import org.talent.talentpay.dto.UserValidateRequest;
import org.talent.talentpay.entity.Users;

import java.util.List;

public interface UserService {

    UserInfo validateUser(UserValidateRequest request);

    UserResponse createAcc(UserRequest request);

    List<Users> findAll();
}
