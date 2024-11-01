package com.eatsaround.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eatsaround.service.ReplyService;
import com.eatsaround.vo.ReplyVO;

@Controller
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    // 댓글 작성
    @PostMapping("/write")
    public String write(@RequestParam("blogContSeq") int blgContSeq, ReplyVO vo) throws Exception {
        vo.setBlgContSeq(blgContSeq);  // `ReplyVO`에 `blgContSeq` 설정
        replyService.write(vo);        // 댓글 작성
        return "redirect:/read/" + blgContSeq; // 작성 후 리다이렉트
    }

    // 댓글 목록 조회
    @GetMapping("/list")
    @ResponseBody
    public List<ReplyVO> list(@RequestParam("blogContSeq") int blgContSeq,Model model) throws Exception {
    	model.addAttribute("reply", replyService.list(blgContSeq));
        return replyService.list(blgContSeq); // 해당 게시글의 댓글 목록 반환
    }
}
