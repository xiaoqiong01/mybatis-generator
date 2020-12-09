/**
 * @author XiaoQiong
 * @Date ${createTime}
 * */
package com.github.flying.cattle.mdg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 说明： 返回结果json对象
 * @author XiaoQiong
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
