package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.DataBoardMapper;
import com.sist.vo.DataBoardVO;
/*
 * 
 * component = > aop,mainclass,openApi = > 일반클래스
 * repository = > DAO
 * Service :BI => DAO 여러개 통합 
 * 			BoardDAO / ReplyDAO => 기능별로 클래스 (재사용)
 * 
 * @controller : 모델클래스 = > 페이지설정 
 * @restcontroller : 모델(요청처리후 응답 ) = 실제 처리된 데이터만 전송 
 * 	====다른프로그램과 연동(자바스크립트) = > JSON
 * FRONT/BACK
 * @controllerAdvice : controller에서 오류발생시 예외처리 (공통)
 * 	
 * @RestControllerAdvice: restcontroller에서 오류발생시 예외처리 (공통)
 * 
 * @Configuration:XML대신 클래스 설정을 자바로 바꿀때 
 */
@Repository
public class DataBoardDAO {

	@Autowired
	private DataBoardMapper mapper;
	
	public List<DataBoardVO> databoardListdata(int start,int end){
		return mapper.databoardListdata(start, end);
	}
	
	public int databoardTotalPage() {
	
		return mapper.databoardTotalPage();
	}

	public void databoardInsert(DataBoardVO vo) {
		
		 mapper.databoardInsert(vo);
	}
	
	public DataBoardVO databoardDetailData(int no) {
		mapper.hitIncrement(no);
		
		return mapper.databoardDetailData(no);
	}
}
