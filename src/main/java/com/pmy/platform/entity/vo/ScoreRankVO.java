package com.pmy.platform.entity.vo;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 成绩排名
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
public class ScoreRankVO implements Serializable {
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
	 * 单科成绩
	 */
	
	private String score;
		
	/**
	 * 单科排名
	 */
	
	private String scoreRank;
		
	/**
	 * 总成绩
	 */
	
	private String totalScore;
		
	/**
	 * 总排名
	 */
	
	private String totalRank;
		
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
	 * 设置：单科成绩
	 */
	 
	public void setScore(String score) {
		this.score = score;
	}
	
	/**
	 * 获取：单科成绩
	 */
	public String getScore() {
		return score;
	}
				
	
	/**
	 * 设置：单科排名
	 */
	 
	public void setScoreRank(String scoreRank) {
		this.scoreRank = scoreRank;
	}
	
	/**
	 * 获取：单科排名
	 */
	public String getScoreRank() {
		return scoreRank;
	}
				
	
	/**
	 * 设置：总成绩
	 */
	 
	public void setTotalScore(String totalScore) {
		this.totalScore = totalScore;
	}
	
	/**
	 * 获取：总成绩
	 */
	public String getTotalScore() {
		return totalScore;
	}
				
	
	/**
	 * 设置：总排名
	 */
	 
	public void setTotalRank(String totalRank) {
		this.totalRank = totalRank;
	}
	
	/**
	 * 获取：总排名
	 */
	public String getTotalRank() {
		return totalRank;
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
