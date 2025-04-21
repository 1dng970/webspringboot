package kr.co.lee.thymeleaf;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

//Thymeleaf + Spring-boot =>Model(extends or implements AOP)
@Controller
public class thymeleaf_controller {
	//Thymelea ${T}으로 static 변수값으로 로드 할 수 있도록 함 
	public static String kk ="홍길동";
			
	Logger log = LoggerFactory.getLogger(this.getClass()); 
	
	//AOP와 공용으로 사용하는 DTO 입니다
	@Resource(name="all_DTO")
	all_DTO all_inject;
	
	@GetMapping("/thymeleaf3.do")
	public String tyymeleaf3(Model m, HttpServletRequest req) {
		/*
		 * 데이터 값을 출력하는 역할 
		List<String> a = new ArrayList<>();
		a.add("aa");
		a.add("bb");
		a.add("cc");
		a.add("dd");
		*/
		
		/*
		Map<String, Object> a = new HashMap<>();
		
		a.put("data1", "aa");
		a.put("data2", "bb");
		a.put("data3", "cc");
		*/
		//Form, name, id, value 설정
		m.addAttribute("result", this.all_inject);
		m.addAttribute("act_url","/thymeleaf34.do");
		m.addAttribute("money",90000);
		m.addAttribute("money2",22.52);
	return "/thymeleaf3.html";	
	}
	
	//Thymeleaf 언어 사용업(중급)
	@GetMapping("/thymeleaf2.do")
	public String tyymeleaf2(Model m, HttpServletRequest req) {
	  int paymethod = 1;
	  m.addAttribute("paymethod", paymethod);
	  
	  //클래스 배열로 생성하여 View 전달 
	  ArrayList<String> alldata = new ArrayList<>();
	  alldata.add("검정");
	  alldata.add("핑크");
	  alldata.add("레드");
	  alldata.add("옐로우");
	  alldata.add("그린");
	  
	  m.addAttribute("alldata", alldata);
		
	  //radio, checkbox를 핸들링
	  String agree="N";
	  m.addAttribute("agree", agree);
	  
	  
	  String level="일반";
	  m.addAttribute("level", level);
	  
	  // PC 시간을 말합니다.
      LocalDateTime today = LocalDateTime.now();
      // System.out.println(today);
      // PC에 있는 값을 View로 전달시 Thymeleaf에서는 문자로 변환하지 않고 클래스 결과를 보냄
      m.addAttribute("today", LocalDateTime.now());
      
      Date to = new Date();
      // System.out.println(to.toString());
      m.addAttribute("today2", to);
      
      Random rd = new Random();
      float no = rd.nextInt(10); 
      System.out.println(no);
      
      Math.round(paymethod);
      
      return "/thymeleaf2.html";

		
	}
	
	//Thymeleaf 언어 사용법(기본)
	@GetMapping("/thymeleaf.do")
	public String tyymeleaf(Model m, HttpServletRequest req) {
		
		String code ="관리자 리스트 <br> <b>일반 관리자</b>";
		m.addAttribute("code",code);
		
		//키배열 
		Map<String, Object> all = new HashMap<>();
		all.put("mid", "hong");
		all.put("mage", 35);
		m.addAttribute("all",all);
		
		//검색어
	    String search ="수원  1 창고";
	    m.addAttribute("search",search);
		
	    //URL
	    String page ="http://naver.com";
	    m.addAttribute("page",page);
		
	    //session
	    HttpSession session = req.getSession();
	    session.setAttribute("muser", "홍길동");
	    
	    //조건값
	    String result  ="ok";
	    m.addAttribute("result",result);
	    
	    
	    
		return "/thymeleaf.html";
	}
	
		
	@GetMapping("/shop_login.do")
	public String shop_login(Model m) { //실제 메인페이지
		//this.log.info(this.all_inject.toString());
		
		m.addAttribute("menulist",this.all_inject.getMenus());
		
		return "/login.html";
	}
		
	@GetMapping("/shop.do")
	public String shop(Model m) { //실제 메인페이지
		// 해당 객체명으로 DTO에 있는 배열값을 thymeleaf HTML로 이관
		
		m.addAttribute("menulist", this.all_inject.getMenus());
		
		return "/main.html";
	}
	
	//작업용 파일 
	/*
	@GetMapping("/indextest.do")
	public String indextest() {		
		return "/index.html";
	}
	*/
		

   /*
     1. 기본 return null 사용 시 => webapp
     2. return "aaa" => webapp => aaa.jsp
     3. return "/aaa" => templates => aaa.jsp
     4. return"/aaa.html" => templates => aaa.html
    */
	
	
	@GetMapping("/sample2.do")
	public String sample2(Model m) {
		   String menu ="Admin 관리자 등록";
		   String copy ="copyright 2025 WEB begin by.....";
		   m.addAttribute("menu", menu) ;
		   m.addAttribute("copy",copy) ;
		return "/subpage.html";
	}
	
	
	//Thymeleaf View Model로 생성 후 .html에 전달 
	@GetMapping("/sample.do")
	public String sample(Model m) {
        String product ="냉장고";
        m.addAttribute("product",product);
		return "/sample.html"; //html , / => templates를 찾는다 
	}
	
}
