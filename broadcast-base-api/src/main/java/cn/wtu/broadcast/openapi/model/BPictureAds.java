package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;
import java.util.Date;

public class BPictureAds implements Serializable {
    private Integer fId;

    private String fImageName;

    private String fAddress;

    private Boolean fSendAllDates;

    private Date fSendStartDate;

    private Date fSendEndDate;

    private Boolean fSendAllTimes;

    private Date fSendStartTime;

    private Date fSendEndTime;

    private String fBroadcastArea;

    private Integer fRollInterval;

    private String fRemark;

    private Byte fSort;

    private Date fCreateTime;

    private Integer fCreatorId;

    private Date fUpdateTime;

    private Integer fOperatorId;

    private Boolean fDeleteFlag;
    
    private String fState;
    
    private String fDevice;

    private static final long serialVersionUID = 1L;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getfImageName() {
        return fImageName;
    }

    public void setfImageName(String fImageName) {
        this.fImageName = fImageName == null ? null : fImageName.trim();
    }

    public String getfAddress() {
        return fAddress;
    }

    public void setfAddress(String fAddress) {
        this.fAddress = fAddress == null ? null : fAddress.trim();
    }

    public Boolean getfSendAllDates() {
        return fSendAllDates;
    }

    public void setfSendAllDates(Boolean fSendAllDates) {
        this.fSendAllDates = fSendAllDates;
    }

    public Date getfSendStartDate() {
        return fSendStartDate;
    }

    public void setfSendStartDate(Date fSendStartDate) {
        this.fSendStartDate = fSendStartDate;
    }

    public Date getfSendEndDate() {
        return fSendEndDate;
    }

    public void setfSendEndDate(Date fSendEndDate) {
        this.fSendEndDate = fSendEndDate;
    }

    public Boolean getfSendAllTimes() {
        return fSendAllTimes;
    }

    public void setfSendAllTimes(Boolean fSendAllTimes) {
        this.fSendAllTimes = fSendAllTimes;
    }

    public Date getfSendStartTime() {
        return fSendStartTime;
    }

    public void setfSendStartTime(Date fSendStartTime) {
        this.fSendStartTime = fSendStartTime;
    }

    public Date getfSendEndTime() {
        return fSendEndTime;
    }

    public void setfSendEndTime(Date fSendEndTime) {
        this.fSendEndTime = fSendEndTime;
    }

    public String getfBroadcastArea() {
        return fBroadcastArea;
    }

    public void setfBroadcastArea(String fBroadcastArea) {
        this.fBroadcastArea = fBroadcastArea == null ? null : fBroadcastArea.trim();
    }

    public Integer getfRollInterval() {
        return fRollInterval;
    }

    public void setfRollInterval(Integer fRollInterval) {
        this.fRollInterval = fRollInterval;
    }

    public String getfRemark() {
        return fRemark;
    }

    public void setfRemark(String fRemark) {
        this.fRemark = fRemark == null ? null : fRemark.trim();
    }

    public Byte getfSort() {
        return fSort;
    }

    public void setfSort(Byte fSort) {
        this.fSort = fSort;
    }

    public Date getfCreateTime() {
        return fCreateTime;
    }

    public void setfCreateTime(Date fCreateTime) {
        this.fCreateTime = fCreateTime;
    }

    public Integer getfCreatorId() {
        return fCreatorId;
    }

    public void setfCreatorId(Integer fCreatorId) {
        this.fCreatorId = fCreatorId;
    }

    public Date getfUpdateTime() {
        return fUpdateTime;
    }

    public void setfUpdateTime(Date fUpdateTime) {
        this.fUpdateTime = fUpdateTime;
    }

    public Integer getfOperatorId() {
        return fOperatorId;
    }

    public void setfOperatorId(Integer fOperatorId) {
        this.fOperatorId = fOperatorId;
    }

    public Boolean getfDeleteFlag() {
        return fDeleteFlag;
    }

    public void setfDeleteFlag(Boolean fDeleteFlag) {
        this.fDeleteFlag = fDeleteFlag;
    }
    
    public String getfState() {
		return fState;
	}

	public void setfState(String fState) {
		this.fState = fState;
	}

	public String getfDevice() {
		return fDevice;
	}

