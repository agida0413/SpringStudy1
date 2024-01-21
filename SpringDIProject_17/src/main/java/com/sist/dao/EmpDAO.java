package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.main.*;
import com.sist.mapper.EmpMapper;

@Repository("eDao")
public class EmpDAO {
   @Autowired
   private EmpMapper mapper;
   
   public List<EmpVO> empAllData()
   {
	   return mapper.empAllData();
   }
   // <select id="empDetailData" resultMap="empMap" parameterType="int">
   public EmpVO empDetailData(int empno)
   {
	   return mapper.empDetailData(empno);
   }
}