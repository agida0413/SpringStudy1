package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.MemberDAO;

@RestController
public class MemberRestController {
	@Autowired
	private MemberDAO dao;

	
	
}
