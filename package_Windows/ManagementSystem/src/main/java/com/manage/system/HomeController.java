package com.manage.system;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @概要: search.jsp urlを受け取ってブラウザで開くクラス
 * @処理内容: url= http://localhost:7779/を入力するとseatch.jspへ画面遷移する。  
 */

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
    public String showView() {
		
        return "main/search";
    }

}
