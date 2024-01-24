package com.sist.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class DataBoardVO {
private int no,hit,filecount;
private String name,subject,content,pwd,filename,filesize,dbday;
private Date regdate;
private List<MultipartFile> files;

}
