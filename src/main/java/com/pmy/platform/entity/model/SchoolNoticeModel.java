package com.pmy.platform.entity.model;

import java.util.Date;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 学校公告
 * 接收传参的实体类
 * 取自ModelAndView 的model名称
 * @date 2022-03-01 10:57:52
 */
@Data
@Builder
@Accessors(chain = true)
public class SchoolNoticeModel implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
