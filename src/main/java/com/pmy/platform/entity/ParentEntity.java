package com.pmy.platform.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;


/**
 * 家长
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
@TableName("parent")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ParentEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	
	public ParentEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 家长账号
	 */
					
	private String username;
	
	/**
	 * 密码
	 */
					
	private String password;
	
	/**
	 * 家长姓名
	 */
					
	private String name;
	
	/**
	 * 性别
	 */
					
	private String gender;
	
	/**
	 * 年龄
	 */
					
	private Integer age;
	
	/**
	 * 头像
	 */
					
	private String headPic;
	
	/**
	 * 手机
	 */
					
	private String phone;
	
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addTime;

	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：家长账号
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：家长账号
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：家长姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：家长姓名
	 */
	public String getName() {
		return name;
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
	 * 设置：头像
	 */
	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}
	/**
	 * 获取：头像
	 */
	public String getHeadPic() {
		return headPic;
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
	 * 设置：身份证
	 */
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	/**
	 * 获取：身份证
	 */
	public String getIdNumber() {
		return idNumber;
	}
	/**
	 * 设置：邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：住址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：住址
	 */
	public String getAddress() {
		return address;
	}

}
