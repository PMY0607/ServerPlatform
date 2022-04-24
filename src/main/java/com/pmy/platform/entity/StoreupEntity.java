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
 * 收藏表
 * 数据库通用操作实体类（普通增删改查）
 * @date 2022-03-01 10:57:52
 */
@TableName("storeup")
public class StoreupEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public StoreupEntity() {
		
	}
	
	public StoreupEntity(T t) {
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
	 * 用户id
	 */
					
	private Long userId;
	
	/**
	 * 收藏id
	 */
					
	private Long refId;
	
	/**
	 * 表名
	 */
					
	private String tableName;
	
	/**
	 * 收藏名称
	 */
					
	private String name;
	
	/**
	 * 收藏图片
	 */
					
	private String picture;
	
	/**
	 * 类型(1:收藏,21:赞,22:踩)
	 */
					
	private String type;
	
	/**
	 * 推荐类型
	 */
	private String inteltype;
	
	
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
	 * 设置：收藏id
	 */
	public void setRefId(Long refId) {
		this.refId = refId;
	}
	/**
	 * 获取：收藏id
	 */
	public Long getRefId() {
		return refId;
	}
	/**
	 * 设置：表名
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	/**
	 * 获取：表名
	 */
	public String getTableName() {
		return tableName;
	}
	/**
	 * 设置：收藏名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：收藏名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：收藏图片
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}
	/**
	 * 获取：收藏图片
	 */
	public String getPicture() {
		return picture;
	}
	/**
	 * 设置：类型(1:收藏,21:赞,22:踩)
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型(1:收藏,21:赞,22:踩)
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：推荐类型
	 */
	public void setInteltype(String inteltype) {
		this.inteltype = inteltype;
	}
	/**
	 * 获取：推荐类型
	 */
	public String getInteltype() {
		return inteltype;
	}

}
