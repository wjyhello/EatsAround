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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eatsaround.service.AdminService;
import com.eatsaround.vo.MemberVO;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Inject
    private AdminService adminService;

  //管理者画面
    @GetMapping(value="/index")
    public String getIndex(Model model) throws Exception {
        logger.info("get index");
        return "admin/index"; // JSPのパスを指定
    }

    // メンバーリストの表示
    @GetMapping(value = "/member/list")
    public String getMemberList(Model model) throws Exception {
        logger.info("get admin list");

        List<MemberVO> memberList = adminService.memberList(); // メンバーリスト取得
        logger.info("Member list size: {}", memberList.size()); // デバッグログ追加
        model.addAttribute("memberList", memberList);
        
        return "admin/member/list"; // メンバーリストの表示用JSPファイルを指定
    }

    
    // メンバー退会処理（物理削除）
    @PostMapping(value = "/member/delete")
    public String deleteMember(@RequestParam("userId") String userId, RedirectAttributes redirectAttributes) throws Exception {
        logger.info("post admin delete");

        // adminユーザーの削除を防止
        if ("admin".equals(userId)) {
            logger.warn("관리자는 삭제 못합니다: {}", userId);
            redirectAttributes.addFlashAttribute("alertMessage", "관리자는 삭제 못합니다.");
            redirectAttributes.addFlashAttribute("alertAdminMessage", "관리자는 삭제 못합니다.");
            return "redirect:/admin/member/list"; // メンバーリストへリダイレクト
        }

        adminService.deleteMember(userId); // 退会処理を実行
        return "redirect:/admin/member/list"; // 退会後にメンバーリストへリダイレクト
    }


}
