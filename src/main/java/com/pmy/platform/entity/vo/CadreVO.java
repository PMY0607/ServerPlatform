package com.pmy.platform.entity.vo;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 班干部
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
@Data
@Builder
@Accessors(chain = true)
public class CadreVO implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 名称
	 */
	
	private String position;
		
	/**
	 * 学号
	 */
	
	private String stuNo;
		
	/**
	 * 姓名
	 */
	
	private String name;
		
	/**
	 * 任职原因
	 */
	
	private String reason;
		
	/**
	 * 教师账号
	 */
	
	private String teacherUsername;
		
	/**
	 * 教师姓名
	 */
	
	private String teacherName;
				
	
	/**
	 * 设置：名称
	 */
	 
	public void setPosition(String position) {
		this.position = position;
	}
	
	/**
	 * 获取：名称
	 */
	public String getPosition() {
		return position;
	}
				
	
	/**
	 * 设置：学号
	 */
	 
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	
	/**
	 * 获取：学号
	 */
	public String getStuNo() {
		return stuNo;
	}
				
	
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
	 * 设置：任职原因
	 */
	 
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	/**
	 * 获取：任职原因
	 */
	public String getReason() {
		return reason;
	}
				
	
	/**
	 * 设置：教师账号
	 */
	 
	public void setTeacherUsername(String teacherUsername) {
		this.teacherUsername = teacherUsername;
	}
	
	/**
	 * 获取：教师账号
	 */
	public String getTeacherUsername() {
		return teacherUsername;
	}
				
	
	/**
	 * 设置：教师姓名
	 */
	 
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	/**
	 * 获取：教师姓名
	 */
	public String getTeacherName() {
		return teacherName;
	}
			
}
