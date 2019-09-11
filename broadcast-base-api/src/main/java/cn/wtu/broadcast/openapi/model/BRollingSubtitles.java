package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;
import java.util.Date;

public class BRollingSubtitles implements Serializable {
    private Integer fId;

    private String fTitle;

    private String fAddress;

    private Date fStartDate;

    private Date fEndDate;

    private Date fStartTime;

    private Date fEndTime;

    private String fBroadcastArea;

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

    public String getfTitle() {
        return fTitle;
    }

    public void setfTitle(String fTitle) {
        this.fTitle = fTitle == null ? null : fTitle.trim();
    }

    public String getfAddress() {
        return fAddress;
    }

    public void setfAddress(String fAddress) {
        this.fAddress = fAddress == null ? null : fAddress.trim();
    }

    public Date getfStartDate() {
        return fStartDate;
    }

    public void setfStartDate(Date fStartDate) {
        this.fStartDate = fStartDate;
    }

    public Date getfEndDate() {
        return fEndDate;
    }

    public void setfEndDate(Date fEndDate) {
        this.fEndDate = fEndDate;
    }

    public Date getfStartTime() {
        return fStartTime;
    }

    public void setfStartTime(Date fStartTime) {
        this.fStartTime = fStartTime;
    }

    public Date getfEndTime() {
        return fEndTime;
    }

    public void setfEndTime(Date fEndTime) {
        this.fEndTime = fEndTime;
    }

    public String getfBroadcastArea() {
        return fBroadcastArea;
    }

    public void setfBroadcastArea(String fBroadcastArea) {
        this.fBroadcastArea = fBroadcastArea == null ? null : fBroadcastArea.trim();
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
        BRollingSubtitles other = (BRollingSubtitles) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfTitle() == null ? other.getfTitle() == null : this.getfTitle().equals(other.getfTitle()))
            && (this.getfAddress() == null ? other.getfAddress() == null : this.getfAddress().equals(other.getfAddress()))
            && (this.getfStartDate() == null ? other.getfStartDate() == null : this.getfStartDate().equals(other.getfStartDate()))
            && (this.getfEndDate() == null ? other.getfEndDate() == null : this.getfEndDate().equals(other.getfEndDate()))
            && (this.getfStartTime() == null ? other.getfStartTime() == null : this.getfStartTime().equals(other.getfStartTime()))
            && (this.getfEndTime() == null ? other.getfEndTime() == null : this.getfEndTime().equals(other.getfEndTime()))
            && (this.getfBroadcastArea() == null ? other.getfBroadcastArea() == null : this.getfBroadcastArea().equals(other.getfBroadcastArea()))
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
        result = prime * result + ((getfTitle() == null) ? 0 : getfTitle().hashCode());
        result = prime * result + ((getfAddress() == null) ? 0 : getfAddress().hashCode());
        result = prime * result + ((getfStartDate() == null) ? 0 : getfStartDate().hashCode());
        result = prime * result + ((getfEndDate() == null) ? 0 : getfEndDate().hashCode());
        result = prime * result + ((getfStartTime() == null) ? 0 : getfStartTime().hashCode());
        result = prime * result + ((getfEndTime() == null) ? 0 : getfEndTime().hashCode());
        result = prime * result + ((getfBroadcastArea() == null) ? 0 : getfBroadcastArea().hashCode());
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
        sb.append(", fTitle=").append(fTitle);
        sb.append(", fAddress=").append(fAddress);
        sb.append(", fStartDate=").append(fStartDate);
        sb.append(", fEndDate=").append(fEndDate);
        sb.append(", fStartTime=").append(fStartTime);
        sb.append(", fEndTime=").append(fEndTime);
        sb.append(", fBroadcastArea=").append(fBroadcastArea);
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