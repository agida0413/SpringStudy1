package com.sist.commons;

import org.springframework.stereotype.Component;

@Component
public class Commons {

	public int start(int rowsize,int page) {
		int start=(rowsize*page)-(rowsize-1);
		
		return start;
	}
	
	public int end(int rowsize,int page) {
		int end=rowsize*page;
		
		return end;
	}
	
	public int startPage() {
		return 0;
	}
	
}
