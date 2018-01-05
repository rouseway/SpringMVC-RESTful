package com.github.rouseway.spring.mvc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;    

import com.alibaba.fastjson.JSON;
import com.github.rouseway.spring.service.IndexService;


@Controller
public class IndexController {
	
	//this is the service
	@Autowired
	private IndexService indexSvc;

	
	@RequestMapping(value="index.do")
	public void __index(Model model) {	
		//call service
		String display = "";
		try {
			display = indexSvc.getStrFromService();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("strDisplay", display);    
		System.out.println("index.jsp");
	}
	
	
	@RequestMapping(value="/query", method=RequestMethod.GET)
	@ResponseBody
	public String __query() {
		/* test input: */
		// curl -l -H "Content-type: application/json" -X GET http://localhost:8080/query
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("project", "spring-restful");
		map.put("lang", "java");
		
		return JSON.toJSONString(map);
	}
	
	
	@CrossOrigin(maxAge=3600)
	@RequestMapping(value="/question", method=RequestMethod.POST, produces="application/json;charset=UTF-8")
	@ResponseBody
	public Test __question(@RequestBody Map<String, Object> reqMap) {
		/* test input: */
		// curl -l -H "Content-type: application/json" -X POST -d '{"name":"rouseway", "age":30}' http://localhost:8080/spring-restful/question
		
		//get input elements
		String name = (String)reqMap.get("name");
		int age = (Integer)reqMap.get("age");
		
		//construct object of your defined Class
		Test tt = new Test(name, age);
		
		//call for your defined functions
		System.out.println(tt.mergeNameAge());
		
		//tt must has SET/GET methods
		return tt;
	}
}
