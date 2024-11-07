package com.eatsaround.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.eatsaround.service.ActivityLogService;
import com.eatsaround.service.AdminService;
import com.eatsaround.vo.ActivityLogVO;
import com.eatsaround.vo.MemberVO;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Inject
    private AdminService adminService;

    @Inject
    private ActivityLogService activityLogService;

    // 管理者画面メインページを表示
    @GetMapping(value = "/index")
    public String getIndex(
            @RequestParam(value = "search", required = false) String search,
            @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
            Model model) throws Exception {

        logger.info("Accessing admin index page");
        
        // 管理画面に必要なデータ（メンバー数、ブログ投稿数）を取得
        model.addAttribute("memberCount", adminService.getMemberCount());
        model.addAttribute("blogCount", adminService.getBlogCount());

        // 検索とページネーション処理
        Map<String, Object> params = new HashMap<>();
        params.put("search", (search != null && !search.isEmpty()) ? "%" + search + "%" : null);
        params.put("start", (currentPage - 1) * pageSize);  // ページネーションの開始位置
        params.put("pageSize", pageSize);  // 1ページあたりの表示件数

        // アクティビティ履歴を取得
        List<ActivityLogVO> activityHistory = activityLogService.getActivityHistory(params);
        int totalRecords = activityLogService.getActivityHistoryCount(params); 
        // ページ数の計算
        int totalPages = (int) Math.ceil((double) totalRecords / pageSize);

        // モデルにデータを追加
        model.addAttribute("activityHistory", activityHistory); // アクティビティ履歴リスト
        model.addAttribute("currentPage", currentPage); // 現在のページ番号
        model.addAttribute("totalPages", totalPages); // 総ページ数
        model.addAttribute("search", search); // 検索ワード

     // 管理者画面のインデックスページに移動
        return "admin/index"; 
    }


    // メンバーリストの表示
    @GetMapping(value = "/member/list")
    public String getMemberList(@RequestParam(value = "search", required = false) String search, 
                                @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                @RequestParam(value = "pageSize", defaultValue = "5") int pageSize, 
                                Model model) throws Exception {
        logger.info("Accessing admin member list");

        List<MemberVO> memberList; // メンバーリストを格納
        int memberCount; // メンバー数を格納
        	// 検索がある場合、検索結果を取得
        if (search != null && !search.isEmpty()) {
            memberList = adminService.searchMember(search);
            memberCount = memberList.size();
            logger.info("Searching members with keyword: {}", search);
        } else {
        	// 検索がない場合、ページネーションに対応したメンバーリストを取得
            Map<String, Integer> params = new HashMap<>();
            params.put("start", (currentPage - 1) * pageSize); // ページングの開始位置
            params.put("pageSize", pageSize); // 1ページあたりの件数
            memberList = adminService.getMemberList(params);
            memberCount = adminService.getMemberCount(); // メンバーの総件数
            logger.info("Fetching members for current page: {}", currentPage);
        }
        // モデルにデータを追加
        model.addAttribute("memberList", memberList); // メンバーリスト
        model.addAttribute("currentPage", currentPage); // 現在のページ
        model.addAttribute("pageSize", pageSize); // 1ページあたりの表示件数
        model.addAttribute("search", search); // 検索キーワード
        model.addAttribute("memberCount", memberCount); // メンバー数
        model.addAttribute("blogCount", adminService.getBlogCount()); // ブログ数

        // 総ページ数を計算
        int totalPages = (int) Math.ceil((double) memberCount / pageSize);
        model.addAttribute("totalPages", totalPages);

        // メンバーリストページに移動
        return "admin/member/list";
    }

    // メンバー退会処理（物理削除）
    @PostMapping(value = "/member/delete")
    public String deleteMember(@RequestParam("userId") String userId, RedirectAttributes redirectAttributes) throws Exception {
        logger.info("Attempting to delete member: {}", userId);

        // 管理者アカウントの削除を防止
        if ("admin".equals(userId)) {
            logger.warn("Cannot delete admin user: {}", userId);
            redirectAttributes.addFlashAttribute("alertMessage", "관리자는 삭제 못합니다.");
            return "redirect:/admin/member/list";
        }

        // メンバーの削除処理を実行
        adminService.deleteMember(userId);
        redirectAttributes.addFlashAttribute("successMessage", "회원이 정상적으로 삭제되었습니다.");
        
        // メンバーリストページにリダイレクト
        return "redirect:/admin/member/list";
    }
}



