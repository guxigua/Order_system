package com.zhonglongchang.service;

import com.zhonglongchang.Dao.OrderDao;
import com.zhonglongchang.entity.OrderInfo;

public class OrderService {
	public OrderInfo addOrder(CarService cs,String userid) {
		OrderDao od=new OrderDao();
		return od.addOrder(cs, userid);
	}
}
