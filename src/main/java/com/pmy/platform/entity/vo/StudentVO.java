package com.pmy.platform.entity.vo;

import java.io.Serializable;
 

/**
 * 学生信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @date 2022-03-01 10:57:52
 */
public class StudentVO implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 姓名
	 */
	
	private String name;
		
	/**
	 * 年龄
	 */
	
	private Integer age;
		
	/**
	 * 性别
	 */
	
	private String gender;
		
	/**
	 * 手机
	 */
	
	private String phone;
		
	/**
	 * 班级
	 */
	
	private String clazz;
		
	/**
	 * 照片
	 */
	
	private String headPic;
				
	
	/**
	 * 设置：姓名
	 */
	 
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
	}
				
	
	/**
	 * 设置：年龄
	 */
	 
	public void setAge(Integer age) {
		this.age = age;
	}
	
	/**
	 * 获取：年龄
	 */
	public Integer getAge() {
		return age;
	}
				
	
	/**
	 * 设置：性别
	 */
	 
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * 获取：性别
	 */
	public String getGender() {
		return gender;
	}
				
	
	/**
	 * 设置：手机
	 */
	 
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * 获取：手机
	 */
	public String getPhone() {
		return phone;
	}
				
	
	/**
	 * 设置：班级
	 */
	 
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	
	/**
	 * 获取：班级
	 */
	public String getClazz() {
		return clazz;
	}
				
	
	/**
	 * 设置：照片
	 */
	 
	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}
	
	/**
	 * 获取：照片
	 */
	public String getHeadPic() {
		return headPic;
	}
			
}
