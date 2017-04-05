package ${bean.basePackage}.controller;

import cn.evun.ime.platform.core.constants.SystemConstant;
import cn.evun.ime.platform.core.model.DWZResult;
import cn.evun.ime.platform.core.utils.StringUtils;
import cn.evun.ime.platform.security.controller.SecurityController;

import ${bean.basePackage}.model.${bean.className};
import ${bean.basePackage}.model.condition.${bean.className}Condition;
import ${bean.basePackage}.service.${bean.className}Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


/**
* Created by codeFactory on ${bean.createDate?string("yyyy-MM-dd HH:mm:ss")}.
*/
@Controller
@RequestMapping("/${bean.className?uncap_first}")
public class ${bean.className}Controller extends SecurityController {

    @Resource
    private ${bean.className}Service ${bean.className?uncap_first}Service;

    private static final String path="${bean.relativePath}/${bean.className?uncap_first}/";

    @RequestMapping("list")
    public String list(@ModelAttribute("condition") ${bean.className}Condition condition,
    String navTabId, Model model){
        condition.setSiteCode(this.getSiteCode());
        List<${bean.className}> list = ${bean.className?uncap_first}Service.select${bean.className}ByCondition(condition);
        int count = ${bean.className?uncap_first}Service.selectCountByCondition(condition);
        condition.setData(list);
        condition.setTotalCount(count);
        model.addAttribute("page", condition);
        model.addAttribute(NAVTABID, navTabId);

        return path+"${bean.className?uncap_first}_list";
    }

    /**
      *@param flag 0-添加，1-修改,2-查看
      */
    @RequestMapping(value="edit",method = RequestMethod.GET)
    public String add(ModelMap map, ${bean.className} condition,Integer flag,String navTabId){
        if(null!=flag && 0 != flag){
            ${bean.className} ${bean.className?uncap_first} = ${bean.className?uncap_first}Service.select${bean.className}(condition);
            map.addAttribute("${bean.className?uncap_first}", ${bean.className?uncap_first});
        }
        map.addAttribute(NAVTABID, navTabId);
        map.addAttribute("flag", flag);
        return path+"${bean.className?uncap_first}_edit";
    }


    @ResponseBody
    @RequestMapping("saveOrUpdate")
    public DWZResult saveOrUpdate(${bean.className} ${bean.className?uncap_first},Integer flag,String navTabId){
        if (${bean.className?uncap_first} == null) {
            return ajaxError(getImeViewMessageI18n(null,SystemConstant.PARAMETERNULL));
        }
        setCreateInfo(${bean.className?uncap_first});
        if(1 == flag){//更新
            ${bean.className?uncap_first}Service.update${bean.className}(${bean.className?uncap_first});
        }else{//添加
            ${bean.className?uncap_first}Service.insert${bean.className}(${bean.className?uncap_first});
        }
        return dialogAjaxDone(navTabId, null, null, null);
    }


    /**
    * 删除信息
    * @param navTabId
    * @param ids
    * @return
    */
    @ResponseBody
    @RequestMapping("delete")
    public DWZResult ${bean.className?uncap_first}Delete(String navTabId, String ids){
        if(StringUtils.isEmpty(ids)){
            return ajaxError("请选择需要删除的记录");
        }
        ${bean.className?uncap_first}Service.delete${bean.className}(getSiteCode(),ids);
        return navTabAjaxDone(navTabId, null, null, null,getImeViewMessageI18n(null, "successfulOperation.M"),null);
    }

}
