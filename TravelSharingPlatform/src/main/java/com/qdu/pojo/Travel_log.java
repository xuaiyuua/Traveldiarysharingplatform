package com.qdu.pojo;

import java.io.Serializable;
import java.util.Date;

public class Travel_log implements Serializable {
    private Integer logId;

    private Integer userId;

    private String logTitle;

    private String logAudio;

    private String logVideo;

    private String logImages;

    private Date publishTime;

    private String logContent;

    private static final long serialVersionUID = 1L;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLogTitle() {
        return logTitle;
    }

    public void setLogTitle(String logTitle) {
        this.logTitle = logTitle;
    }

    public String getLogAudio() {
        return logAudio;
    }

    public void setLogAudio(String logAudio) {
        this.logAudio = logAudio;
    }

    public String getLogVideo() {
        return logVideo;
    }

    public void setLogVideo(String logVideo) {
        this.logVideo = logVideo;
    }

    public String getLogImages() {
        return logImages;
    }

    public void setLogImages(String logImages) {
        this.logImages = logImages;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", logId=").append(logId);
        sb.append(", userId=").append(userId);
        sb.append(", logTitle=").append(logTitle);
        sb.append(", logAudio=").append(logAudio);
        sb.append(", logVideo=").append(logVideo);
        sb.append(", logImages=").append(logImages);
        sb.append(", publishTime=").append(publishTime);
        sb.append(", logContent=").append(logContent);
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
        Travel_log other = (Travel_log) that;
        return (this.getLogId() == null ? other.getLogId() == null : this.getLogId().equals(other.getLogId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getLogTitle() == null ? other.getLogTitle() == null : this.getLogTitle().equals(other.getLogTitle()))
            && (this.getLogAudio() == null ? other.getLogAudio() == null : this.getLogAudio().equals(other.getLogAudio()))
            && (this.getLogVideo() == null ? other.getLogVideo() == null : this.getLogVideo().equals(other.getLogVideo()))
            && (this.getLogImages() == null ? other.getLogImages() == null : this.getLogImages().equals(other.getLogImages()))
            && (this.getPublishTime() == null ? other.getPublishTime() == null : this.getPublishTime().equals(other.getPublishTime()))
            && (this.getLogContent() == null ? other.getLogContent() == null : this.getLogContent().equals(other.getLogContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLogId() == null) ? 0 : getLogId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getLogTitle() == null) ? 0 : getLogTitle().hashCode());
        result = prime * result + ((getLogAudio() == null) ? 0 : getLogAudio().hashCode());
        result = prime * result + ((getLogVideo() == null) ? 0 : getLogVideo().hashCode());
        result = prime * result + ((getLogImages() == null) ? 0 : getLogImages().hashCode());
        result = prime * result + ((getPublishTime() == null) ? 0 : getPublishTime().hashCode());
        result = prime * result + ((getLogContent() == null) ? 0 : getLogContent().hashCode());
        return result;
    }
}