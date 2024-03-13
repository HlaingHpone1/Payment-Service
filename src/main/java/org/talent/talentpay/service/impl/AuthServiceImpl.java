package org.talent.talentpay.service.impl;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.talent.talentpay.cache.OTP;
import org.talent.talentpay.cache.OTPCache;
import org.talent.talentpay.dao.UserDao;
import org.talent.talentpay.domain.OTPValidateRequest;
import org.talent.talentpay.entity.Users;
import org.talent.talentpay.service.AuthService;
import org.talent.talentpay.utility.EmailUtil;
import org.talent.talentpay.constant.EmailConstant;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Properties;
import java.util.Random;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    @Autowired
    private final UserDao userDao;

    @Autowired
    private final EmailUtil emailUtil;


    @Override
    public void verifyMailToRegister(String mail) {
        Optional<Users> users = userDao.findUsersByMail(mail);

        if (users.isPresent()){
            throw new RuntimeException ("User Already exits");
        }else {
            // code Generate
            // send code to mail

            Random random = new Random();

            int r = random.nextInt(100000,1000000);

            System.out.println("Generating Secret Key");
            System.out.println(r);

            send(mail, String.valueOf(r));

            OTP otp = new OTP();
            otp.setMail(mail);
            otp.setOtp(Integer.toString(r));
            otp.setExpiredTIme(LocalDateTime.now().plusMinutes(1));
            OTPCache.saveOTP(otp);
        }
    }

    @Override
    public boolean validateOTP(OTPValidateRequest request) {
        boolean isValidate = false;

        final OTP otp =OTPCache.getOTP(request.getMail());

//        Validate otp correct
//        if(otp.getOtp().equals(request.getOTP())){
////            validate expire Time
//
//            if (LocalDateTime.now().isBefore(otp.getExpiredTIme())){
//                isValidate = true;
//            }
//        }

        if (otp != null){
//        Validate otp correct
            if(otp.getOtp().equals(request.getOTP())){
//            validate expire Time

                if (LocalDateTime.now().isBefore(otp.getExpiredTIme())){
                    isValidate = true;
                }
            }
        }

        return isValidate;
    }

    private void send(String toEmail, String subject){
        final String fromEmail = EmailConstant.senderMail; //requires valid email
        final String password = EmailConstant.senderPassword;

        Properties props = new Properties();
        props.put("mail.smtp.host", EmailConstant.SMTP_HOST); //SMTP Host
        props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        props.put("mail.smtp.port", "465"); //SMTP Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
        props.put("mail.debug", "true");

        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };

        Session session = Session.getInstance(props, auth);
        emailUtil.sendEmail(session, toEmail, subject);
    }

}
