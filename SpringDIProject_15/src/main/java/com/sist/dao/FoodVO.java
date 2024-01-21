package com.sist.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
/*
 * @NoArgsConstructor //매개변수없는 생성자
 * 
 * @AllArgsConstructor//매개변수있는 생성자
 */
public class FoodVO {
	private int fno;
	private String name,address,type;
	
	
}
