package com.yunhai.bitccy.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.yunhai.bitccy.service.IBtc38CapitalService;
import com.yunhai.constants.Btc38Constants;
import com.yunhai.util.DateCommon;
import com.yunhai.util.DateUtil;
import com.yunhai.util.HttpClientUtil;
import com.yunhai.util.JSONUtil;
import com.yunhai.util.MD5;
import com.yunhai.util.ObjectConvertUtils;
import com.yunhai.vo.Btc38CapitalVO;

/**
 * 
 * @description 比特时代 相关业务
 * @className: Btc38 
 * @author Jiayanxing
 * @time 2017年5月22日  下午3:59:29
 */
@Service
public class Btc38CapitalServiceImpl implements IBtc38CapitalService{
	
	private static Logger logger = LoggerFactory.getLogger(Btc38CapitalServiceImpl.class);
	
	@Override
	public List<Btc38CapitalVO> getAccountBalance(){
		logger.info("getAccountBalance方法 获取btc38平台  账户余额开始：-------->>>>>>>>>>>>>>>>>>>>");
		Date date = new Date();
		String time= DateCommon.date2Timestamp(date);
		String md5 = MD5.EncoderByMd5(Btc38Constants.PUBLIC_KEY+"_"+Btc38Constants.USERID+"_"+Btc38Constants.SECRET_KEY+"_"+time);
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("key", Btc38Constants.PUBLIC_KEY);
		params.put("time", time);
		params.put("md5", md5);
		String accountBalance = HttpClientUtil.httpPostRequest(Btc38Constants.BTC38_ACCOUNT_BALANCE_URL, params);
		Map map = ObjectConvertUtils.toHashMap(accountBalance);
		List<Btc38CapitalVO> capitalList = new ArrayList<Btc38CapitalVO>();
		if(map != null && !map.isEmpty()){
			//可用资金key list
			List<String> availableList = new ArrayList<String>();
			for(Object key:map.keySet()){
				String btcKey = key.toString();
				if(btcKey.endsWith("_balance")){
					availableList.add(btcKey);
				}
			}
			if(availableList != null && availableList.size() > 0 ){
				for(int i = 0;i<availableList.size();i++){
					Btc38CapitalVO btc38CapitalVO = new Btc38CapitalVO();
					String availableStr = availableList.get(i);
					String capitalName = availableStr.split("_")[0];
					String capitalId = Btc38Constants.PLATFORM+"_"+Btc38Constants.USERID+"_"+capitalName+"_"+DateUtil.getlongTime(date).toString();
					String available = map.get(availableStr) != null?map.get(availableStr).toString():"0.000000";
					String entryOrder = map.get(availableStr+"_lock") != null?map.get(availableStr+"_lock").toString():"0.000000";
					String confirming = map.get(availableStr+"_imma") != null?map.get(availableStr+"_imma").toString():"0.000000";
					Object name = Btc38Constants.currencyNameMap.get(capitalName.toUpperCase());
					BigDecimal sum = ObjectConvertUtils.toBigDecimal(available).add(ObjectConvertUtils.toBigDecimal(entryOrder)).add(ObjectConvertUtils.toBigDecimal(confirming));
					btc38CapitalVO.setSum(sum.toString());
					btc38CapitalVO.setCapitalName(capitalName);
					btc38CapitalVO.setChineseName(name!=null?name.toString():"新加币种");
					btc38CapitalVO.setAvailable(available);
					btc38CapitalVO.setEntryOrder(entryOrder);
					btc38CapitalVO.setConfirming(confirming);
					btc38CapitalVO.setCreateTime(date);
					btc38CapitalVO.setCapitalId(capitalId);
					btc38CapitalVO.setCreateTime(date);
					btc38CapitalVO.setEmpty(sum.toString().equals("0.000000"));
					btc38CapitalVO.setCreateTime(date);
					if(!sum.toString().equals("0.000000")){
						capitalList.add(btc38CapitalVO);
					}
				}
				//TODO btc38 平台  账户资产余额加入数据库  后期再实施
			}
		}
		logger.info("getAccountBalance方法  获取btc38平台  账户余额结束：AccountBalance：{}  "+accountBalance);
		return  capitalList;
	}
	
	public static void main(String[] args) {
//		List<Btc38CapitalVO> accountBalance = getAccountBalance();
		
		logger.info("getAccountBalance方法 获取btc38平台  账户余额开始：-------->>>>>>>>>>>>>>>>>>>>");
		Date date = new Date();
		String time= DateCommon.date2Timestamp(date);
		String md5 = MD5.EncoderByMd5(Btc38Constants.PUBLIC_KEY+"_"+Btc38Constants.USERID+"_"+Btc38Constants.SECRET_KEY+"_"+time);
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("key", Btc38Constants.PUBLIC_KEY);
		params.put("time", time);
		params.put("md5", md5);
		String accountBalance = HttpClientUtil.httpPostRequest(Btc38Constants.BTC38_ACCOUNT_BALANCE_URL, params);
		Map map = ObjectConvertUtils.toHashMap(accountBalance);
		List<Btc38CapitalVO> capitalList = new ArrayList<Btc38CapitalVO>();
		if(map != null && !map.isEmpty()){
			//可用资金key list
			List<String> availableList = new ArrayList<String>();
			for(Object key:map.keySet()){
				String btcKey = key.toString();
				if(btcKey.endsWith("_balance")){
					availableList.add(btcKey);
				}
			}
			if(availableList != null && availableList.size() > 0 ){
				for(int i = 0;i<availableList.size();i++){
					Btc38CapitalVO btc38CapitalVO = new Btc38CapitalVO();
					String availableStr = availableList.get(i);
					String capitalName = availableStr.split("_")[0];
					String capitalId = Btc38Constants.PLATFORM+"_"+Btc38Constants.USERID+"_"+capitalName+"_"+DateUtil.getlongTime(date).toString();
					String available = map.get(availableStr) != null?map.get(availableStr).toString():"0.000000";
					String entryOrder = map.get(availableStr+"_lock") != null?map.get(availableStr+"_lock").toString():"0.000000";
					String confirming = map.get(availableStr+"_imma") != null?map.get(availableStr+"_imma").toString():"0.000000";
					Object name = Btc38Constants.currencyNameMap.get(capitalName.toUpperCase());
					BigDecimal sum = ObjectConvertUtils.toBigDecimal(available).add(ObjectConvertUtils.toBigDecimal(entryOrder)).add(ObjectConvertUtils.toBigDecimal(confirming));
					btc38CapitalVO.setSum(sum.toString());
					btc38CapitalVO.setCapitalName(capitalName);
					btc38CapitalVO.setChineseName(name!=null?name.toString():"新加币种");
					btc38CapitalVO.setAvailable(available);
					btc38CapitalVO.setEntryOrder(entryOrder);
					btc38CapitalVO.setConfirming(confirming);
					btc38CapitalVO.setCreateTime(date);
					btc38CapitalVO.setCapitalId(capitalId);
					btc38CapitalVO.setCreateTime(date);
					btc38CapitalVO.setEmpty(sum.toString().equals("0.000000"));
					btc38CapitalVO.setCreateTime(date);
					if(!sum.toString().equals("0.000000")){
						capitalList.add(btc38CapitalVO);
					}
				}
				//TODO btc38 平台  账户资产余额加入数据库  后期再实施
			}
		}
		BigDecimal sum = ObjectConvertUtils.toBigDecimal("0.000000").add(ObjectConvertUtils.toBigDecimal("0.000000"));
		System.out.println(sum );
		System.out.println(sum.toString().equals("0.000000"));
	}
}
