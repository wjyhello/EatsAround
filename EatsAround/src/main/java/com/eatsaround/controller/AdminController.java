package com.eatsaround.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eatsaround.service.AdminService;
import com.eatsaround.vo.MemberVO;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Inject
    private AdminService adminService;

	//관리자 화면
	@GetMapping(value="/index")
	public void getIndex() throws Exception{
		logger.info("get index");
	}
    
    // メンバー退会処理（物理削除）
    @PostMapping(value = "/admin/delete")
    public String deleteMember(@RequestParam("userId") String userId) throws Exception {
        logger.info("post admin delete");
        adminService.deleteMember(userId); // 退会処理を実行
        return "redirect:/admin/list"; // 退会後にメンバーリストへリダイレクト
    }

    // メンバーリストの表示
    @GetMapping(value = "/admin/list")
    public String getMemberList(Model model) throws Exception {
        logger.info("get admin list");

        List<MemberVO> memberList = adminService.memberList(); // メンバーリスト取得
        model.addAttribute("memberList", memberList);
        
        return "admin/memberList"; // メンバーリストの表示用JSPまたはHTMLテンプレート
    }
}
