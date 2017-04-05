<div class="pageContent">
    <form method="post" action="<#noparse>${rc.getContextPath()}</#noparse>/manage/${bean.className?uncap_first}/saveOrUpdate"
          class="pageForm required-validate"
          onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent">
            <input type="hidden" name="navTabId" value="<#noparse>${</#noparse>navTabId!''}">
            <input type="hidden" name="flag" value="<#noparse>${</#noparse>flag!''}">
            <fieldset class="dataset">
                <#list bean.proList as pro>
                <#if pro.show >
                <dl>
                    <dt>${pro.comment}：</dt>
                    <#if pro.type == "Date">
                    <dd>
                        <input type="text" class="date  <#if pro.required>required </#if>" readonly="readonly" datefmt="yyyy-MM-dd HH:mm:ss" size="17"
                               name="${pro.name}" value="<#noparse><#if</#noparse> (${bean.className?uncap_first}.${pro.name})??><#noparse>${</#noparse>${bean.className?uncap_first}.${pro.name}!''}<#noparse></#if></#noparse>" />
                        <#noparse> <#if </#noparse>flag !=2 ><a class="inputDateButton" href="javascript:;">选择</a> <#noparse><#if></#noparse>

                    </dd>
                    <#else>
                    <dd>
                        <input name="${pro.name}" value="<#noparse><#if </#noparse>(${bean.className?uncap_first}.${pro.name})??><#noparse>${</#noparse>${bean.className?uncap_first}.${pro.name}!''}<#noparse></#if></#noparse>"
                               size="32" type="text" maxlength="20" class="<#if pro.required>required </#if> "
                                <#noparse> <#if </#noparse>flag ==2 > readonly="readonly" <#noparse><#if></#noparse>/>
                    </dd>
                    </#if>
                </dl>
                </#if>
                </#list>
            </fieldset>
        </div>
    <#noparse>   <#if flag !=0>
        <#assign createInfo=${bean.className}/>
        <#include "/common/createInfo.html">
    </#if></#noparse>
        <div class="formBar">
            <ul style="margin-right: 90px;">
                <li>
                    <div class="buttonActive">
                        <div class="buttonContent">
                            <button type="submit">保存</button>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="buttonActiveGrey">
                        <div class="buttonContent">
                            <button type="button" class="close">取消</button>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </form>
</div>