/**   
 * Copyright © 2019 dream horse Info. Tech Ltd. All rights reserved.
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * @Package: com.github.mybatis.fl.convert
 * @author: flying-cattle  
 * @date: 2019年4月9日 下午8:06:16 
 */
package com.github.flying.cattle.mdg.convert;

/**   
* Copyright: Copyright (c) 2019 
* 
* 说明: 该类的功能描述
* @version: v3.0.0
* @author: flying-cattle
*
* Modification History:
* Date         		Author          Version          Description
*---------------------------------------------------------------*
* 2019年4月9日      		flying-cattle   v3.0.0           initialize
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
