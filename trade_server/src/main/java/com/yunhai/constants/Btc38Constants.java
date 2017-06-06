package com.yunhai.constants;

import java.util.HashMap;
import java.util.Map;

import com.yunhai.util.JSONUtil;
import com.yunhai.util.ObjectConvertUtils;
import com.yunhai.util.ReadProperties;

/**
 * 
 * @description  比特时代平台相关常量
 * @className: Btc38Constants 
 * @author Jiayanxing
 * @time 2017年5月22日  下午3:41:53
 */
public class Btc38Constants {

	/**
	 * BTC38 平台标志
	 */
	public static  final String PLATFORM ="BTC38";
	
	/**
	 * 用户id
	 */
	public static  final String USERID ="187885";
	
	/**
	 * 账户公钥
	 */
	public static  final String PUBLIC_KEY ="bd3ec315b823d90f222cd520f1abb40d";
	
	/**
	 * 账户私钥
	 */
	public static  final String SECRET_KEY ="ddabb8f0042d1966f08a5d2384c06e80b2978cb9692d4907b5bb0c0b35732392";
	
	/**
	 * 获取账户余额
	 * 调用方式 POST 传入参数 ：key，时代提供的32位公钥 . time，挂单时的时间戳，单位为秒 . md5，使用md5(key_用户ID_skey_time)，SKEY为32位密钥，顺序不可颠倒 
	 */
	public static final String BTC38_ACCOUNT_BALANCE_URL = "http://api.btc38.com/v1/getMyBalance.php";
	
	/**
	 * 平台虚拟货币中英文对照map   其中 key为英文名  value 为中文名
	 */
	public static final HashMap<String,Object> currencyNameMap = ObjectConvertUtils.toHashMap(ReadProperties.getSingleInstance().getBitcoinApiValue("btc38_currencyName"));
}
