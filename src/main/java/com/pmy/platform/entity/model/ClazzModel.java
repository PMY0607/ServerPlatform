package com.pmy.platform.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * 班级信息 接收传参的实体类 取自ModelAndView 的model名称
 *
 * @date 2022-03-01 10:57:52
 */
@Data
@Builder
@Accessors(chain = true)
public class ClazzModel implements Serializable {

  private static final long serialVersionUID = 1L;


  /**
   * 班级人数
   */

  private String stuNum;

  /**
   * 位置
   */

  private String location;

  /**
   * 班主任
   */

  private String headTeacher;

  /**
   * 教师姓名
   */

  private String teacherName;

  /**
   * 授课老师
   */

  private String teachers;

  /**
   * 班级学生
   */
  private String students;

  /**
   * 图片
   */
  private String clazzPic;

  /**
   * 班级详情
   */
  private String clazzInfo;

  /**
   * 最近点击时间
   */
  @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
  @DateTimeFormat
  private Date clickTime;

  /**
   * 点击次数
   */
  private Integer clickNum;

}
