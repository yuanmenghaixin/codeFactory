package ${bean.basePackage}.model;

import cn.evun.ime.platform.core.model.ImeCommon;
import java.util.Date;
/**
* Created by codeFactory on ${bean.createDate?string("yyyy-MM-dd HH:mm:ss")}
*/
public class ${bean.className} extends ImeCommon {

    <#list bean.proList as pro>
    private ${pro.type} ${pro.name};

    </#list>


    <#list bean.proList as pro>
    public ${pro.type} get${pro.name?cap_first}(){
        return ${pro.name};
    }

    public void set${pro.name?cap_first}(${pro.type} ${pro.name}){
        this.${pro.name} = ${pro.name};
    }

    </#list>


}
