package com.yunhai.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import net.sf.json.JSONObject;

public class ReadProperties {
	
	private static ReadProperties instace= null;
	private static Properties prop = new Properties();
	private String propertiesName = "bitcoinApi";
	
	private ReadProperties(){
	}
	
	/**
	 * 
	 * @description 懒汉式创建单例   双重检查锁定  
	 * @author jiayanxing
	 * @time 2017年3月8日 下午11:50:45
	 * @return ReadPropertiesValue
	 */
	public static ReadProperties getSingleInstance(){
		if(instace ==null){
			synchronized(ReadProperties.class){
				if(instace == null){
					instace = new ReadProperties();
				}
			}
		}
		return instace;
	}
	
	/**
	 * 
	 * @description 获取属性值
	 * @param propertiesName 文件名 可为null 默认为bitcoinApi.properties文件 只支持在properties文件夹下
	 * @param key  关键词
	 * @return String
	 */
	public String getPropertiesValue(String propertiesName,String key){
		setPropertiesFile(propertiesName);
		return prop.getProperty(key);
	}
	
	/**
	 * 
	 * @description 获取   bitcoinApi.properties 属性值
	 * @param key  关键词
	 * @return String
	 */
	public String getBitcoinApiValue(String key){
		setPropertiesFile(null);
		return prop.getProperty(key);
	}
	
	/**
	 * 
	 * @description 设置文件
	 * @param propertiesName 文件名
	 * @return void
	 */
	private void setPropertiesFile(String propertiesName){
		if(propertiesName !=null && !propertiesName.isEmpty()){
			this.propertiesName = propertiesName;
		}
		try {
			InputStream inStream = ReadProperties.class.getResourceAsStream( "/properties/"+this.propertiesName+".properties" ); 
			prop.load(new InputStreamReader(inStream, "utf-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Map map =  ObjectConvertUtils.toHashMap(ReadProperties.getSingleInstance().getBitcoinApiValue("btc38_currencyName"));
		System.out.println(map);
	}
}
