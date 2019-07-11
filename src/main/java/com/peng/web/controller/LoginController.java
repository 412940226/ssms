package com.peng.web.controller;

import java.awt.image.BufferedImage;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.Producer;
import com.peng.constant.SessionKey;
import com.peng.dto.rep.SimpleMsgDTO;
import com.peng.dto.rep.UserLoginDTO;
import com.peng.entity.User;
import com.peng.service.UserService;
import com.peng.shiro.ShiroUser;
import com.peng.shiro.UserDTO;
import com.peng.utils.EncryptUtil;


@Controller
public class LoginController {
	private final static Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Resource private Producer captchaProducer;
	
	@Autowired private UserService userService;
	
	@RequestMapping("/")
    public String index() {
		logger.info("=============刚开始");
        if (SecurityUtils.getSubject().getPrincipal()!=null) {
            return "redirect:/index";
        }
        return "login";
    }
	
	@RequestMapping(value="/index")
    public String index(Model model) {
		logger.info("in index naviger");
        return "/index";
    }
	
	@RequestMapping(value = "/main")
	public String main() {
		logger.info("in main");
		return "/main";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
    public String login() {
		logger.info("GET请求登录");
        if (SecurityUtils.getSubject().getPrincipal()!=null) {
            return "redirect:/index";
        }
        return "login";
    }
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public SimpleMsgDTO login(UserDTO userDTO,Model model,
			HttpServletRequest request, HttpServletResponse response){
		logger.info("POST请求登录");
		UserLoginDTO loginDTO=new UserLoginDTO();
		//校验验证码
		String captcha = ShiroUser.getKaptcha(SessionKey.KAPTCHA_SESSION_KEY_LOGIN);
		if (captcha==""&& captcha.length()<0) {
			loginDTO.setCode(0);
			loginDTO.setMsg("验证码不能为空");
			return loginDTO;
		}
		if (!captcha.equalsIgnoreCase(userDTO.getCaptcha())) {
			//request.setAttribute("error", "验证输入错误！");
			loginDTO.setCode(0);
			loginDTO.setMsg("验证输入错误");
		}
		if (!request.getMethod().equals("POST")) {
			//request.setAttribute("error", "支持POST方法提交！");
			loginDTO.setCode(0);
			loginDTO.setMsg("支持POST方法提交！");
			return loginDTO;
		}
		if (StringUtils.isEmpty(userDTO.getUsername()) || 
				StringUtils.isEmpty(userDTO.getPassword())) {
			//request.setAttribute("error", "用户名或密码不能为空！");
			loginDTO.setCode(0);
			loginDTO.setMsg("用户名或密码不能为空！");
			return loginDTO;
		}
		
		Subject subject = ShiroUser.getSubject();
		UsernamePasswordToken token= new UsernamePasswordToken(
				userDTO.getUsername(),EncryptUtil.encodeMD5Str(userDTO.getPassword()));
		try {
			token.setRememberMe(true);
			subject.login(token);
			 // 验证成功在Session中保存用户信息
            //final User authUserInfo = userService.queryUserByName(userDTO.getUsername());
            //System.out.println("验证成功在Session中保存用户信息==>>"+authUserInfo.getUsername());
			//model.addAttribute("authUserInfo", authUserInfo);
			Session session= subject.getSession();
			session.setAttribute("authUserInfo", subject.getPrincipal());
			logger.info("验证成功在Session中保存用户信息==>>"+subject.getPrincipal());
		} catch (AuthenticationException e) {
			e.printStackTrace();
			loginDTO.setCode(0);
			loginDTO.setMsg("error");
			return loginDTO;
		}
		loginDTO.setCode(1);
		loginDTO.setMsg("success");
		return loginDTO;
	}
	@RequestMapping(value="/captcha")
	public void captcha(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setDateHeader("Expires", 0);
		// Set standard HTTP/1.1 no-cache headers.
		response.setHeader("Cache-Control","no-store, no-cache, must-revalidate");
		// Set IE extended HTTP/1.1 no-cache headers (use addHeader).
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		// Set standard HTTP/1.0 no-cache header.
		response.setHeader("Pragma", "no-cache");
		// return a jpeg
		response.setContentType("image/jpeg");

		//生成文字验证码
		String text = captchaProducer.createText();
		logger.info("生成验证码文本==========="+text+"==================");
		//生成图片验证码
		BufferedImage image = captchaProducer.createImage(text);
		//保存到shiro session
		ShiroUser.setSessionAttribute(SessionKey.KAPTCHA_SESSION_KEY_LOGIN, text);
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(image, "jpg", out);
		try {
			out.flush();
		} finally {
			out.close();
		}
	}

	@RequestMapping(value = "/unauthorized", method = RequestMethod.GET)
    public String unauth() {
		//Subject subject = SecurityUtils.getSubject();
		//subject.isAuthenticated() || subject.isRemembered()
        if (SecurityUtils.getSubject().isAuthenticated() == false) {
            return "redirect:login";
        }
        return "unauthorized";
    }

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		ShiroUser.logout(); // session
		logger.info("登出");
		return "redirect:/login";
	}
	
}
