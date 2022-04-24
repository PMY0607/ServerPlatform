package com.pmy.platform.entity.model;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 教师
 * 接收传参的实体类
 * 取自ModelAndView 的model名称
 * @date 2022-03-01 10:57:52
 */
@Data
@Builder
@Accessors(chain = true)
public class TeacherModel implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 密码
	 */
	private String password;
		
	/**
	 * 教师姓名
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
	 * 照片
	 */
	private String headPic;
		
	/**
	 * 身份证
	 */
	private String idNumber;
		
	/**
	 * 邮箱
	 */
	private String email;
		
	/**
	 * 住址
	 */
	private String address;
			
}
