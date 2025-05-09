package com.qdu.pojo;

import java.io.Serializable;
import java.util.Date;

public class Group_travel_activity implements Serializable {
    private Integer activityId;

    private Integer userId;

    private String activityTitle;

    private String activityStatus;

    private String activityImages;

    private Date activityStartTime;

    private Date activityEndTime;

    private Date createTime;

    private String activityDescription;

    private static final long serialVersionUID = 1L;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    public String getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(String activityStatus) {
        this.activityStatus = activityStatus;
    }

    public String getActivityImages() {
        return activityImages;
    }

    public void setActivityImages(String activityImages) {
        this.activityImages = activityImages;
    }

    public Date getActivityStartTime() {
        return activityStartTime;
    }

    public void setActivityStartTime(Date activityStartTime) {
        this.activityStartTime = activityStartTime;
    }

    public Date getActivityEndTime() {
        return activityEndTime;
    }

    public void setActivityEndTime(Date activityEndTime) {
        this.activityEndTime = activityEndTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", activityId=").append(activityId);
        sb.append(", userId=").append(userId);
        sb.append(", activityTitle=").append(activityTitle);
        sb.append(", activityStatus=").append(activityStatus);
        sb.append(", activityImages=").append(activityImages);
        sb.append(", activityStartTime=").append(activityStartTime);
        sb.append(", activityEndTime=").append(activityEndTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", activityDescription=").append(activityDescription);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Group_travel_activity other = (Group_travel_activity) that;
        return (this.getActivityId() == null ? other.getActivityId() == null : this.getActivityId().equals(other.getActivityId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getActivityTitle() == null ? other.getActivityTitle() == null : this.getActivityTitle().equals(other.getActivityTitle()))
            && (this.getActivityStatus() == null ? other.getActivityStatus() == null : this.getActivityStatus().equals(other.getActivityStatus()))
            && (this.getActivityImages() == null ? other.getActivityImages() == null : this.getActivityImages().equals(other.getActivityImages()))
            && (this.getActivityStartTime() == null ? other.getActivityStartTime() == null : this.getActivityStartTime().equals(other.getActivityStartTime()))
            && (this.getActivityEndTime() == null ? other.getActivityEndTime() == null : this.getActivityEndTime().equals(other.getActivityEndTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getActivityDescription() == null ? other.getActivityDescription() == null : this.getActivityDescription().equals(other.getActivityDescription()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getActivityId() == null) ? 0 : getActivityId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getActivityTitle() == null) ? 0 : getActivityTitle().hashCode());
        result = prime * result + ((getActivityStatus() == null) ? 0 : getActivityStatus().hashCode());
        result = prime * result + ((getActivityImages() == null) ? 0 : getActivityImages().hashCode());
        result = prime * result + ((getActivityStartTime() == null) ? 0 : getActivityStartTime().hashCode());
        result = prime * result + ((getActivityEndTime() == null) ? 0 : getActivityEndTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getActivityDescription() == null) ? 0 : getActivityDescription().hashCode());
        return result;
    }
}