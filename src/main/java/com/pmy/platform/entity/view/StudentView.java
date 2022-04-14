package com.pmy.platform.entity.view;

import com.pmy.platform.entity.StudentEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 学生信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */
@Data
@Builder
@Accessors(chain = true)
@TableName("student")
public class StudentView extends StudentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public StudentView(){
	}
 
 	public StudentView(StudentEntity studentEntity){
 	try {
			BeanUtils.copyProperties(this, studentEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
