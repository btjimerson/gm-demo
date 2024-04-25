package com.yugabyte.gmdemo;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "task_type", schema = "part_master")
public class TaskType {

    @Id
    private String taskTypeId;
    private String taskTypeNm;
    private String taskTypeDesc;
    private Boolean purgeOnArchFlg;
    private Integer purgeAfterQty;
    private String crtUsrId;
    private Timestamp crtTs;
    private String updUsrId;
    private Timestamp updTs;
    private Integer tcn;
    private Timestamp expTs;
    private Integer purgeTimeUnit;
    private String plantId;

    public String getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(String taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public String getTaskTypeNm() {
        return taskTypeNm;
    }

    public void setTaskTypeNm(String taskTypeNm) {
        this.taskTypeNm = taskTypeNm;
    }

    public String getTaskTypeDesc() {
        return taskTypeDesc;
    }

    public void setTaskTypeDesc(String taskTypeDesc) {
        this.taskTypeDesc = taskTypeDesc;
    }

    public Boolean getPurgeOnArchFlg() {
        return purgeOnArchFlg;
    }

    public void setPurgeOnArchFlg(Boolean purgeOnArchFlg) {
        this.purgeOnArchFlg = purgeOnArchFlg;
    }

    public Integer getPurgeAfterQty() {
        return purgeAfterQty;
    }

    public void setPurgeAfterQty(Integer purgeAfterQty) {
        this.purgeAfterQty = purgeAfterQty;
    }

    public String getCrtUsrId() {
        return crtUsrId;
    }

    public void setCrtUsrId(String crtUsrId) {
        this.crtUsrId = crtUsrId;
    }

    public Timestamp getCrtTs() {
        return crtTs;
    }

    public void setCrtTs(Timestamp crtTs) {
        this.crtTs = crtTs;
    }

    public String getUpdUsrId() {
        return updUsrId;
    }

    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    public Timestamp getUpdTs() {
        return updTs;
    }

    public void setUpdTs(Timestamp updTs) {
        this.updTs = updTs;
    }

    public Integer getTcn() {
        return tcn;
    }

    public void setTcn(Integer tcn) {
        this.tcn = tcn;
    }

    public Timestamp getExpTs() {
        return expTs;
    }

    public void setExpTs(Timestamp expTs) {
        this.expTs = expTs;
    }

    public Integer getPurgeTimeUnit() {
        return purgeTimeUnit;
    }

    public void setPurgeTimeUnit(Integer purgeTimeUnit) {
        this.purgeTimeUnit = purgeTimeUnit;
    }

    public String getPlantId() {
        return plantId;
    }

    public void setPlantId(String plantId) {
        this.plantId = plantId;
    }

}
