package ${entityUrl}.dto;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
<#if isSwagger=="true" >
import io.swagger.annotations.ApiModelProperty;
</#if>
import com.xsyx.commons.entity.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import javax.persistence.*;
<#list pkgs as ps>
	<#if ps??>
import ${ps};
	</#if>
</#list>

/**
 * ${entityComment}实体类
 * @author
 * @Date ${createTime}
 */
@Data
@ApiModel
@Accessors(chain = true)
@Table(name = "${table}")
public class ${entityName}{
	
<#list cis as ci>
 <#--<#if ci.javaType=="Date">
  <#if ci.jdbcType=="date">
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
  <#elseif ci.jdbcType=="time">
    @DateTimeFormat(pattern = "HH:mm:ss")
	@JsonFormat(pattern="HH:mm:ss",timezone = "GMT+8")
  <#else>
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  </#if>
 </#if>-->
 <#if ci.property=="id">
    @Id
 </#if>
 <#if isSwagger=="true" >
     <#if ci.property != ci.column>
    @Column(name = "${ci.column}")
     </#if>
	@ApiModelProperty("${ci.comment}")
 </#if>
	private ${ci.javaType} ${ci.property};

</#list>

}
