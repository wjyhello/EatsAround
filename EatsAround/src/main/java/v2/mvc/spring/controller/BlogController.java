package v2.mvc.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eatsaround.service.ReplyService;
import com.eatsaround.vo.ReplyVO;

import v2.mvc.spring.service.BlogService;
import v2.mvc.spring.vo.BlogEditRequestVO;
import v2.mvc.spring.vo.BlogListRequestVO;
import v2.mvc.spring.vo.BlogListResponseVO;




/**
 * Handles requests for the application home page.
 */
@Controller
public class BlogController {
	
	@Inject
	BlogService blogService;
	
	@Inject
	ReplyService replyService;
	
	private static final Logger logger = LoggerFactory.getLogger(BlogController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/ref", method = RequestMethod.GET)
	public String getRef() {
		return "ref/home";
	}
	
	@RequestMapping(value = "/shop", method = RequestMethod.GET)
	public String getShop() {
		return "shop/mall";
	}

	
	@GetMapping(value = "/create")
	public String getCreate(HttpServletRequest req) {
		
		return "blog/create";
	}
	
//	@PostMapping(value="/create")
//	public String postCreate(@RequestParam Map<String, Object> map) {
//		int blogContSeq = this.blogService.create(map);
//		return "redirect:/read/" + String.valueOf(blogContSeq);
//		
//	}
//	
	
	@PostMapping(value = "/create")
	public String postCreate(HttpServletRequest req, @RequestParam Map<String, Object> map) {
	    HttpSession session = req.getSession();
	    String userId = (String) session.getAttribute("id"); // 세션에서 userId 가져오기
	    
	    if (userId == null) {
	        throw new IllegalArgumentException("로그인이 필요합니다."); // 로그인이 필요할 경우 예외 처리
	    }
	    map.put("userId", userId); // Map에 userId 추가
	    int blogContSeq = this.blogService.create(map); // 서비스 호출
	    return "redirect:/read/" + String.valueOf(blogContSeq);
	}
	 
	
	@GetMapping(value="/read/{blogContSeq}")// => /read/1
	public String getRead(@PathVariable("blogContSeq") int blogContSeq, Model model) throws Exception {
		Map<String, Object> blogCont = this.blogService.read(blogContSeq);
		model.addAttribute("blogCont", blogCont);
		logger.info("게시판 조회");
		// 댓글 조회
		List<ReplyVO> reply = null;
		reply = replyService.list(blogContSeq);
		model.addAttribute("reply",reply);
		
		logger.info("리턴할 댓글 데이터: {}", reply);

		return "blog/read";
	}
	
	@GetMapping(value="/edit/{blogContSeq}")
	public ModelAndView getEdit(@PathVariable("blogContSeq") int blogContSeq) {
		ModelAndView mav = new ModelAndView("/blog/edit");
		Map<String, Object> blogCont = this.blogService.read(blogContSeq);
		
		if(blogCont == null) {
			mav.setViewName("redirect:/list");
			return mav;
		}
		
		mav.addObject("blogCont", blogCont);
		return mav;
	}
	
	@PutMapping(value = "/edit/{blogContSeq}")
	   public String putEdit(BlogEditRequestVO blogEditRequestVO) {
	       boolean isSuccessEdit = this.blogService.edit(blogEditRequestVO);
	    
	       if (!isSuccessEdit) {
	           return "redirect:/edit/" + String.valueOf(blogEditRequestVO.getBlogContSeq());
	       }
	    
	       return "redirect:/list";
	   }

	   @DeleteMapping(value = "/delete")
	   public String delete(int blogContSeq) {
	       this.blogService.delete(blogContSeq);
	       return "redirect:/list";
	   }
	   
	   //목록
	   @GetMapping(value = "/list")
	   public String list(BlogListRequestVO blogListRequestVO, Model model) {
	      model.addAttribute("blogListRequestVO", blogListRequestVO);
	      
	      List<BlogListResponseVO> blogListResponseVOList = this.blogService.list(blogListRequestVO);
	      model.addAttribute("blogListResponseVOList",blogListResponseVOList);
	      return "/blog/list";
	   }
	

	
	
	
	
	
	
	
	
	
}
