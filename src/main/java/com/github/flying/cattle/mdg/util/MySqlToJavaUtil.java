/**
 * @author XiaoQiong
 * @Date ${createTime}
 * */
package com.github.flying.cattle.mdg.util;

import com.github.flying.cattle.mdg.convert.DateType;
import com.github.flying.cattle.mdg.convert.MySqlTypeConvert;
/**
 * 说明： 获取java中需要的驼峰命名
 * @author XiaoQiong
 * @Date ${createTime}
 * */
public class MySqlToJavaUtil {
	
	/**
     * 说明:获取java类名
     * @param table  表名
     * @return String
     */
	public static String getClassName(String table) {
		if(table.startsWith("t_")){
			table = table.substring(2);
		}
		table=changeToJavaFiled(table);
		StringBuilder sbuilder = new StringBuilder();
		char[] cs = table.toCharArray();
		cs[0] -= 32;
		sbuilder.append(String.valueOf(cs));
		return sbuilder.toString();
	}
	
	/**
     * 说明:获取字段名，把"_"后面字母变大写
     * @param field  字段名
     * @return String
     */
	public static String changeToJavaFiled(String field) {
		if(field.startsWith("t_")){
			field = field.substring(2);
		}
		String[] fields = field.split("_");
		StringBuilder sbuilder = new StringBuilder(fields[0]);
		for (int i = 1; i < fields.length; i++) {
			char[] cs = fields[i].toCharArray();
			cs[0] -= 32;
			sbuilder.append(String.valueOf(cs));
		}
		return sbuilder.toString();
	}

	/**
	 * 说明:获取字段名，第一个字母大写，并且把"_"后面字母变大写
	 * @param field  字段名
	 * @return String
	 */
	public static String changeToDaxiwJavaFiled(String field) {
		if(field.startsWith("t_")){
			field = field.substring(2);
		}
		String[] fields = field.split("_");
		StringBuilder sbuilder = new StringBuilder(fields[0] += 32);
		for (int i = 1; i < fields.length; i++) {
			char[] cs = fields[i].toCharArray();
			cs[0] -= 32;
			sbuilder.append(String.valueOf(cs));
		}
		return sbuilder.toString();
	}
	

	/**
     * 说明:把sql的数据类型转为java需要的类型
     * @param sqlType  sql类型
     * @return String  java类型
     */
	public static String jdbcTypeToJavaType(String sqlType) {
		MySqlTypeConvert typeConvert= new MySqlTypeConvert();
		//return typeConvert.processTypeConvert(DateType.ONLY_DATE, sqlType).getType();
		return typeConvert.processTypeConvert(DateType.TIME_PACK, sqlType).getType();
	}
	
	/**
     * 说明:把sql的数据类型转为java需要的类型
     * @param sqlType  sql类型
     * @return String  java类型
     */
	public static String jdbcTypeToJavaTypePck(String sqlType) {
		MySqlTypeConvert typeConvert= new MySqlTypeConvert();
		//return typeConvert.processTypeConvert(DateType.ONLY_DATE, sqlType).getPkg();
		return typeConvert.processTypeConvert(DateType.TIME_PACK, sqlType).getPkg();
	}
}
