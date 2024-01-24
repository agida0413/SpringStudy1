package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.sist.mapper.DataBoardMapper;
//mvc 기초 = > jquery = > vue

/*
 * Spring MVC 
 * 	=> 1. Web.xml에 dispatcherServlet 등록 = > servlet은 url에 따라서 톰캣에 의해 호출
 * 					=================
 * 					|Servlet = > init() = > Service() = > destroy() 
 * 								  |
 * 								WebApplicationContext=클래스 정보를 넘겨준다.(컨테이너)
 * 								<init-param>
 * 									<param-name>contextConfigLocation</param-name>
 * 									<param-value>/WEB-INF/config/application-*.xml</param-value>	
 * 								</init-param>
 * 
 * 							DispatcherServlet ======= WebApplicationContext
 * 											 HandlerMapping : Model찾기(Controller)
 * 													|Model
 * 												viewResolver: jsp찾기 
 * 													|	request
 * 													view(jsp)
 * 
 * 													  handlerMapping
 * 			1.사용자 요청(.do) = Controller(DispatcherServlet)======> 요청처리(model)  
 * 								FrontController						Controller
 * 									요청받기								|  viewResolver
 * 																        |
 * 																		jsp	
 * 								WebApplicationContext
 * 
 * public classs DispatcherServlet extends HttpServlet
 * {
 * 	WebApplicationContext wc;
 * public void init(ServletConfig config){ <=
 * 			String path= config.getInitParameter("contextConfigLocation");
 * 			if(path==null){
 * 				path="/WEB-INF/<servlet-name>-servlet.xml"  (dispatcher-servlet.xml)  // 디폴트
 * 				}
 * 
 * }
 * }
 */													
@Repository
public class DataBoardDAO {
	
	@Autowired
	private DataBoardMapper mapper;
	@Autowired
	private BCryptPasswordEncoder encoder;

	
	public List<DataBoardVO> databoardListData(int start, int end){
		
		return mapper.databoardListData(start, end);
	}
	
	public void databoardInsert(DataBoardVO vo) {
	
			   mapper.databoardInsert(vo);
	}
	
	public int databoardTotalpage() {
		return mapper.databoardTotalpage();
	}
	
	public DataBoardVO databoardDetailData(int no) {
		mapper.hitIncrement(no);
		return mapper.databoardDetailData(no);
	}
	
	public DataBoardVO databoardFileInfoData(int no){
		
		return mapper.databoardFileInfoData(no);
	}
	
	
	public boolean databoardDelete(int no, String pwd) {
		boolean bCheck=false;
		String db_pwd=mapper.databoardGetPassword(no);
		if (encoder.matches(pwd, db_pwd)) { //복호화 , 순서중요
			bCheck=true;
			mapper.databoardDelete(no);
		}
	
		
		return bCheck;
	}
	
	
	public DataBoardVO databoardUpdateData(int no) {
		
		return mapper.databoardDetailData(no);
	}
	
	public boolean databoardUpdate(DataBoardVO vo) {
		boolean bCheck=false;
		String db_pwd=mapper.databoardGetPassword(vo.getNo());
		if (encoder.matches(vo.getPwd(), db_pwd)) { //복호화 , 순서중요
			bCheck=true;
				mapper.databoardUpdate(vo);
			}
		return bCheck;
		
	}
}
