package ${controllerUrl};

<#--import ${abstractControllerUrl}.AbstractController;-->
import com.github.pagehelper.PageInfo;
import com.xsyx.dms.common.constant.SwaggerConstant;
import com.xsyx.dms.common.result.CommonResult;
import ${entityUrl}.dto.${entityName};
import ${entityUrl}.params.${entityName}Params;
import ${serviceUrl}.${entityName}Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
<#if isSwagger=="true" >
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;
</#if>
import javax.annotation.Resource;


/**
 * ${entityComment}Controller层
 * @author
 * @Date ${createTime}
 */
<#if isSwagger=="true" >
@Api(value="${entityComment}" )
</#if>
@RestController
@RequestMapping("/${objectName}")
@Slf4j
public class ${entityName}Controller {

    @Resource
    ${entityName}Service ${objectName}Service;

    /**
     * 根据id查询
     */
    @GetMapping("/getById/{id}")
   <#if isSwagger=="true" >
    @ApiOperation(value = "获取对象")
    @ApiImplicitParam(paramType="path", name = "id", value = "对象id", required = true, dataType = "Long")
   </#if>
    public CommonResult<${entityName}> getById(Long id){
        ${entityName} obj= ${objectName}Service.getById(id);
        return null!=obj ? CommonResult.success(obj) : CommonResult.error("查询对象不存在！");
    }


    /**
    * @explain 分页条件查询
    */
    @GetMapping("/getPages")
    @ApiOperation(httpMethod = SwaggerConstant.METHOD_POST, value = "分页查询")
    @ApiImplicitParams({
    <#list cis as ci>
        <#if ci.property!= "createTime" && ci.property!= "updateTime">
        @ApiImplicitParam(name = "${ci.property}", value = "${ci.comment}", paramType = "query", dataType = "${ci.javaType}", required = false),
        </#if>
    </#list>
        @ApiImplicitParam(name = "pageNum", value = "查询页码", paramType = "query", dataType = SwaggerConstant.DATA_INT, required = false),
        @ApiImplicitParam(name = "pageSize", value = "查询一页的数据量", paramType = "query", dataType = SwaggerConstant.DATA_INT, required = false)
    })
    public CommonResult<${entityName}> getPages(<#if isSwagger=="true" >@ApiIgnore</#if> ${entityName}Params params){
        PageInfo result = ${objectName}Service.getPages(params);
        return CommonResult.success(result);
    }

    /**
    * @explain 添加
    */
    @PostMapping("/insert")
    @ApiOperation(httpMethod = SwaggerConstant.METHOD_POST, value = "添加对象")
    @ApiImplicitParams({
    <#list cis as ci>
        <#if ci.property!="id" && ci.property!= "createTime" && ci.property!= "updateTime" && ci.property!= "updatedBy" >
            @ApiImplicitParam(name = "${ci.property}", value = "${ci.comment}", paramType = "query", dataType = "${ci.javaType}", required = false),
        </#if>
    </#list>
    })
    public CommonResult insert(@RequestBody ${entityName} entity){
        if (null!=entity) {
            boolean rsg = ${objectName}Service.save(entity);
            return rsg ? CommonResult.success() : CommonResult.error("添加失败！");
        }else {
            return CommonResult.error("请传入正确参数！");
        }
    }

    /**
     * @explain 删除对象
     */
    @PostMapping("/deleteById")
    @ApiOperation(httpMethod = SwaggerConstant.METHOD_POST,value = "删除对象")
    @ApiImplicitParam(paramType="query", name = "id", value = "对象id", required = true, dataType = "Long")
    public CommonResult deleteById(Long id){
        boolean rsg = ${objectName}Service.deleteById(id);
        return rsg ? CommonResult.success() : CommonResult.error("删除失败！");
    }


    /**
     * @explain 修改
     */
    @PostMapping("/update")
    @ApiOperation(httpMethod = SwaggerConstant.METHOD_POST,value = "修改")
    @ApiImplicitParams({
    <#list cis as ci>
        <#if ci.property!= "createTime" && ci.property!= "updateTime" && ci.property!= "createdBy" >
        @ApiImplicitParam(name = "${ci.property}", value = "${ci.comment}", paramType = "query", dataType = "${ci.javaType}", required = false),
        </#if>
    </#list>
    })
    public CommonResult update(@RequestBody ${entityName} entity){
        if (null!=entity) {
            boolean rsg = ${objectName}Service.updateByEntity(entity);
            return rsg ? CommonResult.success() : CommonResult.error("修改失败！");
        }else {
            return CommonResult.error("请传入正确参数！");
        }
    }









    }