	public void setfDevice(String fDevice) {
		this.fDevice = fDevice;
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
        BPictureAds other = (BPictureAds) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfImageName() == null ? other.getfImageName() == null : this.getfImageName().equals(other.getfImageName()))
            && (this.getfAddress() == null ? other.getfAddress() == null : this.getfAddress().equals(other.getfAddress()))
            && (this.getfSendAllDates() == null ? other.getfSendAllDates() == null : this.getfSendAllDates().equals(other.getfSendAllDates()))
            && (this.getfSendStartDate() == null ? other.getfSendStartDate() == null : this.getfSendStartDate().equals(other.getfSendStartDate()))
            && (this.getfSendEndDate() == null ? other.getfSendEndDate() == null : this.getfSendEndDate().equals(other.getfSendEndDate()))
            && (this.getfSendAllTimes() == null ? other.getfSendAllTimes() == null : this.getfSendAllTimes().equals(other.getfSendAllTimes()))
            && (this.getfSendStartTime() == null ? other.getfSendStartTime() == null : this.getfSendStartTime().equals(other.getfSendStartTime()))
            && (this.getfSendEndTime() == null ? other.getfSendEndTime() == null : this.getfSendEndTime().equals(other.getfSendEndTime()))
            && (this.getfBroadcastArea() == null ? other.getfBroadcastArea() == null : this.getfBroadcastArea().equals(other.getfBroadcastArea()))
            && (this.getfRollInterval() == null ? other.getfRollInterval() == null : this.getfRollInterval().equals(other.getfRollInterval()))
            && (this.getfRemark() == null ? other.getfRemark() == null : this.getfRemark().equals(other.getfRemark()))
            && (this.getfSort() == null ? other.getfSort() == null : this.getfSort().equals(other.getfSort()))
            && (this.getfCreateTime() == null ? other.getfCreateTime() == null : this.getfCreateTime().equals(other.getfCreateTime()))
            && (this.getfCreatorId() == null ? other.getfCreatorId() == null : this.getfCreatorId().equals(other.getfCreatorId()))
            && (this.getfUpdateTime() == null ? other.getfUpdateTime() == null : this.getfUpdateTime().equals(other.getfUpdateTime()))
            && (this.getfOperatorId() == null ? other.getfOperatorId() == null : this.getfOperatorId().equals(other.getfOperatorId()))
            && (this.getfDeleteFlag() == null ? other.getfDeleteFlag() == null : this.getfDeleteFlag().equals(other.getfDeleteFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfImageName() == null) ? 0 : getfImageName().hashCode());
        result = prime * result + ((getfAddress() == null) ? 0 : getfAddress().hashCode());
        result = prime * result + ((getfSendAllDates() == null) ? 0 : getfSendAllDates().hashCode());
        result = prime * result + ((getfSendStartDate() == null) ? 0 : getfSendStartDate().hashCode());
        result = prime * result + ((getfSendEndDate() == null) ? 0 : getfSendEndDate().hashCode());
        result = prime * result + ((getfSendAllTimes() == null) ? 0 : getfSendAllTimes().hashCode());
        result = prime * result + ((getfSendStartTime() == null) ? 0 : getfSendStartTime().hashCode());
        result = prime * result + ((getfSendEndTime() == null) ? 0 : getfSendEndTime().hashCode());
        result = prime * result + ((getfBroadcastArea() == null) ? 0 : getfBroadcastArea().hashCode());
        result = prime * result + ((getfRollInterval() == null) ? 0 : getfRollInterval().hashCode());
        result = prime * result + ((getfRemark() == null) ? 0 : getfRemark().hashCode());
        result = prime * result + ((getfSort() == null) ? 0 : getfSort().hashCode());
        result = prime * result + ((getfCreateTime() == null) ? 0 : getfCreateTime().hashCode());
        result = prime * result + ((getfCreatorId() == null) ? 0 : getfCreatorId().hashCode());
        result = prime * result + ((getfUpdateTime() == null) ? 0 : getfUpdateTime().hashCode());
        result = prime * result + ((getfOperatorId() == null) ? 0 : getfOperatorId().hashCode());
        result = prime * result + ((getfDeleteFlag() == null) ? 0 : getfDeleteFlag().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fId=").append(fId);
        sb.append(", fImageName=").append(fImageName);
        sb.append(", fAddress=").append(fAddress);
        sb.append(", fSendAllDates=").append(fSendAllDates);
        sb.append(", fSendStartDate=").append(fSendStartDate);
        sb.append(", fSendEndDate=").append(fSendEndDate);
        sb.append(", fSendAllTimes=").append(fSendAllTimes);
        sb.append(", fSendStartTime=").append(fSendStartTime);
        sb.append(", fSendEndTime=").append(fSendEndTime);
        sb.append(", fBroadcastArea=").append(fBroadcastArea);
        sb.append(", fRollInterval=").append(fRollInterval);
        sb.append(", fRemark=").append(fRemark);
        sb.append(", fSort=").append(fSort);
        sb.append(", fCreateTime=").append(fCreateTime);
        sb.append(", fCreatorId=").append(fCreatorId);
        sb.append(", fUpdateTime=").append(fUpdateTime);
        sb.append(", fOperatorId=").append(fOperatorId);
        sb.append(", fDeleteFlag=").append(fDeleteFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}