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
 * 说明： 自动生成文件路径
 * @author XiaoQiong
 * @Date ${createTime}
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneratorFileUrl implements Serializable{
	private static final long serialVersionUID = 123125L;

	private String entityUrl;
	 
	private String daoUrl;
	 
	private String mapperUrl;
	 
	private String serviceUrl;
	 
	private String serviceImplUrl;
	 
	private String controllerUrl;
}
