package ${serviceImplUrl};

import com.github.pagehelper.PageHelper;
import ${entityUrl}.dto.${entityName};
import ${entityUrl}.params.${entityName}Params;
import ${daoUrl}.${entityName}Mapper;
import ${serviceUrl}.${entityName}Service;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * ${entityComment}服务实现层
 * @author
 * @Date ${createTime}
 */
@Service
public class ${entityName}ServiceImpl implements ${entityName}Service  {
    
    @Resource
    ${entityName}Mapper ${objectName}Mapper;
    
    @Override
    public ${entityName} getById(Long id) {
        return ${objectName}Mapper.selectByPrimaryKey(id);
    }
    
    @Override
    public boolean save(${entityName} ${objectName}) {
        return ${objectName}Mapper.insert(${objectName})>0;
    }
    
    @Override
    public boolean deleteById(Long id) {
        ${entityName} ${objectName} = ${objectName}Mapper.selectByPrimaryKey(id);
        if(null == ${objectName}){
            return true;
        }else {
            return ${objectName}Mapper.deleteByPrimaryKey(id)>0;
        }
    }
    
    @Override
    public boolean updateByEntity(${entityName} entity) {
        return ${objectName}Mapper.updateByPrimaryKeySelective(entity)>0;
    }
    
    @Override
    public PageInfo getPages(${entityName}Params params) {
        PageHelper.startPage(params.getPageNum(),params.getPageSize());
        List<${entityName}> ${objectName}s=${objectName}Mapper.select(params);
        return new PageInfo<>(${objectName}s);
    }
}