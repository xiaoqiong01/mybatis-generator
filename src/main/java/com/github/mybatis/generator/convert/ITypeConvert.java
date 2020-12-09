/**
 * @author:   
 * @date: 2020年12月9日 上午9:06:16
 */
package com.github.mybatis.generator.convert;

/**
* 说明: 该类的功能描述
* @version: v3.0.0
* @author: 
*
* Modification History:
* Date         		Author          Version          Description
*---------------------------------------------------------------*
* 2020年12月9日      		   v3.0.0           initialize
*/
public interface ITypeConvert {
	/**
     * 说明:执行类型转换
     * @param dateType 	时间类型
     * @param fieldType 字段类型
     * @return ignore
     */
    IColumnType processTypeConvert(DateType dateType , String fieldType);
}
