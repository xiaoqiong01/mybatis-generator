package ${serviceUrl};

import ${entityUrl}.dto.${entityName};
import ${entityUrl}.params.${entityName}Params;
import com.github.pagehelper.PageInfo;

/**
 * ${entityComment}服务层
 * @author
 * @Date ${createTime}
 */
public interface ${entityName}Service {

    ${entityName} getById(Long id);
    
    boolean save(${entityName} ${objectName});
    
    boolean deleteById(Long id);
    
    boolean updateByEntity(${entityName} ${objectName});
    
    PageInfo getPages(${entityName}Params params);
	
}