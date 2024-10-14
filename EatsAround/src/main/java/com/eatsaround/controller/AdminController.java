//package com.eatsaround.controller;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.eatsaround.vo.MemberVO;
//
//public class AdminController {
//	
//	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
//	
//    // メンバー退会処理（論理削除）
//    @PostMapping(value="/member/delete")
//    public String deleteMember(@RequestParam("userId") String userId) throws Exception{
//        logger.info("post member delete");
//        adminService.deleteMember(userId); // 退会処理を実行
//        return "redirect:/admin/memberList"; // 退会後にメンバーリストへリダイレクト
//    }
//    
//    // メンバーリスト
//    @GetMapping(value="/member/list")
//    public void getMemberList(Model model) throws Exception{
//        logger.info("get member list");
//        
//        List<MemberVO> memberList = adminService.memberList(); // メンバーリスト取得
//        model.addAttribute("memberList", memberList);
//    }
//}
