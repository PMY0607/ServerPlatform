package com.pmy.platform.entity.model;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 学生信息
 * 接收传参的实体类
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
@Data
@Builder
@Accessors(chain = true)
public class StudentModel implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 姓名
	 */
	private String name;
		
	/**
	 * 年龄
	 */
	private Integer age;
		
	/**
	 * 性别
	 */
	private String gender;
		
	/**
	 * 手机
	 */
	private String phone;
		
	/**
	 * 班级
	 */
	private String clazz;
		
	/**
	 * 照片
	 */
	private String headPic;
			
}
