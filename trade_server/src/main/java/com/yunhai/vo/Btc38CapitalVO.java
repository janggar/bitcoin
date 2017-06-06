package com.yunhai.vo;

import java.io.Serializable;
import java.util.Date;

import com.yunhai.constants.Btc38Constants;

/**
 * 
 * @description  btc38 平台 各种资产对象
 * @className: Btc38CapitalVO 
 * @author Jiayanxing
 * @time 2017年5月22日  下午6:49:32
 */
public class Btc38CapitalVO implements Serializable{

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 23167421537840239L;

	private String platform = Btc38Constants.PLATFORM;//资金所属平台
	private String userId =  Btc38Constants.USERID;//用户id
	private String capitalId;//该资产唯一标识
	private String capitalName;//资金英文别名
	private String chineseName;//资金中文名
	private String available;//可用资金
	private String entryOrder;//挂单资金
	private String confirming;//确认中资金
	private String sum;//总资金
	private boolean isEmpty = false;//该资产是否为空
	private Date createTime;//该资产创建时间
	private Date updateTime;//该资产更新时间
	
	
	public String getCapitalId() {
		return capitalId;
	}
	public void setCapitalId(String capitalId) {
		this.capitalId = capitalId;
	}
	public boolean isEmpty() {
		return isEmpty;
	}
	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCapitalName() {
		return capitalName;
	}
	public void setCapitalName(String capitalName) {
		this.capitalName = capitalName;
	}
	public String getChineseName() {
		return chineseName;
	}
	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	public String getEntryOrder() {
		return entryOrder;
	}
	public void setEntryOrder(String entryOrder) {
		this.entryOrder = entryOrder;
	}
	public String getConfirming() {
		return confirming;
	}
	public void setConfirming(String confirming) {
		this.confirming = confirming;
	}
	public String getSum() {
		return sum;
	}
	public void setSum(String sum) {
		this.sum = sum;
	}
	
	
}
