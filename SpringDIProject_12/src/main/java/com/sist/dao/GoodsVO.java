package com.sist.dao;
/*
 *  NO                                        NOT NULL NUMBER
 GOODS_NAME                                NOT NULL VARCHAR2(1000)
 GOODS_SUB                                          VARCHAR2(1000)
 GOODS_PRICE                               NOT NULL VARCHAR2(50)
 GOODS_DISCOUNT                                     NUMBER
 GOODS_FIRST_PRICE                                  VARCHAR2(20)
 GOODS_DELIVERY                            NOT NULL VARCHAR2(20)
 GOODS_POSTER                                       VARCHAR2(260)
 HIT                                                NUMBER
 * 
 */
public class GoodsVO {
public String getGOODS_SUB() {
		return GOODS_SUB;
	}
	public void setGOODS_SUB(String gOODS_SUB) {
		GOODS_SUB = gOODS_SUB;
	}
	public String getGOODS_PRICE() {
		return GOODS_PRICE;
	}
	public void setGOODS_PRICE(String gOODS_PRICE) {
		GOODS_PRICE = gOODS_PRICE;
	}
	public void setNo(int no) {
		this.no = no;
	}
private int no;
private String GOODS_SUB, GOODS_PRICE;
public int getNo() {
	return no;
}

}
