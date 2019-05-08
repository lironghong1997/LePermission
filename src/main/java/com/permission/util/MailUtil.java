package com.permission.util;

import com.permission.beans.Mail;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

@Slf4j
public class MailUtil {

    public static boolean send(Mail mail) {

        // TODO
        // 发送者邮箱
        String from = "itlironghong@foxmail.com";
        // 邮件服务器端口
        int port = 25;
        // 指定发送邮件的主机为 smtp.qq.com
        String host = "smtp.qq.com";
        // 发送者授权码（第三方客户端时用密码会报550 User has no permission这样的错误，需要去授权）
        String pass = "";
        // 昵称
        String nickname = "";

        HtmlEmail email = new HtmlEmail();
        try {
            email.setHostName(host);
            email.setCharset("UTF-8");
            for (String str : mail.getReceivers()) {
                email.addTo(str);
            }
            email.setFrom(from, nickname);
            email.setSmtpPort(port);
            email.setAuthentication(from, pass);
            email.setSubject(mail.getSubject());
            email.setMsg(mail.getMessage());
            email.send();
            log.info("{} 发送邮件到 {}", from, StringUtils.join(mail.getReceivers(), ","));
            return true;
        } catch (EmailException e) {
            log.error(from + "发送邮件到" + StringUtils.join(mail.getReceivers(), ",") + "失败", e);
            return false;
        }
    }

}

