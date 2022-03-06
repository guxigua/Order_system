package com.zhonglongchang.service;

import java.util.ArrayList;

import com.zhonglongchang.Dao.GoodsDao;
import com.zhonglongchang.entity.Goods;

public class GoodsService {
	public Goods getGoodsById(String Id){
		GoodsDao gd=new GoodsDao();
		return gd.getGoodsById(Id);
	}
	public int gettotalpage(){
		GoodsDao gd=new GoodsDao();
		return gd.gettotalpage();
	}
	public ArrayList getGoodsByPage(int pageNow){
		GoodsDao gd=new GoodsDao();
		return gd.getGoodsByPage(pageNow);
	}
}
