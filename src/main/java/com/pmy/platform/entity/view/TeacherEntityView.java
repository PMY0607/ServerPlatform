package com.pmy.platform.entity.view;

import com.pmy.platform.entity.TeacherEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 教师
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
@Data
@Builder
@Accessors(chain = true)
@TableName("teacher")
public class TeacherEntityView extends TeacherEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TeacherEntityView(){
	}
 
 	public TeacherEntityView(TeacherEntity teacher){
 	try {
			BeanUtils.copyProperties(this, teacher);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
