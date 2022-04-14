package com.pmy.platform.entity.vo;

import java.io.Serializable;
 

/**
 * 学校公告评论表
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
public class DiscussSchoolNoticeVO implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 用户id
	 */
	
	private Long userId;
		
	/**
	 * 用户名
	 */
	
	private String nickName;
		
	/**
	 * 评论内容
	 */
	
	private String content;
		
	/**
	 * 回复内容
	 */
	
	private String reply;
				
	
	/**
	 * 设置：用户id
	 */
	 
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	/**
	 * 获取：用户id
	 */
	public Long getUserId() {
		return userId;
	}
				
	
	/**
	 * 设置：用户名
	 */
	 
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	/**
	 * 获取：用户名
	 */
	public String getNickName() {
		return nickName;
	}
				
	
	/**
	 * 设置：评论内容
	 */
	 
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 获取：评论内容
	 */
	public String getContent() {
		return content;
	}
				
	
	/**
	 * 设置：回复内容
	 */
	 
	public void setReply(String reply) {
		this.reply = reply;
	}
	
	/**
	 * 获取：回复内容
	 */
	public String getReply() {
		return reply;
	}
			
}
