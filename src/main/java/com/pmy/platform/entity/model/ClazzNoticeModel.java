package com.pmy.platform.entity.model;

import java.util.Date;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 班级公告
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
@Data
@Builder
@Accessors(chain = true)
public class ClazzNoticeModel implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 班级
	 */
	private String clazz;
		
	/**
	 * 简介
	 */
	private String briefIntr;
		
	/**
	 * 发布时间
	 */
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date updateTime;
		
	/**
	 * 封面
	 */
	private String cover;
		
	/**
	 * 内容
	 */
	private String content;
		
	/**
	 * 教师账号
	 */
	private String teacherUsername;
		
	/**
	 * 教师姓名
	 */
	private String teacherName;
		
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
