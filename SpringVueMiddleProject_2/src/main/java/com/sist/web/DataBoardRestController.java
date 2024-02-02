package com.sist.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.sist.commons.*;
//vue와 데이터 통신
//vue/react ==>Router ==>데이터 통신(송수신) = > 화면변경 = > Spring 

import com.sist.dao.DataBoardDAO;
import com.sist.vo.DataBoardVO;
@RestController
public class DataBoardRestController {
	@Autowired
	private DataBoardDAO dao;
	@Autowired
	private Commons comm;
	@GetMapping(value="databoard/list_vue.do",produces = "text/plain;charset=UTF-8")
	public String databoard_list(int page) throws JsonProcessingException {
		
			int rowsize=10;
			
			//int start=(rowsize*page)-(rowsize-1);
			//int end=rowsize*page;
			
			int start= comm.start(rowsize, page);
			int end=comm.end(rowsize, page);
			
			List<DataBoardVO>list= dao.databoardListdata(start, end);
			ObjectMapper mapper=new ObjectMapper();
				
			String json=mapper.writeValueAsString(list);
			
			return json;
			
	}
	
	@GetMapping(value="databoard/page_vue.do",produces="text/plain;charset=UTF-8")
	public String databoard_page(int page) throws JsonProcessingException {
		int totalpage=dao.databoardTotalPage();
		Map map=new HashMap();
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);//{curpage:1,totalpage:10}
		
		return json;
	}
	
	
	
	@PostMapping(value="databoard/insert_vue.do",produces="text/plain;charset=UTF-8")
	public String databoard_insert(DataBoardVO vo,HttpServletRequest request) {
		
		String result="";
		System.out.println(vo.getFiles().size());
		try {
			String path=request.getSession().getServletContext().getRealPath("/")+"upload\\";
			path=path.replace("\\", File.separator);
			File dir=new File(path);
			if(!dir.exists()) {
				dir.mkdir();
			}
			
			List<MultipartFile>list= vo.getFiles();
			
			if(list==null) {
				vo.setFilename("");
				vo.setFilesize("");
				vo.setFilecount(0);
				
				
			}
			else {
				String filenames="";
				String filesizes="";
				for (MultipartFile fr : list) {
					String name=fr.getOriginalFilename();
					File file= new File(path+name);
					fr.transferTo(file);
					
					filenames+=name+",";
					filesizes+=file.length()+",";
				}
				filenames=filenames.substring(0,filenames.lastIndexOf(","));
				filesizes=filesizes.substring(0,filesizes.lastIndexOf(","));
				
				vo.setFilename(filenames);
				vo.setFilesize(filesizes);
				vo.setFilecount(list.size());
			}
			
			dao.databoardInsert(vo);
			
			result="yes";
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result=e.getMessage();
		}
		return result;
	}
	
	@GetMapping(value="databoard/detail_vue.do",produces = "text/plain;charset=UTF-8")
	public String databoardDetail(int no) throws JsonProcessingException {
	
		DataBoardVO vo=dao.databoardDetailData(no);
		ObjectMapper mapper =new ObjectMapper();
		
		String json=mapper.writeValueAsString(vo);
		return json;
	}
	@GetMapping("databoard/download.do")
	public void download(String fn,HttpServletRequest request,HttpServletResponse response) {
		String path=request.getSession().getServletContext().getRealPath("/")+"upload//";
		path=path.replace("//", File.separator);
		
		try {
	
			File file= new File(path+fn);
			response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(fn,"UTF-8"));
			response.setContentLength((int)file.length());
			
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		//서버에서 파일을 읽어온다 
		
		BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream()); //다운로드폴더에 복사
		
		int i=0;
		byte[] buffer=new byte[1024];
		
		while ((i=bis.read(buffer,0,1024))!=-1) {
				bos.write(buffer,0,i); //i는 읽은 바이트수 
				
			
		}
		bis.close();
		bos.close();
				
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		
	}
	
}
