package com.yunhai;

/**
 * 测试spring 使用 类
 * @author Jiayanxing
 * @date 2017年1月24日 上午11:51:41
 */
public class PersonTest {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void printName(){
		System.out.println(name);
	}
}
