/**
 * @author
 * @Date ${createTime}
 * */
package com.github.mybatis.generator.convert;

/**
 * @author
 * @Date ${createTime}
 **/
public interface IColumnType {
	/**
     * 获取字段类型
     *
     * @return 字段类型
     */
    String getType();

    /**
     *  获取字段类型完整名
     *
     * @return 字段类型完整名
     */
    String getPkg();
}
