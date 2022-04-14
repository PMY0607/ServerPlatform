package com.pmy.platform.entity.vo;

import java.io.Serializable;
 

/**
 * 收藏表
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
public class StoreupVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
