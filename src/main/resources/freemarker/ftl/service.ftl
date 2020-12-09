package ${serviceUrl};

import ${entityUrl}.dto.${entityName};
import ${entityUrl}.params.${entityName}Params;
import com.github.pagehelper.PageInfo;

/**
 * ${entityComment}服务层
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 * @author XiaoQiong
 * @Date ${createTime}
 */
public interface ${entityName}Service {

    ${entityName} getById(Long id);
    
    boolean save(${entityName} ${objectName});
    
    boolean deleteById(Long id);
    
    boolean updateByEntity(${entityName} ${objectName});
    
    PageInfo getPages(${entityName}Params params);
	
}