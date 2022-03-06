package com.zhonglongchang.service;

import java.util.ArrayList;

import com.zhonglongchang.Dao.MyCarDao;
import com.zhonglongchang.entity.Goods;

public class CarService {
	 public ArrayList showMyCart(){
		 MyCarDao mcd=new MyCarDao();
		 return mcd.showMyCart();
	 }
	 public void addGoods(String goodsId,String goodsNum){
		 MyCarDao mcd=new MyCarDao();
		 mcd.addGoods(goodsId, goodsNum);
	 }
	 public void delgoods(String goodsId){
		 MyCarDao mcd=new MyCarDao();
		 mcd.delgoods(goodsId);
	 }
	 public void clear(){
		 MyCarDao mcd=new MyCarDao();
		 mcd.clear();
	 }
	 public void upGoods(String goodsId,String newNum){
		 MyCarDao mcd=new MyCarDao();
		 mcd.upGoods(goodsId, newNum);
	 }
	 public ArrayList getAllGoodsNum() {
		 MyCarDao mcd=new MyCarDao();
		 return mcd.getAllGoodsNum();
	 }
	public float getAllPrice() {
		 MyCarDao mcd=new MyCarDao();
		 return mcd.getAllPrice();
	 }
}
