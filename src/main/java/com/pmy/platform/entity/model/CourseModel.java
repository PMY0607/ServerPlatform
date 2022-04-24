package com.pmy.platform.entity.model;

import java.util.Date;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 课程信息
 * 接收传参的实体类
 * 取自ModelAndView 的model名称
 * @date 2022-03-01 10:57:52
 */
@Data
@Builder
@Accessors(chain = true)
public class CourseModel implements Serializable {
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
			
}
