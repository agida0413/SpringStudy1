package com.sist.ann;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/*
 * 
 * <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
	 p:dataSource-ref="ds"
	 />
 */
@Component("ssf")
//지정하지않는 경우 => 자동으로 mySqlSessionFactoryBean = > 맨앞자가 소문자 
public class MySqlSessionFactoryBean extends SqlSessionFactoryBean {

	@Autowired
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		super.setDataSource(dataSource);
	}

	
}
