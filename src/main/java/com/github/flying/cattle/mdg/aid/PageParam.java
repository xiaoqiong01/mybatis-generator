/**
 * @author XiaoQiong
 * @Date ${createTime}
 *
 */
package com.github.flying.cattle.mdg.aid;

import java.io.Serializable;

import lombok.Data;

/**
 * app分页组件
 * @author XiaoQiong
 * @Date ${createTime}
 * */
@Data
public class PageParam<T>  implements Serializable{
	
	private static final long serialVersionUID = -7248374800878487522L;
	/**
     * 当前页
     */
    private int pageNum=1;
    /**
     * 每页记录数
     */
    private int pageSize=10;

    /**
     * 分页外的其它参数
     */
    private T param;
    
}
