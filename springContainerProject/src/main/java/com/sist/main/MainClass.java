package com.sist.main;

public class MainClass {
	public static void main(String[] args) {
		String path="C:\\SpringDev\\SpringStudy\\springContainerProject\\src\\main\\java\\com\\sist\\main\\app.xml";

		ApplicationContext app=
							new ApplicationContext(path);
		Board board =(Board)app.getBean("board");
		board.board_list();
		
		System.out.println(board);
		Board board1 =(Board)app.getBean("board");
		board.board_list();
		System.out.println(board1);
		
		Board board2 =(Board)app.getBean("board");
		board.board_list();
		System.out.println(board2);	
	}


}
