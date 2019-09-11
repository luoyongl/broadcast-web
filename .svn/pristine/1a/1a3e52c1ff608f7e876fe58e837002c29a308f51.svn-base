package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;
import java.util.Date;

public class BDeviceReturnAudio implements Serializable {
    private Integer fId;

    private String fAudioName;

    private Integer fDeviceId;

    private String fAudioUrl;

    private Boolean fUseFlag;

    private Integer fBroadcastId;

    private Boolean fIsTimingBroadcast;

    private Date fCreateTime;

    private Date fEndTime;

    private byte[] fAudioByte;

    private static final long serialVersionUID = 1L;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getfAudioName() {
        return fAudioName;
    }

    public void setfAudioName(String fAudioName) {
        this.fAudioName = fAudioName == null ? null : fAudioName.trim();
    }

    public Integer getfDeviceId() {
        return fDeviceId;
    }

    public void setfDeviceId(Integer fDeviceId) {
        this.fDeviceId = fDeviceId;
    }

    public String getfAudioUrl() {
        return fAudioUrl;
    }

    public void setfAudioUrl(String fAudioUrl) {
        this.fAudioUrl = fAudioUrl == null ? null : fAudioUrl.trim();
    }

    public Boolean getfUseFlag() {
        return fUseFlag;
    }

    public void setfUseFlag(Boolean fUseFlag) {
        this.fUseFlag = fUseFlag;
    }

    public Integer getfBroadcastId() {
        return fBroadcastId;
    }

    public void setfBroadcastId(Integer fBroadcastId) {
        this.fBroadcastId = fBroadcastId;
    }

    public Boolean getfIsTimingBroadcast() {
        return fIsTimingBroadcast;
    }

    public void setfIsTimingBroadcast(Boolean fIsTimingBroadcast) {
        this.fIsTimingBroadcast = fIsTimingBroadcast;
    }

    public Date getfCreateTime() {
        return fCreateTime;
    }

    public void setfCreateTime(Date fCreateTime) {
        this.fCreateTime = fCreateTime;
    }

    public Date getfEndTime() {
        return fEndTime;
    }

    public void setfEndTime(Date fEndTime) {
        this.fEndTime = fEndTime;
    }

    public byte[] getfAudioByte() {
        return fAudioByte;
    }

    public void setfAudioByte(byte[] fAudioByte) {
        this.fAudioByte = fAudioByte;
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
        BDeviceReturnAudio other = (BDeviceReturnAudio) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfAudioName() == null ? other.getfAudioName() == null : this.getfAudioName().equals(other.getfAudioName()))
            && (this.getfDeviceId() == null ? other.getfDeviceId() == null : this.getfDeviceId().equals(other.getfDeviceId()))
            && (this.getfAudioUrl() == null ? other.getfAudioUrl() == null : this.getfAudioUrl().equals(other.getfAudioUrl()))
            && (this.getfUseFlag() == null ? other.getfUseFlag() == null : this.getfUseFlag().equals(other.getfUseFlag()))
            && (this.getfBroadcastId() == null ? other.getfBroadcastId() == null : this.getfBroadcastId().equals(other.getfBroadcastId()))
            && (this.getfIsTimingBroadcast() == null ? other.getfIsTimingBroadcast() == null : this.getfIsTimingBroadcast().equals(other.getfIsTimingBroadcast()))
            && (this.getfCreateTime() == null ? other.getfCreateTime() == null : this.getfCreateTime().equals(other.getfCreateTime()))
            && (this.getfEndTime() == null ? other.getfEndTime() == null : this.getfEndTime().equals(other.getfEndTime()))
            && (this.getfAudioByte() == null ? other.getfAudioByte() == null : this.getfAudioByte().equals(other.getfAudioByte()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfAudioName() == null) ? 0 : getfAudioName().hashCode());
        result = prime * result + ((getfDeviceId() == null) ? 0 : getfDeviceId().hashCode());
        result = prime * result + ((getfAudioUrl() == null) ? 0 : getfAudioUrl().hashCode());
        result = prime * result + ((getfUseFlag() == null) ? 0 : getfUseFlag().hashCode());
        result = prime * result + ((getfBroadcastId() == null) ? 0 : getfBroadcastId().hashCode());
        result = prime * result + ((getfIsTimingBroadcast() == null) ? 0 : getfIsTimingBroadcast().hashCode());
        result = prime * result + ((getfCreateTime() == null) ? 0 : getfCreateTime().hashCode());
        result = prime * result + ((getfEndTime() == null) ? 0 : getfEndTime().hashCode());
        result = prime * result + ((getfAudioByte() == null) ? 0 : getfAudioByte().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fId=").append(fId);
        sb.append(", fAudioName=").append(fAudioName);
        sb.append(", fDeviceId=").append(fDeviceId);
        sb.append(", fAudioUrl=").append(fAudioUrl);
        sb.append(", fUseFlag=").append(fUseFlag);
        sb.append(", fBroadcastId=").append(fBroadcastId);
        sb.append(", fIsTimingBroadcast=").append(fIsTimingBroadcast);
        sb.append(", fCreateTime=").append(fCreateTime);
        sb.append(", fEndTime=").append(fEndTime);
        sb.append(", fAudioByte=").append(fAudioByte);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}