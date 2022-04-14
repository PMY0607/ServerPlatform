package com.pmy.platform.entity.vo;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 课程信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
public class CourseVO implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
