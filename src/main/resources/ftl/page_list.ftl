<#noparse><#include "/common/pagerForm.html">
<script src="${rc.getContextPath()}/js/dwzCustomJs/dwz.custom.advancedquery.js?v=${ver}" type="text/javascript"></script></#noparse>
<form name="${bean.className?uncap_first}Condition" rel="pagerForm" method="post" action="" onsubmit="return navTabSearch(this)">
    <div class="pageHeader">
        <div class="searchBar poStatus">
            <ul class="searchContent">
                <#list bean.proList as pro>
                <#if pro.search>
                <#if pro.type == "Date">
                <li><label>${pro.comment}：</label>
                    <input type="text" class="date" readonly="readonly" datefmt="yyyy-MM-dd HH:mm:ss" size="17" max_Date="{maxCreateDateTime}" name="minCreateDateTime" value="<#noparse>${</#noparse>condition.minCreateDateTime!''}"/> <a class="inputDateButton" href="javascript:;">选择</a>
                </li>
                <li><label>至：</label>
                    <input type="text" class="date" readonly="readonly" datefmt="yyyy-MM-dd HH:mm:ss" size="17" min_Date="{minCreateDateTime}" name="maxCreateDateTime" value="<#noparse>${</#noparse>condition.maxCreateDateTime!''}" /> <a class="inputDateButton" href="javascript:;">选择</a>
                </li>
                <#else>
                <li>
                    <label>${pro.comment}：</label>
                    <input  type="text"  name="${pro.name}" value="<#noparse>${</#noparse>condition.${pro.name}!''}" />
                </li>
                </#if>
                </#if>
                </#list>

                <li class="query">
                    <div class="buttonActive">
                        <div class="buttonContent">
                            <button type="submit">
                                查询
                            </button>
                        </div>
                    </div>
                </li>
            </ul>

        </div>
    </div>
</form>

<div class="pageContent">

    <div class="panelBar">
        <ul class="toolBar">
        <#noparse><@buttonRight </#noparse>menuCode="${bean.className}_ADD"  defalutName="新增">
            <li><a class="add" target="dialog" mask="true" width="350" height="240" rel="${bean.className}_tab"
                   href="<#noparse>${rc.getContextPath()}</#noparse>/manage/${bean.className?uncap_first}/saveOrUpdate?flag=0&navTabId=<#noparse>${</#noparse>navTabId!''}"title="新增记录"><span>新增</span></a></li><#noparse></@buttonRight></#noparse>
        <#noparse><@buttonRight </#noparse>menuCode="${bean.className}_EDIT"  defalutName="编辑">
            <li><a class="edit" target="dialog" mask="true" width="400" height="300" rel="${bean.className}_tab"
                   href="<#noparse>${rc.getContextPath()}</#noparse>/manage/${bean.className?uncap_first}/saveOrUpdate?flag=1&id={id}&navTabId=<#noparse>${</#noparse>navTabId!''}"title="编辑记录"><span>编辑</span></a></li><#noparse></@buttonRight></#noparse>
        <#noparse><@buttonRight</#noparse> menuCode="${bean.className}_DEL"  defalutName="删除">
            <li><a class="delete" target="selectedTodo" href="<#noparse>${rc.getContextPath()}</#noparse>/manage/${bean.className?uncap_first}/delete?navTabId=<#noparse>${</#noparse>navTabId!''}" postType="string" rel="ids" callback="batchjobAjaxDone"
                   title="确认要删除选择的信息吗？"><span>删除</span></a> </li><#noparse></@buttonRight></#noparse>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="140">
        <thead>
        <tr>
            <th width="25"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
            <th width="40">序号</th>
            <#list bean.proList as pro>
            <#if pro.show >
            <th width="100" orderField="${pro.name}"<#noparse><#if </#noparse>(page.orderField?? && page.orderField =='${pro.name}')>class="<#noparse>${</#noparse>page.orderDirection!''}"<#noparse></#if></#noparse>>${pro.comment}</th>
            </#if>
            </#list>
        </tr>
        </thead>
        <tbody>
        <#noparse> <#if page??><#if (page.data?size>0)> <#list page.data as </#noparse>${bean.className?uncap_first}>
        <tr target="id" rel="<#noparse>${</#noparse> ${bean.className?uncap_first}.id!''}">
            <td><input name="ids" value="<#noparse> ${ </#noparse>${bean.className?uncap_first}.id!''}" type="checkbox"></td>
            <td><#noparse>${</#noparse>page.startRow + ${bean.className?uncap_first}_index}</td>
        <#list bean.proList as pro>
        <#if pro.show >
        <#if pro.type=='Date'>
            <td><#noparse>${</#noparse>(${bean.className?uncap_first}.${pro.name}?string("yyyy-MM-dd HH:mm"))?if_exists}</td>
        <#else>
             <td><#noparse>${</#noparse>${bean.className?uncap_first}.${pro.name}!''}</td>
        </#if>
        </#if>
        </#list>
        </tr>
<#noparse>  </#list>
        <#else>
        <tr target="id">
            <td colspan="20" class="noData">======列表无数据=====</font></td>
        </tr>
        </#if>
        <#else>
        <tr target="id">
            <td colspan="20" class="noData">======列表无数据=====</font></td>
        </tr>
        </#if></#noparse>
        </tbody>
    </table>
<#noparse><#include "/common/panelBar.html"></#noparse>
</div>

<script type="text/javascript">
    $(function() {
        initAdvancedQuery(navTab.getCurrentPanel());
    });

</script>
