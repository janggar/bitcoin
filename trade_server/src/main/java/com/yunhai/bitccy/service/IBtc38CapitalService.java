package com.yunhai.bitccy.service;

import java.util.List;

import com.yunhai.vo.Btc38CapitalVO;

/**
 * 
 * @description btc38平台 资产业务相关接口
 * @className: IBtc38CapitalService 
 * @author Jiayanxing
 * @time 2017年5月24日  下午6:26:06
 */
public interface IBtc38CapitalService {


	/**
	 * 
	 * @description 获取账户余额资产列表
	 * @return List<Btc38CapitalVO>
	 */
	public List<Btc38CapitalVO> getAccountBalance();
}
