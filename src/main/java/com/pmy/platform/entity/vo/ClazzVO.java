package com.pmy.platform.entity.vo;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 班级信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
public class ClazzVO implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
