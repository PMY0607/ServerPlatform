package com.pmy.platform.entity.model;

import java.util.Date;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 学生成绩
 * 接收传参的实体类
 * 取自ModelAndView 的model名称
 * @date 2022-03-01 10:57:52
 */
@Data
@Builder
@Accessors(chain = true)
public class ScoreModel implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
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
			
}
