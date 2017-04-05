package com.codefactory.test;


/**
 * Created by Gao.WenLong on 2017/3/6.
 */
public class SpotCheckUp extends ImeCommon {
    /**
     * 点检编号
     */
    private String spotCode;
    /**
     * 点检名称
     */
    private String spotName;
    /**
     * 锁定标志
     */
    private Integer lockFlag;
    /**
     * 设备编号
     */
    private String equipmentCode;

    private String[] ids;

    public String getSpotCode() {
        return spotCode;
    }

    public void setSpotCode(String spotCode) {
        this.spotCode = spotCode;
    }

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    public Integer getLockFlag() {
        return lockFlag;
    }

    public void setLockFlag(Integer lockFlag) {
        this.lockFlag = lockFlag;
    }

    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode;
    }

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }
}
