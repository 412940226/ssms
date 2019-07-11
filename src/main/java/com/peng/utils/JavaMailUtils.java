package com.peng.utils;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class JavaMailUtils {
	/**
	 * 发送单人邮件
	 * @param toAddress
	 * @param fromAddress
	 * @param hostAddress
	 * @param subject
	 * @param messageText
	 * @param fileRealPath
	 */
	public static void sendEmail(String toAddress,String fromAddress,
			String hostAddress,String subject,String messageText,String fileRealPath) {
		String to = toAddress;
		String from = fromAddress;
		String host = hostAddress;
		Properties properties=System.getProperties();
		properties.setProperty("mail.smtp.host", host);
//		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.auth", null);
		MyAuthenticator authenticator=new MyAuthenticator(
				properties.getProperty("spring.mail.username"), 
				properties.getProperty("spring.mail.password"));
		Session session=Session.getDefaultInstance(properties, authenticator);
		try {
			// 创建默认的 MimeMessage 对象
			MimeMessage message = new MimeMessage(session);
			// Set From: 头部头字段
			message.setFrom(new InternetAddress(from));
			// Set To: 头部头字段
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			// Set Subject: 头部头字段
			message.setSubject(subject);
			// ------------------------------------------------------------------------------------------
			// 创建消息部分
			BodyPart messageBodyPart = new MimeBodyPart();
			// 消息
			messageBodyPart.setText(messageText);
			// 创建多重消息
			Multipart multipart = new MimeMultipart();
			// 设置文本消息部分
			multipart.addBodyPart(messageBodyPart);
			// 附件部分
			messageBodyPart = new MimeBodyPart();
			String filename = fileRealPath;// 获取附件物理路径
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);
			// 发送完整消息
			message.setContent(multipart);
			// ------------------------------------------------------------------------------------------
			// 发送消息
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 发送多人邮件
	 * @param toAddress
	 * @param fromAddress
	 * @param hostAddress
	 * @param subject
	 * @param messageText
	 * @param fileRealPath
	 */
	public static void sendEmailToMany(String[] toAddress,String fromAddress,
			String hostAddress,String subject,String messageText,String fileRealPath) {
		try {
			// 收件人电子邮箱【可以有多个收件人】
			InternetAddress[] sendTo = new InternetAddress[toAddress.length];
			for (int i = 0; i < toAddress.length; i++) {
				System.out.println("发送到:" + toAddress[i]);
				sendTo[i] = new InternetAddress(toAddress[i]);
			}
			String from = fromAddress;
			String host = hostAddress;
			Properties properties=System.getProperties();
			properties.setProperty("mail.smtp.host", host);
			properties.setProperty("mail.smtp.auth", "true");
			MyAuthenticator authenticator=new MyAuthenticator(
					properties.getProperty("spring.mail.username"), 
					properties.getProperty("spring.mail.password"));
			Session session=Session.getDefaultInstance(properties, authenticator);
		
			// 创建默认的 MimeMessage 对象
			MimeMessage message = new MimeMessage(session);
			// Set From: 头部头字段
			message.setFrom(new InternetAddress(from));
			// Set To: 头部头字段
			message.addRecipients(Message.RecipientType.TO, sendTo);
			// Set Subject: 头部头字段
			message.setSubject(subject);
			// ------------------------------------------------------------------------------------------
			// 创建消息部分
			BodyPart messageBodyPart = new MimeBodyPart();
			// 消息
			messageBodyPart.setText(messageText);
			// 创建多重消息
			Multipart multipart = new MimeMultipart();
			// 设置文本消息部分
			multipart.addBodyPart(messageBodyPart);
			// 附件部分
			messageBodyPart = new MimeBodyPart();
			String filename = fileRealPath;// 获取附件物理路径
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);
			// 发送完整消息
			message.setContent(multipart);
			// ------------------------------------------------------------------------------------------
			// 发送消息
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// 收件人邮箱
		String toAddress = "pcq520520@sina.com";
		// 发件人邮箱
		String fromAddress = "412940226@qq.com";
		// 邮件服务器类型（这里为qq，如果要用163则为“smtp.163.com”）
		String hostAddress = "smtp.qq.com";
		// 邮件的主题
		String subject = "测试邮件——JAVA";
		// 邮件的正文
		String messageText = "Hello World！！！";

		// 获取文件绝对路径
		String projectPath = System.getProperty("user.dir");
		String fileRealPath = projectPath.replace("\\", "/") + "/file.txt";

		// 发送邮件
		JavaMailUtils.sendEmail(toAddress, fromAddress, hostAddress, subject, messageText, fileRealPath);
		
		// 收件人邮箱【多个收件人】
//		String[] toAddress = new String[] { "1115366817@qq.com", "1017831141@qq.com", "2803296210@qq.com" };
//		// 发件人邮箱
//		String fromAddress = "你的邮箱地址";
//		// 邮件服务器类型（这里为qq，如果要用163则为“smtp.163.com”）
//		String hostAddress = "smtp.qq.com";
//		// 邮件的主题
//		String subject = "测试邮件——JAVA";
//		// 邮件的正文
//		String messageText = "Hello World阿斯蒂芬";
//		
//		// 获取文件绝对路径
//		String projectPath = System.getProperty("user.dir");
//		String fileRealPath = projectPath.replace("\\", "/") + "/file.txt";
//
//		// 发送邮件
//		JavaMailUtils.sendEmailToMany(toAddress, fromAddress, hostAddress, subject, messageText, fileRealPath);

	}
}
