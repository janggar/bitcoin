package com.yunhai.bitccy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunhai.constants.CHBTCConstants;
import com.yunhai.util.CHBTCEncryDigestUtil;
import com.yunhai.util.HttpClientUtil;
import com.yunhai.util.JSONUtil;
import com.yunhai.util.ObjectConvertUtils;
import com.yunhai.util.ReadProperties;

import net.sf.json.util.JSONUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @description 中国比特币 相关业务
 * @author jiayanxing
 * @date 2017年3月8日 下午9:47:41
 */
@Service
public class CHBTC {
	
	private static Logger logger = LoggerFactory.getLogger(CHBTC.class);
	
	/**
	 * 
	 * @description get请求方式 获取数据入口
	 * @author jiayanxing
	 * @time 2017年3月8日 下午10:31:08
	 * @param url 请求url
	 * @param headers 请求头信息
	 * @param methodType 请求方式 get/post 默认为get
	 * @return String
	 * @throws URISyntaxException 
	 */
	public static String dispatcherRequest(String url,Map<String,Object> params,Map<String,Object> headers,String methodType){
		logger.info("============>>>>>>>>>dispatcherRequest方法开始执行，此方法为获取数据入口==============");
		String result="";
		if(StringUtils.isBlank(methodType)||methodType.toLowerCase().equals("get")){
			//get请求
			if(headers == null || headers.isEmpty()){
				if(params == null || params.isEmpty()){
					result = HttpClientUtil.httpGetRequest(url);
				}else{
					result = HttpClientUtil.httpGetRequest(url,params);
				}
			}else{
				result = HttpClientUtil.httpGetRequest(url,headers,params);
			}
		}else{
			//post请求
			if(headers == null || headers.isEmpty()){
				if(params == null || params.isEmpty()){
					result = HttpClientUtil.httpPostRequest(url);
				}else{
					result = HttpClientUtil.httpPostRequest(url,params);
				}
			}else{
				result = HttpClientUtil.httpPostRequest(url,headers,params);
			}
		}
		System.out.println(result);
		logger.info("============>>>>>>>>>dispatcherRequest方法执行成功，从远程获取的数据data："+result);
		return result;
	}

	/**
	 * 
	 * @description 获取CHBTC用户信息
	 * @return String
	 */
	public String getUserInfo(){
		logger.info("getUserInfo方法 获取CHBTC 用户信息开始：-------->>>>>>>>>>>>>>>>>>>>");
		String userInfo = HttpClientUtil.httpGetRequest(CHBTCEncryDigestUtil.getSignUrl(CHBTCConstants.CHINA_BITCOIN_USERINFO_URL));
		logger.info("getUserInfo方法 获取CHBTC 用户信息结束：userInfo：{}  "+userInfo);
		return  userInfo;
	}
	
	/**
	 * 
	 * @description 获取历史交易数据 //TODO 待完善 返回字符串待处理
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @return String
	 */
	public static String getHistoryTrades() throws JsonParseException, JsonMappingException, IOException{
		logger.info("getHistoryTrades方法 获取CHBTC 历史成交开始：-------->>>>>>>>>>>>>>>>>>>>");
		String trades = HttpClientUtil.httpGetRequest(String.format(CHBTCConstants.CHINA_BITCOIN_TARDES_ROOT_URL,"btc_cny"));
		logger.info("getHistoryTrades方法 获取CHBTC 历史成交结束：trades：{}  "+trades);
		String[] split = trades.split(",");
		System.out.println(split.length);
		for(int i = 0; i<split.length;i++){
			System.out.println(split[i]);
		}
		return trades;
	}
	
	/**
	 * 
	 * @description 获取k线图数据
	 * @return String
	 */
	public static String getKlineData(){
		logger.info("getKlineData方法 获取k线图数据开始：-------->>>>>>>>>>>>>>>>>>>>");
		String klineBtc = HttpClientUtil.httpGetRequest(String.format(CHBTCConstants.CHINA_BITCOIN_KLINE_ROOT_URL,"btc_cny")+"&type=1day");
		Map hashMap = ObjectConvertUtils.toHashMap(klineBtc);
		System.out.println(klineBtc);
		System.out.println("moneyType:"+hashMap.get("moneyType"));
//		System.out.println("data:"+hashMap.get("data"));
		logger.info("getKlineData方法 获取k线图数据结束  ：-------->>>>>>>>>>>>>>>>>>>>");
		return klineBtc;
		
	}
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		getHistoryTrades();
//		getKlineData();
//		System.out.println(getMarketTicker());
//		ReadProperties pop = ReadProperties.getSingleInstance();
//		String userInfoUrl = pop.getPropertiesValue("chinaBitCoin.userInfo");
//		String url = String.format(userInfoUrl, ACCESS_KEY,SIGN,System.currentTimeMillis());
//		dispatcherRequest(url,null,null,"get");
		HttpClientUtil.httpGetRequest(CHBTCEncryDigestUtil.getSignUrl(CHBTCConstants.CHINA_BITCOIN_USERINFO_URL));
	}
}
