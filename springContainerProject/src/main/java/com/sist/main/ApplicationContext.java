package com.sist.main;
import java.io.File;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.collections.map.HashedMap;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
public class ApplicationContext {

	private Map map=new HashMap();
	public ApplicationContext(String path) { // 파싱 과정 (컨테이너 ) 
		try {
			DocumentBuilderFactory dbf =
					DocumentBuilderFactory.newDefaultInstance();
			DocumentBuilder db =dbf.newDocumentBuilder();
			Document doc =db.parse(new File(path));
			Element beans = doc.getDocumentElement();
			NodeList list= beans.getElementsByTagName("bean");
			
			for(int i=0; i<list.getLength(); i++) {
			
				Element bean = (Element)list.item(i);
				String id =bean.getAttribute("id");
				String cls =bean.getAttribute("class");
				Class clsName =Class.forName(cls);
				Object obj = clsName.getDeclaredConstructor().newInstance();
				map.put(id, obj);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	}
	public Object getBean(String key) {
		return map.get(key);
	}
}
