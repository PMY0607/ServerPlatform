package com.pmy.platform.entity.model;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 学校公告评论表
 * 接收传参的实体类
 * 取自ModelAndView 的model名称
 * @date 2022-03-01 10:57:52
 */
@Data
@Builder
@Accessors(chain = true)
public class DiscussSchoolNoticeModel implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 用户id
	 */
	private Long userId;
		
	/**
	 * 用户名
	 */
	private String nickname;
		
	/**
	 * 评论内容
	 */
	private String content;
		
	/**
	 * 回复内容
	 */
	private String reply;

}
