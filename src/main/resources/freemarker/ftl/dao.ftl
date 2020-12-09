package ${daoUrl};

import com.xsyx.dms.common.entity.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import ${entityUrl}.dto.${entityName};

/**
 * ${entityComment}数据访问层
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 * @author XiaoQiong
 * @Date ${createTime}
 * 
 */
@Mapper
public interface ${entityName}Mapper extends BaseMapper<${entityName}> {
	
}
	