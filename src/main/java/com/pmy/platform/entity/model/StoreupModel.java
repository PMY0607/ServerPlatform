package com.pmy.platform.entity.model;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 收藏表
 * 接收传参的实体类
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
@Data
@Builder
@Accessors(chain = true)
public class StoreupModel  implements Serializable {
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

			
}
