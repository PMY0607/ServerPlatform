package com.pmy.platform.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
 

/**
 * 教师
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeacherVO implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 密码
	 */
	
	private String password;
		
	/**
	 * 教师姓名
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
	 * 照片
	 */
	
	private String headPic;
		
	/**
	 * 身份证
	 */
	
	private String idNumber;
		
	/**
	 * 邮箱
	 */
	
	private String email;
		
	/**
	 * 住址
	 */
	
	private String address;
				
//
//	/**
//	 * 设置：密码
//	 */
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	/**
//	 * 获取：密码
//	 */
//	public String getPassword() {
//		return password;
//	}
//
//
//	/**
//	 * 设置：教师姓名
//	 */
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	/**
//	 * 获取：教师姓名
//	 */
//	public String getName() {
//		return name;
//	}
//
//
//	/**
//	 * 设置：年龄
//	 */
//
//	public void setAge(Integer age) {
//		this.age = age;
//	}
//
//	/**
//	 * 获取：年龄
//	 */
//	public Integer getAge() {
//		return age;
//	}
//
//
//	/**
//	 * 设置：性别
//	 */
//
//	public void setGender(String gender) {
//		this.gender = gender;
//	}
//
//	/**
//	 * 获取：性别
//	 */
//	public String getGender() {
//		return gender;
//	}
//
//
//	/**
//	 * 设置：手机
//	 */
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//
//	/**
//	 * 获取：手机
//	 */
//	public String getPhone() {
//		return phone;
//	}
//
//
//	/**
//	 * 设置：照片
//	 */
//
//	public void setHeadPic(String headPic) {
//		this.headPic = headPic;
//	}
//
//	/**
//	 * 获取：照片
//	 */
//	public String getHeadPic() {
//		return headPic;
//	}
//
//
//	/**
//	 * 设置：身份证
//	 */
//
//	public void setIdNumber(String idNumber) {
//		this.idNumber = idNumber;
//	}
//
//	/**
//	 * 获取：身份证
//	 */
//	public String getIdNumber() {
//		return idNumber;
//	}
//
//
//	/**
//	 * 设置：邮箱
//	 */
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	/**
//	 * 获取：邮箱
//	 */
//	public String getEmail() {
//		return email;
//	}
//
//
//	/**
//	 * 设置：住址
//	 */
//
//	public void setAddress(String address) {
//		this.address = address;
//	}
//
//	/**
//	 * 获取：住址
//	 */
//	public String getAddress() {
//		return address;
//	}
			
}
