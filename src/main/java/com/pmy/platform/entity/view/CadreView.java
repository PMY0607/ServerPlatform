package com.pmy.platform.entity.view;

import com.pmy.platform.entity.CadreEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 班干部
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-03-01 10:57:52
 */

@Data
@Builder
@Accessors(chain = true)
@TableName("cadre")
public class CadreView extends CadreEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CadreView(){
	}
 
 	public CadreView(CadreEntity cadreEntity){
 	try {
			BeanUtils.copyProperties(this, cadreEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
