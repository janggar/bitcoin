package com.yunhai.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
 * @description 对象转化工具类
 * @className: ObjectConvertUtils
 * @author Jiayanxing
 * @time 2017年4月19日 下午5:40:07
 */
public class ObjectConvertUtils {

	/***
	 * 将对象转换为HashMap
	 * 
	 * @param object
	 * @return
	 */
	public static HashMap<String, Object> toHashMap(Object object) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		JSONObject jsonObject = toJSONObject(object);
		Iterator it = jsonObject.keys();
		while (it.hasNext()) {
			String key = String.valueOf(it.next());
			Object value = jsonObject.get(key);
			data.put(key, value);
		}

		return data;
	}
	
	/***
	 * 将对象转换为LinkedHashMap
	 * 
	 * @param object
	 * @return
	 */
	public static LinkedHashMap<String, Object> toLinkedHashMap(Object object) {
		LinkedHashMap<String, Object> data = new LinkedHashMap<String, Object>();
		JSONObject jsonObject = toJSONObject(object);
		Iterator it = jsonObject.keys();
		while (it.hasNext()) {
			String key = String.valueOf(it.next());
			Object value = jsonObject.get(key);
			data.put(key, value);
		}
		return data;
	}

	/***
	 * 将对象转换为List
	 * 
	 * @param object
	 * @return
	 */
	// 返回非实体类型(Map)的List
	@SuppressWarnings("rawtypes")
	public static List<Map<String, Object>> toList(Object object) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		JSONArray jsonArray = JSONArray.fromObject(object);
		for (Object obj : jsonArray) {
			JSONObject jsonObject = (JSONObject) obj;
			Map<String, Object> map = new HashMap<String, Object>();
			Iterator it = jsonObject.keys();
			while (it.hasNext()) {
				String key = (String) it.next();
				Object value = jsonObject.get(key);
				map.put((String) key, value);
			}
			list.add(map);
		}
		return list;
	}
	
	/**
	 * 
	 * @description 将对象转化为BigDecimal
	 * @param value
	 * @return BigDecimal
	 */
	public static BigDecimal toBigDecimal(Object value) {
		BigDecimal ret = null;
		if (value != null) {
			if (value instanceof BigDecimal) {
				ret = (BigDecimal) value;
			} else if (value instanceof String) {
				ret = new BigDecimal((String) value);
			} else if (value instanceof BigInteger) {
				ret = new BigDecimal((BigInteger) value);
			} else if (value instanceof Number) {
				ret = new BigDecimal(((Number) value).doubleValue());
			} else {
				throw new ClassCastException("Not possible to coerce [" + value + "] from class " + value.getClass()
						+ " into a BigDecimal.");
			}
		}
		return ret;
	}

	/***
	 * 将对象转换为JSON对象
	 * 
	 * @param object
	 * @return
	 */
	public static JSONObject toJSONObject(Object object) {
		return JSONObject.fromObject(object);
	}

}
