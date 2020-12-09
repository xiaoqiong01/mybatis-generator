/**
 * @author XiaoQiong
 * @Date ${createTime}
 * */
package com.github.mybatis.generator.convert;

/**
 * @author XiaoQiong
 * @Date ${createTime}
 * */
public enum DateType {
    /**
     * 
     * 只使用 java.util.date 代替
     */
    ONLY_DATE,
    /**
     * 使用 java.sql 包下的
     */
    SQL_PACK,
    /**
     * 使用 java.time 包下的
     * java8 新的时间类型
     */
    TIME_PACK
}

