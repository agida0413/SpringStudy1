package com.sist.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.sist.dao.DataBoardDAO;
import com.sist.dao.DataBoardVO;

import oracle.net.aso.l;

//@RequestMapping = > get과 post를 동시에 
//get방식 처리 - > getmapping , post방식 처리 - > postmapping
//pathValiable

@Controller
@RequestMapping("databoard/")
public class DataBoardController {
	@Autowired
	private DataBoardDAO dao;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	/*
	 * 
	 * 매개변수 
	 * 모든 데이터는 string, 해당 데이터형으로 설정 가능 
	 * model = > 전송객체 
	 * addAttribute(String key,Object obj)
	 * {
	 * 	request.setAttribute(key,obj)
	 * }
	 * 내장객체 
	 * 1.HttpServletRequest 
	 * 2.HttpServletResponse
	 * 3.HttpSession
	 * 4.RedirectAttributes
	 * 5.커멘드 객체 =>vo단위 
	 * 6.String[]
	 * 7.List
	 * 		=>name="file[0]"
	 * 		=>400 bad request
	 * 		=>404,500
	 */
	//사용자 요청처리
	
	
	/*
	 * 1.Model
	 * 	1)구분자(메소드 찾기)
	 * 		=>@RequestMapping(URI)
	 * 		  =@getMapping(URI)		(ContextPath)
	 * 		  =@postMapping(URI)		 |
	 * 		http://localhost:8080		/web	/databoard/list.do = >URL
	 * 		--------------------- 		--------------------------
	 * 			서버정보						URI	
	 * 
	 * 2)리턴형
	 * 	=String : jsp파일명 지정 
	 * 			   경로명/jsp명 = > forward  = > request넘길때
	 * 			:redirect: ....do = > sendRedirect 
	 *  =void : 다운로드 , ajax =>@RestController
	 *  
	 *  3)매개변수 : String , 해당데이터형 ,vo 
	 *  			=>내장객체 ,model,redirectAttributes
	 *  				
	 *  4)메소드명은 아무거나 사용이 가능
	 *  
	 *   5)getBean()=>Distpatcher자체처리 
	 *   	=>@autoWired @qualifer
	 *   **** 스프링에서 메모리 할당을 해야 @AutoWired를 사용할수 있다 
	 *   
	 *   @AutoWired는 객체 주소받는 경우에만 사용
	 *    
	 *   @Value()= > 일반데이터
	 *    
	 */
	
	@GetMapping("list.do")
	public String databoard_list(String page,Model model) { // int page = > 최초값 null - > nullpoint 발생 -> string page
		
		if (page==null) {
			page="1";
		}
		int curpage=Integer.parseInt(page);
		int rowsize=10;
		int start=(rowsize*curpage)-(rowsize-1);
		int end=rowsize*curpage;
		
		int totalpage=dao.databoardTotalpage();
		List<DataBoardVO>list=dao.databoardListData(start, end);
		
		model.addAttribute("list",list);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("curpage",curpage);
		
		return "databoard/list";
	}
	
	
	@GetMapping("insert.do")
	public String databoard_insert() {
		return "databoard/insert";
	}
	
	@PostMapping("insert_ok.do")
	public String databoard_insert_ok(DataBoardVO vo,HttpServletRequest request) { //커멘트 객체
		String path=request.getSession().getServletContext().getRealPath("/")+"upload\\"; //aws올릴떄
		path=path.replace("\\", File.separator);
		File dir=new File(path);
		if(!dir.exists()) {
		dir.mkdir();	
		}
		List<MultipartFile>list=vo.getFiles(); 
		if(list==null) { //업로드가없는 상태
			vo.setFilename("");
			vo.setFilesize("");
			vo.setFilecount(0);
		}
		else {//업로드가 있는상태
				String filename="";
				String filesize="";
				for(MultipartFile mf:list) {
					String name=mf.getOriginalFilename();
					//사용자가 보낸  파일명 
					File file=new File(path+name);//파일크기결정 위해
					try {
						mf.transferTo(file);//업로드 
						filename+=name+","; //테이블여러개 x 하나로 관리하기 위해 기존은 테이블하나 더 만드는게 맞음 
						filesize+=file.length()+",";
					} catch (Exception e) {
						// TODO: handle exception
					e.printStackTrace();
					}	
					
					
				}
				filename=filename.substring(0,filename.lastIndexOf(","));
				filesize=filesize.substring(0,filesize.lastIndexOf(","));
				vo.setFilename(filename);
				vo.setFilesize(filesize);
				vo.setFilecount(list.size());
		
				
		}
		String enPwd=encoder.encode(vo.getPwd());
		vo.setPwd(enPwd); // 같은 1234라도 여러 패턴= > 다른 문자열 암호화
		dao.databoardInsert(vo);
		return "redirect:list.do";
	}
	
