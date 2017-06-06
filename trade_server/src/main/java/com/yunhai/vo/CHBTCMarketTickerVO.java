package com.yunhai.vo;


import com.yunhai.model.automatic.MarketTicker;

/**
 * 
 * @description 接收CHBTC 返回行情数据封装类
 * @author jiayanxing
 * @date 2017年3月16日  下午4:44:18
 */
public class CHBTCMarketTickerVO {
	
	/**
	 * 时间戳
	 */
	private String date;
	
	/**
	 * ticker 行情数据对象
	 */
	private MarketTicker ticker;
}
