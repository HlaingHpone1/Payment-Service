package org.talent.talentpay.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.talent.talentpay.dao.UserDao;
import org.talent.talentpay.dto.UserInfo;
import org.talent.talentpay.dto.UserValidateRequest;
import org.talent.talentpay.entity.Users;
import org.talent.talentpay.service.UserService;

@Service
@AllArgsConstructor

public class UserServiceImpl implements UserService {

    @Autowired
    private final UserDao userDao;

    @Override
    public UserInfo validateUser(UserValidateRequest request) {
       final Users users = userDao.findUsersByPhoneNumber(request.getPhoneNumber()).orElse(null);

       if(users == null){
           System.out.println("There have no user in our system");
       }

       return UserInfo.of(users);
    }
}
