package utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;

/**
 * 数字格式化类
 * @description
 * @className: NumberFormatUtils 
 * @author Jiayanxing
 * @time 2017年5月24日  下午2:44:28
 */
public class NumberFormatUtils {
	
	private static NumberFormat instance = NumberFormat.getInstance();
	
	/**
	 * String 数字字符串 转化成Number类型 eg  "1.003%" 变为 1.003
	 * @description
	 * @param str
	 * @return BigDecimal
	 */
	public static Number stringToNumber(String str){
		try {
			return instance.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
