package com.yunhai.bitccy.auto;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.druid.support.json.JSONUtils;
import com.yunhai.constants.CHBTCConstants;
import com.yunhai.dao.automatic.MarketTickerMapper;
import com.yunhai.model.automatic.MarketTicker;
import com.yunhai.util.DateCommon;
import com.yunhai.util.HttpClientUtil;
import com.yunhai.util.JSONUtil;
import com.yunhai.vo.CHBTCMarketTickerVO;

import net.sf.json.JSONObject;

/**
 * 
 * @description CHBTC 市场行情相关任务
 * @author jiayanxing
 * @date 2017年3月13日 下午5:10:50
 */
@Component
public class MarketTask {

	private static Logger logger = LoggerFactory.getLogger(MarketTask.class);
	
	@Autowired
	private MarketTickerMapper marketTickerMapper;

	// CRON表达式 含义
	// "0 0 12 * * ?" 每天中午十二点触发
	// "0 15 10 ? * *" 每天早上10：15触发
	// "0 15 10 * * ?" 每天早上10：15触发
	// "0 15 10 * * ? *" 每天早上10：15触发
	// "0 15 10 * * ? 2005" 2005年的每天早上10：15触发
	// "0 * 14 * * ?" 每天从下午2点开始到2点59分每分钟一次触发
	// "0 0/5 14 * * ?" 每天从下午2点开始到2：55分结束每5分钟一次触发
	// "0 0/5 14,18 * * ?" 每天的下午2点至2：55和6点至6点55分两个时间段内每5分钟一次触发
	// "0 0-5 14 * * ?" 每天14:00至14:05每分钟一次触发
	// "0 10,44 14 ? 3 WED" 三月的每周三的14：10和14：44触发
	// "0 15 10 ? * MON-FRI" 每个周一、周二、周三、周四、周五的10：15触发
	
	/**
	 * 
	 * 一个cron表达式有至少6个（也可能7个）有空格分隔的时间元素。
	按顺序依次为 1:秒（0~59）2:分钟（0~59）3:小时（0~23）4:天（月）（0~31，但是你需要考虑你月的天数）5:月（0~11）6：天（星期）（1~7 1=SUN 或 SUN，MON，TUE，WED，THU，FRI，SAT）7:年份（1970－2099）
	其中每个元素可以是一个值(如6),一个连续区间(9-12),一个间隔时间(8-18/4)(/表示每隔4小时),一个列表(1,3,5),通配符。由于"月份中的日期"和"星期中的日期"这两个元素互斥的,必须要对其中一个设置?.
	eg：
	0 0 10,14,16 * * ? 每天上午10点，下午2点，4点
	0 0/30 9-17 * * ?   朝九晚五工作时间内每半小时
	0 0 12 ? * WED 表示每个星期三中午12点 
	"0 0 12 * * ?" 每天中午12点触发 
	"0 15 10 ? * *" 每天上午10:15触发 
	"0 15 10 * * ?" 每天上午10:15触发 
	"0 15 10 * * ? *" 每天上午10:15触发 
	"0 15 10 * * ? 2005" 2005年的每天上午10:15触发 
	"0 * 14 * * ?" 在每天下午2点到下午2:59期间的每1分钟触发 
	"0 0/5 14 * * ?" 在每天下午2点到下午2:55期间的每5分钟触发 
	"0 0/5 14,18 * * ?" 在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发 
	"0 0-5 14 * * ?" 在每天下午2点到下午2:05期间的每1分钟触发 
	"0 10,44 14 ? 3 WED" 每年三月的星期三的下午2:10和2:44触发 
	"0 15 10 ? * MON-FRI" 周一至周五的上午10:15触发 
	"0 15 10 15 * ?" 每月15日上午10:15触发 
	"0 15 10 L * ?" 每月最后一日的上午10:15触发 
	"0 15 10 ? * 6L" 每月的最后一个星期五上午10:15触发 
	"0 15 10 ? * 6L 2002-2005" 2002年至2005年的每月的最后一个星期五上午10:15触发 
	"0 15 10 ? * 6#3" 每月的第三个星期五上午10:15触发 
	
	有些子表达式能包含一些范围或列表
	例如：子表达式（天（星期））可以为 “MON-FRI”，“MON，WED，FRI”，“MON-WED,SAT”
	“*”字符代表所有可能的值
	因此，“*”在子表达式（月）里表示每个月的含义，“*”在子表达式（天（星期））表示星期的每一天
	“/”字符用来指定数值的增量
	例如：在子表达式（分钟）里的“0/15”表示从第0分钟开始，每15分钟  在子表达式（分钟）里的“3/20”表示从第3分钟开始，每20分钟（它和“3，23，43”）的含义一样
	“？”字符仅被用于天（月）和天（星期）两个子表达式，表示不指定值  当2个子表达式其中之一被指定了值以后，为了避免冲突，需要将另一个子表达式的值设为“？”
	“L” 字符仅被用于天（月）和天（星期）两个子表达式，它是单词“last”的缩写 但是它在两个子表达式里的含义是不同的。
	在天（月）子表达式中，“L”表示一个月的最后一天  在天（星期）自表达式中，“L”表示一个星期的最后一天，也就是SAT 如果在“L”前有具体的内容，它就具有其他的含义了
	例如：“6L”表示这个月的倒数第６天，“ＦＲＩＬ”表示这个月的最一个星期五
	注意：在使用“L”参数时，不要指定列表或范围，因为这会导致问题
	 */

	/**
	 * 
	 * @description 获取CHBTC最新市场行情数据接口 每天下午6点更新数据
	 * @return String
	 */
	@Scheduled(cron = "0 0 18 * * ?")
	public void getMarketTicker() {
		logger.info("getMarketTicker方法：获取CHBTC最新市场行情数据 每天下午6点更新数据开始：-------->>>>>>>>>>>>");
		Map<String, Object> tickerMap = new HashMap<String, Object>();
		for(String cur:CHBTCConstants.CURRENCY){
			String ticker = HttpClientUtil.httpGetRequest(String.format(CHBTCConstants.CHINA_BITCOIN_TICKER_ROOT_URL,cur));
			JSONObject object = JSONUtil.toJSONObject(ticker);
			MarketTicker vo = JSONUtil.toBean(object.get("ticker"), MarketTicker.class);
			vo.setDate(DateCommon.timestamp2Date(object.get("date").toString()));
			vo.setCurrency(cur);
			vo.setPlatform(CHBTCConstants.PLATFORM);
			vo.setCreatetime(new Date());
			//插入行情数据
			marketTickerMapper.insert(vo);
		}
		logger.info("getMarketTicker方法：获取CHBTC最新市场行情数据 每天下午6点更新数据结束：tickerMap：{}  " + tickerMap);
	}
	
	
//	public static void main(String[] args) {
//		getMarketTicker();
//	}
}
