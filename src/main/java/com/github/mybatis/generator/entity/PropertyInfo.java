/**
 * @author XiaoQiong
 * @Date ${createTime}
 * */
package com.github.mybatis.generator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 说明： 获取到数据库的信息
 * @author XiaoQiong
 * @Date ${createTime}
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyInfo implements Serializable{
	
	private static final long serialVersionUID = 123124L;
	
	private String column;

	private String jdbcType;
	 
	private String comment;
	 
	private String property;
	 
	private String javaType;

	private String daxieproperty;
}
