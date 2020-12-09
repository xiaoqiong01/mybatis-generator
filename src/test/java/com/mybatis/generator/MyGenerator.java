/**
 * @filename:UserController 2019年4月9日
 * @project wallet-manage  V1.0
 * Copyright(c) 2018 flying-cattle Co. Ltd. 
 * All right reserved. 
 */
package com.mybatis.generator;

import com.github.mybatis.generator.entity.BasisInfo;
import com.github.mybatis.generator.util.EntityInfoUtil;
import com.github.mybatis.generator.util.Generator;
import com.github.mybatis.generator.util.MySqlToJavaUtil;

import java.sql.SQLException;
import java.util.Date;

public class MyGenerator {
		// 基础信息：项目名、作者、版本
		public static final String PROJECT = "archery";
		public static final String AUTHOR = "xiaoqiong";
		public static final String VERSION = "V1.0";
		// 数据库连接信息：连接URL、用户名、秘密、数据库名information_schema
//		public static final String URL = "jdbc:mysql://172.16.7.227:3306/?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&failOverReadOnly=false&useSSL=true&serverTimezone=UTC";
		public static final String URL = "jdbc:mysql://172.16.7.227:3306/JAcheryTest?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&failOverReadOnly=false&useSSL=true&serverTimezone=UTC";
		public static final String NAME = "lookup";
		public static final String PASS = "lookup@2018frxs";
		public static final String DATABASE = "JAcheryTest";
		// 类信息：类名、对象名（一般是【类名】的首字母小些）、类说明、时间
		//public static final String CLASSNAME = "";
		public static final String TABLE = "t_ins_info";
		public static final String CLASSCOMMENT = "实例信息";
		public static final String TIME = "2020年12月8日";
		public static final String AGILE = new Date().getTime() + "";
		// 路径信息，分开路径方便聚合工程项目，微服务项目
		public static final String ENTITY_URL = "com.xsyx.dms.dbinstance.domain";
		public static final String DAO_URL = "com.xsyx.dms.dbinstance.mapper";
		public static final String XML_URL = "com.xsyx.dms.dbinstance.mapper.impl";
		public static final String SERVICE_URL = "com.xsyx.dms.dbinstance.service";
		public static final String SERVICE_IMPL_URL = "com.xsyx.dms.dbinstance.service.impl";
		public static final String CONTROLLER_URL = "com.xsyx.dms.dbinstance.controller";
		//是否是Swagger配置
		public static final String IS_SWAGGER = "true";
//	    public static final String IS_SWAGGER = "false";
		
	public static void main(String[] args) {
		BasisInfo bi = new BasisInfo(PROJECT, AUTHOR, VERSION, URL, NAME, PASS, DATABASE, TIME, AGILE, ENTITY_URL,
				DAO_URL, XML_URL, SERVICE_URL, SERVICE_IMPL_URL, CONTROLLER_URL,IS_SWAGGER);
		bi.setTable(TABLE);
		bi.setEntityName(MySqlToJavaUtil.getClassName(TABLE));
		bi.setObjectName(MySqlToJavaUtil.changeToJavaFiled(TABLE));
		bi.setEntityComment(CLASSCOMMENT);
		try {
			bi = EntityInfoUtil.getInfo(bi);
			String fileUrl = "D:\\自动生成代码\\实例信息\\";// 生成文件存放位置
			//开始生成文件
			String aa1 = Generator.createEntity(fileUrl, bi).toString();
			String aa2 = Generator.createDao(fileUrl, bi).toString();
			String aa3 = Generator.createDaoImpl(fileUrl, bi).toString();
			String aa4 = Generator.createService(fileUrl, bi).toString();
			String aa5 = Generator.createServiceImpl(fileUrl, bi).toString();
			String aa6 = Generator.createController(fileUrl, bi).toString();
			String aa7 = Generator.createParams(fileUrl, bi).toString();
			String aa8 = Generator.createExample(fileUrl, bi).toString();
			// 是否创建swagger配置文件
			String aa9 = Generator.createSwaggerConfig(fileUrl, bi).toString();
			
			System.out.println(aa1);
			System.out.println(aa2);
			System.out.println(aa3);
			System.out.println(aa4);
			System.out.println(aa5);
			System.out.println(aa6);
			System.out.println(aa7);
			System.out.println(aa8);
			System.out.println(aa9);
			
			//System.out.println(aa7);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
