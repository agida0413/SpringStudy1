package com.sist.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.sist.dao.FoodDAO;
import com.sist.dao.FoodVO;

@Controller
public class FoodController {
	private final int ROWSIZE=20;
@Autowired
private FoodDAO dao;

@GetMapping("food/list.do")
public String food_list() {
	return "food/list";
}

@GetMapping(value="food/list_vue.do",produces = "text/plain;charset=UTF-8")
@ResponseBody
//=>@RestController
public String food_list_vue(int page){
	//vuejs=>연결전에 초기값을 설정 
	int start=(ROWSIZE*page)-(ROWSIZE-1);
	int end=ROWSIZE*page;
	
	Map map=new HashMap();
	map.put("start", start);
	map.put("end", end);
	List<FoodVO>list=dao.foodListData(map);
	int totalpage=dao.foodTotalPage();
	
	final int BLOCK=10;
	int  startpage=((page-1)/BLOCK*BLOCK)+1;
	int  endpage=((page-1)/BLOCK*BLOCK)+BLOCK;
	if(endpage>totalpage) {
		endpage=totalpage;
	}
	
	JSONArray arr=new JSONArray(); //[] 
	int i =0;
	for(FoodVO vo:list) {
		
		JSONObject obj=new JSONObject();
		
		
		obj.put("fno", vo.getFno());
		obj.put("name", vo.getName());
		obj.put("poster", vo.getPoster());
		
		if(i==0) {
			obj.put("startPage", startpage);
			obj.put("endPage", endpage);
			obj.put("totalPage", totalpage);
			obj.put("curpage", page);
			}
		arr.add(obj);
	i++;	
	
	}
	
	
	
	
	return arr.toJSONString();
}

@GetMapping("food/page_vue.do")
@ResponseBody
public String food_page_vue(int page) {
	
	return "";
}
}
