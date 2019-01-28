package com.sakura.ofm.tools;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * @author y14
 * @date 2018-02-19
 * 邮件服务
 */
@Component
public class EMailHelper {
    private  final Logger logger = LoggerFactory.getLogger(EMailHelper.class);
    /**
     *
     * @param title 邮件标题
     * @param mailContent 邮件内容 可以支持html内容
     * @param sendDate 邮件发送时间
     * @param recipientAddressList 收件人地址（数组）
     * @throws Exception
     */
    public boolean sendMail(String title,String mailContent,Date sendDate,String... recipientAddressList) {
        try{
            Session session = this.createSession();
            //创建一封邮件的实例对象
            MimeMessage msg = new MimeMessage(session);
            //设置发件人地址
            msg.setFrom(new InternetAddress(PropertiesHelper.getParam("mail.sender.address")));
            /**
             * 设置收件人地址（可以增加多个收件人、抄送、密送），即下面这一行代码书写多行
             * MimeMessage.RecipientType.TO:发送
             * MimeMessage.RecipientType.CC：抄送
             * MimeMessage.RecipientType.BCC：密送
             */
            for (String recipientAddress: recipientAddressList) {
                msg.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(recipientAddress));
            }
            //设置邮件主题
            msg.setSubject(title,"UTF-8");
            //设置邮件正文
            msg.setContent(mailContent, "text/html;charset=UTF-8");
            //设置邮件的发送时间,默认立即发送
            msg.setSentDate(sendDate);
            //根据session对象获取邮件传输对象Transport
            Transport transport = session.getTransport();
            //设置发件人的账户名和密码
            transport.connect(PropertiesHelper.getParam("mail.sender.address")
                    , PropertiesHelper.getParam("mail.sender.secret"));
            //发送邮件，并发送到所有收件人地址，message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
            transport.sendMessage(msg,msg.getAllRecipients());
            //关闭连接
            transport.close();
            return true;
        }catch (AddressException e){
            logger.error("发送邮件时异常",e);
            return false;
        }catch (MessagingException e){
            logger.error("发送邮件时异常",e);
            return false;
        }
    }

    private Session createSession(){
        Properties properties = new Properties();
        //设置用户的认证方式
        properties.setProperty("mail.smtp.auth", "true");
        //设置传输协议
        properties.setProperty("mail.transport.protocol","smtp");
        //设置发件人的SMTP服务器地址
        properties.setProperty("mail.smtp.host", PropertiesHelper.getParam("mail.sender.service"));
        //2、创建定义整个应用程序所需的环境信息的 Session 对象
        Session session = Session.getInstance(properties);
        //设置调试信息在控制台打印出来
        session.setDebug(true);
        return session;
    }


}
