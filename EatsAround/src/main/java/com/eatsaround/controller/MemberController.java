package com.eatsaround.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eatsaround.service.MemberService;
import com.eatsaround.vo.MemberVO;


/**
 * Handles login requests for the application.
 */
@Controller
public class MemberController {
	@Inject
	MemberService service;
	
	@Autowired
	BCryptPasswordEncoder passEncoder;
	
	@Bean //객체 생성을 하지않으면 오류가 생김
	BCryptPasswordEncoder passEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@GetMapping(value="/member/signup")//회원가입
	public void getSignup() throws Exception{
		logger.info("get signup");
	}
	@PostMapping(value="/member/signup")
	public String postSignup(MemberVO vo) throws Exception{
		logger.info("post signup");
		
		String inputPass = vo.getUserPass();
		String pass = passEncoder.encode(inputPass);
		vo.setUserPass(pass);
		
		String inputPass2 = vo.getUserPassRe();
		String pass2 = passEncoder.encode(inputPass2);
		vo.setUserPassRe(pass2);
		
		
		service.signup(vo);		
		return "redirect:/";
	}
	
	//--------------------------------------------------------------------------------------
	
	//1.로그인 get
	@GetMapping(value="/member/signin")
	public void getSignin() throws Exception{
		logger.info("get signin");
	}
	
	//2.로그인 post
	@PostMapping(value="/member/signin")
	public String postSignin(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception{
		
		MemberVO login = service.signin(vo);
		HttpSession session = req.getSession();
		
		boolean passMatch = passEncoder.matches(vo.getUserPass(), login.getUserPass());
		
		if(login != null && passMatch) {
			session.setAttribute("member", login);
		}else {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
			
			return "redirect:/member/signin";
		}
		
		logger.info("post signin");
		return "redirect:/";
	}

}
