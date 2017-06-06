package com.yunhai.constants;

/**
 * 
 * @description 中国比特币平台相关常量
 * @author jiayanxing
 * @date 2017年3月9日  下午6:47:02
 */
public class CHBTCConstants {
	
	/**
	 * CHBTC 平台标志
	 */
	public static  final String PLATFORM ="CHBTC";
	
	/**
	 * CHBTC账号对应的用户名API交易的唯一标识
	 */
	public static  final String ACCESS_KEY="f716bd82-0eac-4595-a46b-6ec2a74c9e5c";
	
	/**
	 * 请求参数签名加密的私钥
	 */
	public static final String SECRET_KEY="27b297b1-e2e2-426c-86a9-747a96629bce";

	/**
	 * 获取用户信息接口
	 */
	public static String CHINA_BITCOIN_USERINFO_URL = "https://trade.chbtc.com/api/getAccountInfo?method=getAccountInfo&accesskey="+ACCESS_KEY+"&sign=%1$s&reqTime=%2$s";
	
	/**
	 * 获取CHBTC ETH/CNY 最新市场行情数据接口
	 * 参数  currency:  btc_cny :比特币/人民币  ltc_cny :莱特币/人民币  eth_cny :以太币/人民币  etc_cny :ETC币/人民币
	 */
	public static  String CHINA_BITCOIN_TICKER_ROOT_URL = "http://api.chbtc.com/data/v1/ticker?currency=%1$s";
	
	/**
	 * 获取CHBTC  BTC/CNY 历史行情数据接口
	 * 参数  currency:  btc_cny :比特币/人民币  ltc_cny :莱特币/人民币  eth_cny :以太币/人民币  etc_cny :ETC币/人民币
	 */
	public static  String CHINA_BITCOIN_TARDES_ROOT_URL = "http://api.chbtc.com/data/v1/trades?currency=%1$s";
	
	/**
	 * 获取CHBTC  BTC/CNY k线图数据接口
	 *   参数  currency:  btc_cny :比特币/人民币  ltc_cny :莱特币/人民币  eth_cny :以太币/人民币  etc_cny :ETC币/人民币
	 *   其它参数 type: 1min 3min 5min 15min 30min 1day 3day 1week 1hour 2hour 4hour 6hour 12hour
	 *  	 since 从这个时间戳之后的
	 *       size 默认1000 最大1000
	 */
	public static  String CHINA_BITCOIN_KLINE_ROOT_URL = "http://api.chbtc.com/data/v1/kline?currency=%1$s";
	
	/**
	 * 货币种类 btc_cny,ltc_cny,eth_cny,etc_cny 主要是这四种
	 */
	public static final String[] CURRENCY= new String[]{"btc_cny","ltc_cny","eth_cny","etc_cny"};
	
	public static void main(String[] args) {
//		ReadProperties pop = ReadProperties.getSingleInstance();
//		String userInfoUrl = pop.getPropertiesValue("chinaBitCoin.userInfo");
//		String url = String.format(userInfoUrl, ACCESS_KEY,SIGN,System.currentTimeMillis());
//		dispatcherRequest(url,null,null,"get");
//		System.out.println(CHBTCEncryDigestUtil.getSign(CHINA_BITCOIN_USERINFO_URL)+"------------>>>>>>>>>>>"+CHBTCEncryDigestUtil.getSignUrl(CHINA_BITCOIN_USERINFO_URL));
	}
}
