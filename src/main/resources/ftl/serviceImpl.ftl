package ${bean.basePackage}.service.impl;


import ${bean.basePackage}.dao.${bean.className}Dao;
import ${bean.basePackage}.model.${bean.className};
import ${bean.basePackage}.model.condition.${bean.className}Condition;
import ${bean.basePackage}.service.${bean.className}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Created by codeFactory on ${bean.createDate?string("yyyy-MM-dd HH:mm:ss")}.
*/
@Service
public class ${bean.className}ServiceImpl implements ${bean.className}Service{

    @Autowired
    private ${bean.className}Dao ${bean.className?uncap_first}Dao;


    @Override
    public List<${bean.className}> select${bean.className}ByCondition(${bean.className}Condition condition) {
        return ${bean.className?uncap_first}Dao.select${bean.className}ByCondition(condition);
    }

    @Override
    public int selectCountByCondition(${bean.className}Condition condition) {
        return ${bean.className?uncap_first}Dao.selectCountByCondition(condition);
    }

    @Override
    public ${bean.className} select${bean.className}(${bean.className} condition) {
        return ${bean.className?uncap_first}Dao.select${bean.className}(condition);
    }

    @Override
    public void insert${bean.className}(${bean.className} ${bean.className?uncap_first}) {
        ${bean.className?uncap_first}Dao.insert${bean.className}(${bean.className?uncap_first});
    }

    @Override
    public void update${bean.className}(${bean.className} ${bean.className?uncap_first}) {
        ${bean.className?uncap_first}Dao.update${bean.className}(${bean.className?uncap_first});
    }


    @Override
    public void delete${bean.className}(String siteCode,String ids) {
        String []arr = ids.split(",");
        for(String id:arr){
            ${bean.className?uncap_first}Dao.delete${bean.className}(siteCode,id);
        }
    }


}
