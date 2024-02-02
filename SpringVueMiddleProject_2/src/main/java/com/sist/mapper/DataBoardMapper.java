package com.sist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.DataBoardVO;

public interface DataBoardMapper {

	@Select("SELECT no,subject,content,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
			+"FROM (SELECT no,subject,content,name,regdate,hit,rownum as num "
			+"FROM (SELECT /*+INDEX_DESC(vueDataBoard vdb_no_pk)*/no,subject,content,name,regdate,hit "
			+"FROM vueDataBoard)) "
			+"WHERE num BETWEEN #{start} and #{end}")
	public List<DataBoardVO> databoardListdata(@Param("start") int start,@Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM vueDataBoard")
	public int databoardTotalPage();
	
	@Insert("INSERT INTO vueDataBoard VALUES("
			+"vdb_no_seq.nextval,#{name},#{subject},#{content},#{pwd},"
			+"sysdate,0,#{filename},#{filesize},#{filecount})")
	public void databoardInsert(DataBoardVO vo);
	
	/*
	 * SELECT 
	 * 	=selectList =>목록 list 
	 * 	=selectOne => 상세 VO,일반데이터형 
	 * INSERT,UPDATE,DELETE = > void 
	 * 
	 * 
	 */
	@Update("UPDATE vueDataBoard set "
			+"hit=hit+1 "
			+"WHERE no=#{no}")
	public void hitIncrement(int no);
	
	@Select("SELECT no,name,subject,content,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,"
			+"hit,filename,filesize,filecount "
			+"FROM vuedataboard "
			+"WHERE no=#{no}")
	public DataBoardVO databoardDetailData(int no);
	
}
