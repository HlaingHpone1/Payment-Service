package org.talent.talentpay.dto;

import lombok.Getter;
import lombok.Setter;
import org.talent.talentpay.entity.Users;

@Getter
@Setter
public class UserInfo {
    private String userName;
    private String secretPhoneNumber;

    public static UserInfo of(Users user){
        UserInfo userInfo = new UserInfo();
        userInfo.userName = user.getUserName();
        userInfo.secretPhoneNumber = "*******" + user.getPhoneNumber().substring(user.getPhoneNumber().length()-4,user.getPhoneNumber().length());

        return userInfo;
    }
}
