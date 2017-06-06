package com.yunhai.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
	 
public class DateCommon {
	 
    private static final SimpleDateFormat YYYY_MM_DD = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat YYYY_MM_DD_HH_MM_SS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 
    public static void main(String[] args) throws Exception{
    	DateCommon test = new DateCommon();
    	String nowDate = YYYY_MM_DD.format(new Date());
    	int days = daysBetween("2016-05-05",nowDate);
    	
        Calendar start = Calendar.getInstance();
//        start.setTime(sdf.parse("2016-05-05"));
        Calendar end = Calendar.getInstance();
        
        end.add(Calendar.DATE, 3);
        
        List<Date> dates = test.getDates(start, end);
 
        test.printDate("Start\t", start.getTime());
        
        for (Date date : dates) {
            test.printDate("-->\t", date);
        }
        
        test.printDate("End\t", end.getTime());
        
        List<String> dayList = new ArrayList();
        int day = 05;
        for(int i = 0;i<days;i++){
        	day ++;
        	dayList.add("2016-05-" + day);
        }
        System.out.print(dayList);
        
    }
 
    /** 
     * 日期对象转换为时间戳 
     */  
    public static String date2Timestamp(Date date){
       return Long.valueOf(date.getTime()).toString();
    }  
      
    /** 
     * 时间戳转换为日期对象 
     */  
    public static Date timestamp2Date(String timestamp){
    	try {
			return YYYY_MM_DD_HH_MM_SS.parse(timestamp);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
    }  
    
    // Print the date with the format.
    public void printDate(String p_msg, Date p_date) {
        System.out.println(p_msg + YYYY_MM_DD.format(p_date));
    }
 
    /**
     * Get the Dates between Start Date and End Date.
     * @param p_start   Start Date
     * @param p_end     End Date
     * @return Dates List
     */
    public List<Date> getDates(Calendar p_start, Calendar p_end) {
        List<Date> result = new ArrayList<Date>();
        Calendar temp = p_start.getInstance();
        temp.add(Calendar.DAY_OF_YEAR, 1);
        
        while (temp.before(p_end)) {
            result.add(temp.getTime());
            temp.add(Calendar.DAY_OF_YEAR, 1);
        }
        
        return result;
    }
    
    /** 
    * 计算两个日期之间相差的天数 
    * @param smdate 较小的时间 
    * @param bdate 较大的时间 
    * @return 相差天数 
    */ 
    public static int daysBetween(Date smdate,Date bdate) throws Exception{ 
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
		smdate=sdf.parse(sdf.format(smdate));
		bdate=sdf.parse(sdf.format(bdate)); 
		
	    Calendar cal = Calendar.getInstance(); 
	    cal.setTime(smdate); 
	    
	    long time1 = cal.getTimeInMillis(); 
	    cal.setTime(bdate); 
	    long time2 = cal.getTimeInMillis(); 
	    long between_days=(time2-time1)/(1000*3600*24); 
	
	    return Integer.parseInt(String.valueOf(between_days)); 
	    
    } 
    
    /** 
    *字符串的日期格式的计算 
    */ 
    public static int daysBetween(String smdate,String bdate) throws Exception{ 
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
	    Calendar cal = Calendar.getInstance(); 
	    cal.setTime(sdf.parse(smdate)); 
	    
	    long time1 = cal.getTimeInMillis(); 
	    cal.setTime(sdf.parse(bdate)); 
	    long time2 = cal.getTimeInMillis(); 
	    long between_days=(time2-time1)/(1000*3600*24); 
	
	    return Integer.parseInt(String.valueOf(between_days)); 
    } 
}
