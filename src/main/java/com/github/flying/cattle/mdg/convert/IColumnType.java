/**
 * @author XiaoQiong
 * @Date ${createTime}
 * */
package com.github.flying.cattle.mdg.convert;

/**
 * @author XiaoQiong
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
