package com.sist.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
//vue로 데이터를 전송 = > [] , {}

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.FoodDAO;
import com.sist.dao.FoodVO;
@RestController
public class FoodRestController {
@Autowired
private FoodDAO dao;
	
	@GetMapping(value="food/list_vue.do",produces = "text/plain;charset=UTF-8")
	public String food_list_vue() throws JsonProcessingException {
		
		List<FoodVO> list = dao.foodListData();
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(list);
		
		
		return json;
		
	}
	
	@GetMapping(value="food/detail_vue.do",produces = "text/plain;charset=UTF-8" )
	public String food_detail_vue(int fno) throws JsonProcessingException
	{
		FoodVO vo =dao.foodDetailData(fno);
		
		ObjectMapper mapper =new ObjectMapper();
		String json=mapper.writeValueAsString(vo);
		
		return json;
	}
	
}
