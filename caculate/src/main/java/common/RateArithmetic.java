package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import utils.NumberFormatUtils;

/**
 * 常规 四则精确运算
 * @description
 * @className: Arithmetic 
 * @author Jiayanxing
 * @time 2017年5月24日  上午11:39:35
 */
public class RateArithmetic {
	//收益利率
	private static final String[] rate = {"0.5%","1%","2%","3%","5%","7%","10%","15%","20%"};
	//交易手续费率
	private static final String BTC38_COMMON_TRADE_RATE = "0.1%";
	//btc ltc tmc 三种币的交易手续费率
	private static final String BTC38_SPECIAL_TRADE_RATE = "0.2%";
	
	private static final String BTC38_FULL_RATE = "100%";
	
	/**
	 * 
	 * @description  获取止损止盈价格
	 * @param rice
	 * @return List<String>
	 */
	public static List<String> simpleArithmetic(BigDecimal rice,BigDecimal money){
		List<String> list = new ArrayList<String>();
		for(String obj:rate){
			BigDecimal riseRate = new BigDecimal(NumberFormatUtils.stringToNumber(obj).toString());
			BigDecimal tradeRate = new BigDecimal(NumberFormatUtils.stringToNumber(BTC38_COMMON_TRADE_RATE).toString());
			BigDecimal fullRate = new BigDecimal(NumberFormatUtils.stringToNumber(BTC38_FULL_RATE).toString());
			BigDecimal stopLostPrice = rice.multiply((fullRate.subtract(riseRate)).divide(fullRate.subtract(tradeRate),6,BigDecimal.ROUND_HALF_UP));
			BigDecimal stopProfitPrice = rice.multiply((fullRate.add(riseRate)).divide(fullRate.subtract(tradeRate),6,BigDecimal.ROUND_HALF_UP));
			BigDecimal lostMoney = null;
			BigDecimal riseMoney = null;
			if(money !=null){
				lostMoney = money.multiply(fullRate.subtract(riseRate)).divide(new BigDecimal("100"),6,BigDecimal.ROUND_HALF_UP);
				riseMoney = money.multiply(fullRate.add(riseRate)).divide(new BigDecimal("100"),6,BigDecimal.ROUND_HALF_UP);
				list.add("利率为"+obj+"		止损价格:	"+stopLostPrice.toString()+"	止盈价格:	"+stopProfitPrice.toString()+"		===========	止损总额:	 "+lostMoney.toString()+"	止盈总额:	 "+riseMoney.toString());
			}else{
				list.add("利率为"+obj+"		止损价格:	"+stopLostPrice.toString()+"	止盈价格:	"+stopProfitPrice.toString());
			}
		}
		return list;
	}
	
	public static void getRice() throws IOException{
		System.out.println("获取止损止盈价格开始(包含交易手续费率)----->>>>>>请输入价格:"); 
		BufferedReader buffer1 = new BufferedReader(new InputStreamReader(System.in));
		String riceStr = buffer1.readLine();
		BigDecimal rice = new BigDecimal(riceStr);
		List<String> resultRice = simpleArithmetic(rice,null);
		for(String obj:resultRice){
			System.out.println(obj);
		}
	}
	
	public static void getTotal() throws IOException{
		/********************获取价格********************/
		System.out.println("获取止损止盈价格开始(包含交易手续费率)----->>>>>>请输入价格:"); 
		BufferedReader buffer1 = new BufferedReader(new InputStreamReader(System.in));
		String riceStr = buffer1.readLine();
		BigDecimal rice = new BigDecimal(riceStr);
		/*********************获取价格和总额************************/
		System.out.println("获取止损止盈价格开始(包含交易手续费率)----->>>>>>请输入交易总额:"); 
		BufferedReader buffer2 = new BufferedReader(new InputStreamReader(System.in));
		String totalMoneyStr = buffer2.readLine();
		BigDecimal totalMoney = new BigDecimal(totalMoneyStr);
		List<String> resultAll = simpleArithmetic(rice,totalMoney);
		for(String obj:resultAll){
			System.out.println(obj);
		}
	}
	
	public static void main(String[] args) throws IOException, ParseException {
		//获取价格
		getRice();
		System.out.println("===========================================================================");
		//价格和总额
//		getTotal();
	}
}
