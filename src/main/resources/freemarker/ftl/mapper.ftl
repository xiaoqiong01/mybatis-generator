<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${daoUrl}.${entityName}Mapper">

	<resultMap id="BaseResultMap" type="${entityUrl}.dto.${entityName}">
		<#list cis as ci>
			<id column="${ci.column}"  jdbcType="${ci.daxieJdbcType}" property="${ci.property}"/>
		</#list>
	</resultMap>
	<sql id="Base_Column_List">
		${agile}
	</sql>

	<insert id="insert" parameterType="${entityUrl}">
		<SELECTKey keyProperty="id" resultType="java.lang.Long" order="AFTER" >
			SELECT LAST_INSERT_ID() AS id
		</SELECTKey>
		INSERT INTO ${table}
		<trim prefix="(" suffix=")" suffixOverrides=",">
		<#list cis as ci>
			<if test="${ci.property} != null ">
				${ci.column},
			</if>
		</#list>
		</trim>
		<trim prefix="VALUES (" suffix=")" suffixOverrides=",">
		<#list cis as ci>
			<if test="${ci.property} != null ">
				<#noparse>#{</#noparse>${ci.property},jdbcType=${ci.daxieJdbcType}<#noparse>}</#noparse>,
			</if>
		</#list>
		</trim>
	</insert>

	<insert id="insertBatch">
		INSERT INTO ${table}
		(<#list cis as ci>
		<#if ci.column != "UPDATEd_by" && ci.column != "create_time" && ci.column != "UPDATE_time" >${ci.column},</#if></#list>)
		VALUES
		<foreach collection="list" item="item" separator=",">
		(<#list cis as ci>
		<#if ci.column != "UPDATEd_by" && ci.column != "create_time" && ci.column != "UPDATE_time" ><#noparse>#{item.</#noparse>${ci.property},jdbcType=${ci.daxieJdbcType}<#noparse>}</#noparse>,</#if></#list>)
		</foreach>
	</insert>

	<UPDATE id="UPDATEById" parameterType="${entityUrl}">
		UPDATE ${table}
		<set>
		<#list cis as ci>
			${ci.column} = <#noparse>#{</#noparse>${ci.property},jdbcType=${ci.daxieJdbcType}<#noparse>}</#noparse>
		</#list>
		</set>
		WHERE id = <#noparse>#{</#noparse>id,jdbcType=BIGINT<#noparse>}</#noparse>
	</UPDATE>

	<DELETE id="DELETEById" parameterType="java.lang.Integer">
		DELETE FROM ${table}
		WHERE id = <#noparse>#{</#noparse>id,jdbcType=BIGINT<#noparse>}</#noparse>
	</DELETE>

	<SELECT id="SELECTAll" resultMap="BaseResultMap">
		SELECT
		<include refid="Base_Column_List" />
		FROM ${table}
	</SELECT>

	<SELECT id="SELECTById" flushCache="true" parameterType="java.lang.Long" resultMap="BaseResultMap">
		SELECT
		<include refid="Base_Column_List" />
		FROM ${table}
		WHERE id = <#noparse>#{</#noparse>id,jdbcType=BIGINT<#noparse>}</#noparse>
	</SELECT>

	<SELECT id="SELECTByEntity" parameterType="${entityUrl}" resultMap="BaseResultMap">
		SELECT
		<include refid="Base_Column_List" />
		FROM ${table}
		WHERE 1=1
	<#list cis as ci>
		<#if ci.daxieJdbcType != "VARCHAR">
			<if test="${ci.property} != null ">
				AND ${ci.column} = <#noparse>#{</#noparse>${ci.property},jdbcType=${ci.daxieJdbcType}<#noparse>}</#noparse>
			</if>
		</#if>
		<#if ci.daxieJdbcType == "VARCHAR">
			<if test="${ci.property} != null and ${ci.property} !='' ">
				AND ${ci.column} = <#noparse>#{</#noparse>${ci.property},jdbcType=${ci.daxieJdbcType}<#noparse>}</#noparse>
			</if>
		</#if>
	</#list>
	</SELECT>

	<SELECT id="SELECTOne" parameterType="${entityUrl}" resultMap="BaseResultMap">
		SELECT
		<include refid="Base_Column_List" />
		FROM ${table}
		WHERE 1=1
	<#list cis as ci>
		<#if ci.daxieJdbcType != "VARCHAR">
			<if test="${ci.property} != null ">
				AND ${ci.column} = <#noparse>#{</#noparse>${ci.property},jdbcType=${ci.daxieJdbcType}<#noparse>}</#noparse>
			</if>
		</#if>
		<#if ci.daxieJdbcType == "VARCHAR">
			<if test="${ci.property} != null and ${ci.property} !='' ">
				AND ${ci.column} = <#noparse>#{</#noparse>${ci.property},jdbcType=${ci.daxieJdbcType}<#noparse>}</#noparse>
			</if>
		</#if>
	</#list>
		LIMIT 1
	</SELECT>




</mapper>