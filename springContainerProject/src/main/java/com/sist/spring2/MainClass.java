package com.sist.spring2;

public class MainClass {
/*
 * 
 * 인터페이스를 이용하면 결합성이 new 보다는 약하다 
 * => 인터페이스의 단점(인터페이스를 수정하면 모든 클래스가 에러발생)
 * =>sw = > 인터페이스는 고정
 * 	====default
 * 
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Hello hello =new HelloImpl();
	hello.sayHello("심청이");
	}

}