package com.pmy.platform.entity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
 

/**
 * 家长
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ParentModel implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 密码
	 */
	private String password;
		
	/**
	 * 家长姓名
	 */
	private String name;
		
	/**
	 * 性别
	 */
	private String gender;
		
	/**
	 * 年龄
	 */
	private Integer age;
		
	/**
	 * 头像
	 */
	private String headPic;
		
	/**
	 * 手机
	 */
	private String phone;
		
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
