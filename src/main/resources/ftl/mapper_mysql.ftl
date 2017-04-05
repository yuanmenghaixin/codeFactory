<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- namespace名字必须与Mapper接口名一致 -->
<mapper namespace="${bean.basePackage}.dao.${bean.className}Dao">

    <!-- 查询列表 -->
    <select id="select${bean.className}ByCondition" parameterType="${bean.basePackage}.model.condition.${bean.className}Condition"
            resultType="${bean.basePackage}.model.${bean.className}">
        select * from ${bean.tableName}

        <where>
            <#noparse>siteCode=#{siteCode} </#noparse>
            <#list bean.proList as pro >
            <#if pro.search>
             <if test="${pro.name} !=null and ${pro.name}!=''">
                 ${pro.name} =<#noparse> #{</#noparse>${pro.name}}
             </if>
            </#if>
            </#list>
        </where>
        <#noparse>
        <if test="ordersString != null and ordersString != ''">
            order by ${ordersString}
        </if>
        <if test="startRow != null and numPerPage!=null">
            limit ${startRow-1},${numPerPage}
        </if>
        </#noparse>
    </select>

    <select id="selectCountByCondition" resultType="int">
        select count(1) from ${bean.tableName}
        <where>
            <#noparse>siteCode=#{siteCode} </#noparse>
            <#list bean.proList as pro >
            <#if pro.search>
            <if test="${pro.name} !=null and ${pro.name}!=''">
            ${pro.name} =<#noparse> #{</#noparse>${pro.name}}
            </if>
            </#if>
            </#list>
        </where>

    </select>

    <!-- 查询单条记录 -->
    <select id="select${bean.className}" parameterType="${bean.basePackage}.model.${bean.className}"
            resultType="${bean.basePackage}.model.${bean.className}">
        select * from ${bean.tableName}
        <where>
            <#noparse>siteCode=#{siteCode} </#noparse>
            <#list bean.proList as pro >
                <#if pro.key>
                    and ${pro.name} = <#noparse>#{</#noparse>${pro.name}}
                </#if>
            </#list>
        </where>

    </select>
    <!-- 插入数据 -->
    <insert id="insert${bean.className}" parameterType="${bean.basePackage}.model.${bean.className}">
        insert into ${bean.tableName}
        (
        <#list bean.proList as pro >
        <#if !pro.key>
        ${pro.name},
        </#if>
        </#list>
        createUser,
        createDatetime,
        modifyUser,
        modifyDatetime
        )
        values
        (
        <#list bean.proList as pro >
        <#if !pro.key>
        <#noparse>#{</#noparse>${pro.name},jdbcType=${pro.mybatisType}<#noparse>}</#noparse>,
        </#if>
        </#list>
        <#noparse>
        #{createUser, jdbcType=VARCHAR},
        #{createDateTime,jdbcType=TIMESTAMP},
        #{modifyUser, jdbcType=VARCHAR},
        #{modifyDateTime,jdbcType=TIMESTAMP}
        </#noparse>
        )
    </insert>

    <!-- 修改 -->
    <update id="update${bean.className}" parameterType="${bean.basePackage}.model.${bean.className}">
        update ${bean.tableName} set
        <#list bean.proList as pro >
        <#if !pro.key >
        ${pro.name} = <#noparse>#{</#noparse>${pro.name},jdbcType=${pro.mybatisType}},
        </#if>
        </#list>
        <#noparse>
        modifyUser=#{modifyUser},
        modifyDatetime=#{modifyDateTime,jdbcType=TIMESTAMP}
        </#noparse>
        where <#noparse>siteCode=#{siteCode}</#noparse>
        <#list bean.proList as pro >
        <#if pro.key>
            and ${pro.name} = <#noparse>#{</#noparse>${pro.name}}
        </#if>
        </#list>
    </update>

    <!-- 删除 -->
    <delete id="delete${bean.className}" >
        delete from ${bean.tableName} where <#noparse>siteCode=#{siteCode}</#noparse>
        <#list bean.proList as pro >
            <#if pro.key>
                and ${pro.name} = <#noparse>#{</#noparse>id}
            </#if>
        </#list>
    </delete>

    <cache eviction="FIFO" flushInterval="30000" readOnly="true" size="1024" />
</mapper>