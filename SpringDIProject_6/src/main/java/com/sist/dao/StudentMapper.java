package com.sist.dao;
//mapperFactoryBean
/*
 * 1.<select> = > @select() 
 * 2.id   = > 메소드명
 * 3.resultType  = > 리턴형
 * 4.parameterType = > 매개변수
 * 
 * 
 */

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import lombok.Delegate;

public interface StudentMapper {

	@Select("SELECT * FROM student")
	public List<StudentVO> studentListData();
	
	
	@Select("SELECT * FROM student WHERE haknun=#{hakbun}")
	public StudentVO studentDetailData(int hakbun);
	
	
	@Insert("INSERT INTO student values(std_hak_seq.nextval,#{name},#{kor},#{eng},#{math})")
	public void studentInsert(StudentVO vo);
	
	
	@Delete("DELETE FROM Student WHERE hakbun=#{hakbun}")
	public void studentDelete (int hakbun);
	
	
	//{} = > get메소드
	//type="클래스명"  property="변수명"
	//class.forname()=>setxxxxxx()
	@Update("UPDATE student SET name=#{name},kor=#{kor} , eng=#{eng},math=#{math} WHERE hakbun=#{hakbun}")
	 public void studentUpdate(StudentVO vo);
}
