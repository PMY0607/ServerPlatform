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
 * 学校公告评论表
 * 数据库通用操作实体类（普通增删改查）
 * @date 2022-03-01 10:57:52
 */
@TableName("discuss_school_notice")
public class DiscussSchoolNoticeEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public DiscussSchoolNoticeEntity() {
		
	}
	
	public DiscussSchoolNoticeEntity(T t) {
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
	 * 关联表id
	 */
					
	private Long refId;
	
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
	 * 设置：关联表id
	 */
	public void setRefId(Long refId) {
		this.refId = refId;
	}
	/**
	 * 获取：关联表id
	 */
	public Long getRefId() {
		return refId;
	}
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
