package com.yugabyte.gmdemo;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "task", schema = "part_master")
public class Task {

    @Id
    private String taskId;
    private String taskStatId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_type_id")
    private TaskType taskType;

    private String taskKeyTxt;
    private String prntTaskId;
    private String prntTaskStepId;
    private String failStepId;
    private String crtUsrId;
    private Timestamp crtTs;
    private String updUsrId;
    private Timestamp updTs;
    private Integer tcn;
    private String plantId;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskStatId() {
        return taskStatId;
    }

    public void setTaskStatId(String taskStatId) {
        this.taskStatId = taskStatId;
    }

    public String getTaskKeyTxt() {
        return taskKeyTxt;
    }

    public void setTaskKeyTxt(String taskKeyTxt) {
        this.taskKeyTxt = taskKeyTxt;
    }

    public String getPrntTaskId() {
        return prntTaskId;
    }

    public void setPrntTaskId(String prntTaskId) {
        this.prntTaskId = prntTaskId;
    }

    public String getPrntTaskStepId() {
        return prntTaskStepId;
    }

    public void setPrntTaskStepId(String prntTaskStepId) {
        this.prntTaskStepId = prntTaskStepId;
    }

    public String getFailStepId() {
        return failStepId;
    }

    public void setFailStepId(String failStepId) {
        this.failStepId = failStepId;
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

    public String getPlantId() {
        return plantId;
    }

    public void setPlantId(String plantId) {
        this.plantId = plantId;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

}
