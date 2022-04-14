package com.pmy.platform.entity.model;

import java.util.Date;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 成绩排名
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
public class ScoreRankModel implements Serializable {
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
			
}
