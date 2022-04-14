package com.pmy.platform.entity.model;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 班干部
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
public class CadreModel implements Serializable {
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
}
