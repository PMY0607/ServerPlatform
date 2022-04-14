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
 * 教师
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
@TableName("teacher")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeacherEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	
	public TeacherEntity(T t) {
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
	 * 教师账号
	 */
					
	private String username;
	
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addTime;


}
