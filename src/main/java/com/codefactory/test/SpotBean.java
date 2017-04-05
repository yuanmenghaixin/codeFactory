package com.codefactory.test;

import com.codefactory.annotation.FieldType;
import com.codefactory.annotation.Table;

import java.util.Date;

/**
 * Created by Gao.WenLong on 2017/3/29.
 */

@Table(value="spot",comment="点管理")
public class SpotBean {

    @FieldType(value="id",type="bigInt",comment = "ID",pk=1,show=0)
    public Long id;
    @FieldType(value="name",type="varchar",comment = "名称",length = "30", search=1)
    public String name;
    @FieldType(value="createDate",type="datetime",comment = "创建时间")
    public Date createDate;
    @FieldType(value="amount",type="decimal",comment = "数量",length = "19,3")
    public Double amount;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
