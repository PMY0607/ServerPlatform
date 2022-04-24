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
 * 班级信息
 * 数据库通用操作实体类（普通增删改查）
 * @date 2022-03-01 10:57:52
 */
@TableName("clazz")
public class ClazzEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ClazzEntity() {
		
	}
	
	public ClazzEntity(T t) {
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
	 * 班级人数
	 */
					
	private String stuNum;
	
	/**
	 * 位置
	 */
					
	private String location;
	
	/**
	 * 班主任
	 */
					
	private String headTeacher;
	
	/**
	 * 教师姓名
	 */
					
	private String teacherName;
	
	/**
	 * 授课老师
	 */
					
	private String teachers;
	
	/**
	 * 班级学生
	 */
					
	private String students;
	
	/**
	 * 图片
	 */
					
	private String clazzPic;
	
	/**
	 * 班级详情
	 */
					
	private String clazzInfo;
	
	/**
	 * 最近点击时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date clickTime;
	
	/**
	 * 点击次数
	 */
					
	private Integer clickNum;
	
	
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
	 * 设置：班级人数
	 */
	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}
	/**
	 * 获取：班级人数
	 */
	public String getStuNum() {
		return stuNum;
	}
	/**
	 * 设置：位置
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * 获取：位置
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * 设置：班主任
	 */
	public void setHeadTeacher(String headTeacher) {
		this.headTeacher = headTeacher;
	}
	/**
	 * 获取：班主任
	 */
	public String getHeadTeacher() {
		return headTeacher;
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
	 * 设置：授课老师
	 */
	public void setTeachers(String teachers) {
		this.teachers = teachers;
	}
	/**
	 * 获取：授课老师
	 */
	public String getTeachers() {
		return teachers;
	}
	/**
	 * 设置：班级学生
	 */
	public void setStudents(String students) {
		this.students = students;
	}
	/**
	 * 获取：班级学生
	 */
	public String getStudents() {
		return students;
	}
	/**
	 * 设置：图片
	 */
	public void setClazzPic(String clazzPic) {
		this.clazzPic = clazzPic;
	}
	/**
	 * 获取：图片
	 */
	public String getClazzPic() {
		return clazzPic;
	}
	/**
	 * 设置：班级详情
	 */
	public void setClazzInfo(String clazzInfo) {
		this.clazzInfo = clazzInfo;
	}
	/**
	 * 获取：班级详情
	 */
	public String getClazzInfo() {
		return clazzInfo;
	}
	/**
	 * 设置：最近点击时间
	 */
	public void setClickTime(Date clickTime) {
		this.clickTime = clickTime;
	}
	/**
	 * 获取：最近点击时间
	 */
	public Date getClickTime() {
		return clickTime;
	}
	/**
	 * 设置：点击次数
	 */
	public void setClickNum(Integer clickNum) {
		this.clickNum = clickNum;
	}
	/**
	 * 获取：点击次数
	 */
	public Integer getClickNum() {
		return clickNum;
	}

}
