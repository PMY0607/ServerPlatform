package com.pmy.platform.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;


/**
 * 班干部
 * 数据库通用操作实体类（普通增删改查）
 * @date 2022-03-01 10:57:52
 */
@TableName("cadre")
public class CadreEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public CadreEntity() {
		
	}
	
	public CadreEntity(T t) {
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
	 * 班级
	 */
					
	private String clazz;
	
	/**
	 * 名称
	 */
					
	private String position;
	
	/**
	 * 学号
	 */
					
	private String stuNo;
	
	/**
	 * 姓名
	 */
					
	private String name;
	
	/**
	 * 任职原因
	 */
					
	private String reason;
	
	/**
	 * 教师账号
	 */
					
	private String teacherUsername;
	
	/**
	 * 教师姓名
	 */
					
	private String teacherName;
	
	
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
	 * 设置：名称
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	/**
	 * 获取：名称
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * 设置：学号
	 */
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	/**
	 * 获取：学号
	 */
	public String getStuNo() {
		return stuNo;
	}
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
	 * 设置：任职原因
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	 * 获取：任职原因
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * 设置：教师账号
	 */
	public void setTeacherUsername(String teacherUsername) {
		this.teacherUsername = teacherUsername;
	}
	/**
	 * 获取：教师账号
	 */
	public String getTeacherUsername() {
		return teacherUsername;
	}
	/**
	 * 设置：教师姓名
	 */
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	/**
	 * 获取：教师姓名
	 */
	public String getTeacherName() {
		return teacherName;
	}

}
