package org.talent.talentpay.utility;

import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.talent.talentpay.constant.EmailConstant;

@Configuration
@AllArgsConstructor
public class EmailUtil {

    /**
     * Utility method to send simple HTML email
     * @param session
     * @param toEmail
     * @param subject
     */
    public void sendEmail(Session session, String toEmail, String subject){
        try
        {
            MimeMessage msg = new MimeMessage(session);

            MimeMessageHelper helper = new MimeMessageHelper(msg, "UTF-8");
            helper.setFrom(EmailConstant.senderMail);
            helper.setTo(toEmail);
            msg.setText("Your One Time Password is " + subject);
            helper.setSubject(subject);

            Transport.send(msg);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}