	@GetMapping("detail.do")
	public String databoard_detail(int no,Model model) {
		DataBoardVO vo =dao.databoardDetailData(no);
		if (vo.getFilecount()>0) {
			String []filenames=vo.getFilename().split(",");
			String []filesizes=vo.getFilesize().split(",");		
		
			List<String>fList=Arrays.asList(filenames);
			List<String>sList=Arrays.asList(filesizes);
			model.addAttribute("fList",fList);
			model.addAttribute("sList",sList);
			
		}
		model.addAttribute("vo",vo);
		return "databoard/detail";
	}
	
	@GetMapping("download.do")
	public void databoard_download(String fn,HttpServletRequest request,HttpServletResponse response) {
		try {
			//file명,file크기 
			String path=request.getSession().getServletContext().getRealPath("/")+"upload\\";
			path=path.replace("\\",File.separator);
			File file= new File(path+fn);
			
			response.setHeader("Content-Disposition", "attachmenet;filename="+URLEncoder.encode(fn,"UTF-8"));//파일명
			response.setContentLength((int)file.length());//파일크기
			
			BufferedInputStream bis=
						new BufferedInputStream(new FileInputStream(file)); //서버에서 읽음
			
			BufferedOutputStream bos =
								new BufferedOutputStream(response.getOutputStream());//클라이언트에서 복사
			int i=0;
			byte[] buffer=new byte[1024];
			
			while((i=bis.read(buffer,0,1024))!=-1) {
					bos.write(buffer,0,i);
			}
			bis.close();
			bos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
				e.printStackTrace();
		}
	}
	
	
	@GetMapping("update.do")
	public String databoard_update(int no,Model model) {
		
		DataBoardVO vo=dao.databoardUpdateData(no);
		model.addAttribute("vo",vo);
		return "databoard/update";
	}
	
	@PostMapping("update_ok.do")
	public String databoard_update_ok(DataBoardVO vo,Model model,HttpServletRequest request) {
		String path=request.getSession().getServletContext().getRealPath("/")+"upload\\";
		path=path.replace("\\",File.separator);
		
		DataBoardVO fvo=dao.databoardFileInfoData(vo.getNo());
		
		try {
			if(fvo.getFilecount()>0) {
				StringTokenizer st=new StringTokenizer(vo.getFilename(),",");
				
				while(st.hasMoreTokens()) {
					File  file= new File(path+st.nextToken());
				}
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<MultipartFile> list= vo.getFiles();
		if(list==null) {
		vo.setFilename("");
		vo.setFilesize("");
		vo.setFilecount(0);
		}
		else {
			String filename="";
			String filesize="";
			
			for(MultipartFile mf:list) {
				String name=mf.getOriginalFilename();
				File f=new File(path+name);
				try {
					mf.transferTo(f);
				} catch (Exception e) {
					// TODO: handle exception
				}
				filename+=name+",";
				filesize+=f.length()+",";
				
				
			}
			filename=filename.substring(0,filename.lastIndexOf(","));
			filesize=filesize.substring(0,filesize.lastIndexOf(","));
			vo.setFilecount(list.size());
			vo.setFilename(filename);
			vo.setFilesize(filesize);
			
		
		}
		boolean bCheck=dao.databoardUpdate(vo);
		model.addAttribute("bCheck",bCheck);
		model.addAttribute("no",vo.getNo());
		return "databoard/update_ok";
	}
}
