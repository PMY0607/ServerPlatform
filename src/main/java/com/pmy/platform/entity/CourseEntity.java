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
 * 课程信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
@TableName("course")
public class CourseEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public CourseEntity() {
		
	}
	
	public CourseEntity(T t) {
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
	 * 课程名称
	 */
					
	private String courseName;
	
	/**
	 * 科目名称
	 */
					
	private String subjectName;
	
	/**
	 * 开课时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date startTime;
	
	/**
	 * 结束时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date endTime;
	
	/**
	 * 课程内容
	 */
					
	private String content;
	
	/**
	 * 封面
	 */
					
	private String cover;
	
	/**
	 * 教师账号
	 */
					
	private String teacherUsername;
	
	/**
	 * 教师姓名
	 */
					
	private String teacherName;
	
	/**
	 * 赞
	 */
					
	private Integer thumbsUpNum;
	
	/**
	 * 踩
	 */
					
	private Integer crazilyNum;
	
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
	 * 设置：课程名称
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/**
	 * 获取：课程名称
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * 设置：科目名称
	 */
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	/**
	 * 获取：科目名称
	 */
	public String getSubjectName() {
		return subjectName;
	}
	/**
	 * 设置：开课时间
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：开课时间
	 */
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * 设置：结束时间
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：结束时间
	 */
	public Date getEndTime() {
		return endTime;
	}
	/**
	 * 设置：课程内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：课程内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：封面
	 */
	public void setCover(String cover) {
		this.cover = cover;
	}
	/**
	 * 获取：封面
	 */
	public String getCover() {
		return cover;
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
	 * 设置：赞
	 */
	public void setThumbsUpNum(Integer thumbsUpNum) {
		this.thumbsUpNum = thumbsUpNum;
	}
	/**
	 * 获取：赞
	 */
	public Integer getThumbsUpNum() {
		return thumbsUpNum;
	}
	/**
	 * 设置：踩
	 */
	public void setCrazilyNum(Integer crazilyNum) {
		this.crazilyNum = crazilyNum;
	}
	/**
	 * 获取：踩
	 */
	public Integer getCrazilyNum() {
		return crazilyNum;
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
