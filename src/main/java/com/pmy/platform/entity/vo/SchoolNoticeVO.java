package com.pmy.platform.entity.vo;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 学校公告
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
public class SchoolNoticeVO implements Serializable {
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
				
	
	/**
	 * 设置：简介
	 */
	 
	public void setBriefIntr(String briefIntr) {
		this.briefIntr = briefIntr;
	}
	
	/**
	 * 获取：简介
	 */
	public String getBriefIntr() {
		return briefIntr;
	}
				
	
	/**
	 * 设置：发布时间
	 */
	 
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	/**
	 * 获取：发布时间
	 */
	public Date getUpdateTime() {
		return updateTime;
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
	 * 设置：内容
	 */
	 
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 获取：内容
	 */
	public String getContent() {
		return content;
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
