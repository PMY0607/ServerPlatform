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
 * 学生成绩
 * 数据库通用操作实体类（普通增删改查）
 * @date 2022-03-01 10:57:52
 */
@TableName("score")
public class ScoreEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ScoreEntity() {
		
	}
	
	public ScoreEntity(T t) {
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
	 * 学号
	 */
					
	private String stuNo;
	
	/**
	 * 姓名
	 */
					
	private String name;
	
	/**
	 * 班级
	 */
					
	private String clazz;
	
	/**
	 * 成绩
	 */
					
	private String score;
	
	/**
	 * 评语
	 */
					
	private String comment;
	
	/**
	 * 教师账号
	 */
					
	private String teacherUsername;
	
	/**
	 * 教师姓名
	 */
					
	private String teacherName;
	
	/**
	 * 登记日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date updateTime;
	
	/**
	 * 家长账号
	 */
					
	private String parentUsername;
	
	/**
	 * 家长姓名
	 */
					
	private String parentName;
	
	
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
	 * 设置：成绩
	 */
	public void setScore(String score) {
		this.score = score;
	}
	/**
	 * 获取：成绩
	 */
	public String getScore() {
		return score;
	}
	/**
	 * 设置：评语
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * 获取：评语
	 */
	public String getComment() {
		return comment;
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
	/**
	 * 设置：登记日期
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：登记日期
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：家长账号
	 */
	public void setParentUsername(String parentUsername) {
		this.parentUsername = parentUsername;
	}
	/**
	 * 获取：家长账号
	 */
	public String getParentUsername() {
		return parentUsername;
	}
	/**
	 * 设置：家长姓名
	 */
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	/**
	 * 获取：家长姓名
	 */
	public String getParentName() {
		return parentName;
	}

}
