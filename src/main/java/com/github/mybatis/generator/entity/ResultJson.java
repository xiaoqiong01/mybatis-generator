/**
 * @author
 * @Date ${createTime}
 * */
package com.github.mybatis.generator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 说明： 返回结果json对象
 * @author
 * @Date ${createTime}
 * */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultJson implements Serializable{
	
	private static final long serialVersionUID = 123126L;
	
	private Integer code;
	
	private String message;
	
	private Object data;
}
