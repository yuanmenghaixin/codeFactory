package ${bean.basePackage}.service;

import ${bean.basePackage}.model.${bean.className};
import ${bean.basePackage}.model.condition.${bean.className}Condition;

import java.util.List;

/**
* Created by codeFactory on ${bean.createDate?string("yyyy-MM-dd HH:mm:ss")}.
*/
public interface ${bean.className}Service {

    /**
    * @param condition
    * @return
    */
    List<${bean.className}> select${bean.className}ByCondition(${bean.className}Condition condition);

    /**
    * 查询记录数
    * @param condition
    * @return
    */
    int selectCountByCondition(${bean.className}Condition condition);

    /**
    * 查询信息
    * @param condition
    * @return
    */
    ${bean.className} select${bean.className}(${bean.className} condition);

    /**
    * 保存信息
    * @param spot
    */
    void insert${bean.className}(${bean.className} ${bean.className?uncap_first});

    /**
    * 更新信息
    * @param spot
    */
    void update${bean.className}(${bean.className} ${bean.className?uncap_first});

    /**
    * 删除信息
    */
    void delete${bean.className}(String siteCode,String ids);


}
