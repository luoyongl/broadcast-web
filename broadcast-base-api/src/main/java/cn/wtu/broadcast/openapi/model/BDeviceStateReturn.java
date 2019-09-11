package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;
import java.util.Date;

public class BDeviceStateReturn implements Serializable {
    private Integer fId;

    private Integer fDeviceId;

    private String fFmReceiveRate;

    private String fFmSignalStrength;

    private String fEmergencyBroadcastMesStatus;

    private Byte fSort;

    private Date fCreateTime;

    private Integer fCreatorId;

    private Date fUpdateTime;

    private Integer fOperatorId;

    private Boolean fDeleteFlag;

    private static final long serialVersionUID = 1L;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public Integer getfDeviceId() {
        return fDeviceId;
    }

    public void setfDeviceId(Integer fDeviceId) {
        this.fDeviceId = fDeviceId;
    }

    public String getfFmReceiveRate() {
        return fFmReceiveRate;
    }

    public void setfFmReceiveRate(String fFmReceiveRate) {
        this.fFmReceiveRate = fFmReceiveRate == null ? null : fFmReceiveRate.trim();
    }

    public String getfFmSignalStrength() {
        return fFmSignalStrength;
    }

    public void setfFmSignalStrength(String fFmSignalStrength) {
        this.fFmSignalStrength = fFmSignalStrength == null ? null : fFmSignalStrength.trim();
    }

    public String getfEmergencyBroadcastMesStatus() {
        return fEmergencyBroadcastMesStatus;
    }

    public void setfEmergencyBroadcastMesStatus(String fEmergencyBroadcastMesStatus) {
        this.fEmergencyBroadcastMesStatus = fEmergencyBroadcastMesStatus == null ? null : fEmergencyBroadcastMesStatus.trim();
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
        BDeviceStateReturn other = (BDeviceStateReturn) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfDeviceId() == null ? other.getfDeviceId() == null : this.getfDeviceId().equals(other.getfDeviceId()))
            && (this.getfFmReceiveRate() == null ? other.getfFmReceiveRate() == null : this.getfFmReceiveRate().equals(other.getfFmReceiveRate()))
            && (this.getfFmSignalStrength() == null ? other.getfFmSignalStrength() == null : this.getfFmSignalStrength().equals(other.getfFmSignalStrength()))
            && (this.getfEmergencyBroadcastMesStatus() == null ? other.getfEmergencyBroadcastMesStatus() == null : this.getfEmergencyBroadcastMesStatus().equals(other.getfEmergencyBroadcastMesStatus()))
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
        result = prime * result + ((getfDeviceId() == null) ? 0 : getfDeviceId().hashCode());
        result = prime * result + ((getfFmReceiveRate() == null) ? 0 : getfFmReceiveRate().hashCode());
        result = prime * result + ((getfFmSignalStrength() == null) ? 0 : getfFmSignalStrength().hashCode());
        result = prime * result + ((getfEmergencyBroadcastMesStatus() == null) ? 0 : getfEmergencyBroadcastMesStatus().hashCode());
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
        sb.append(", fDeviceId=").append(fDeviceId);
        sb.append(", fFmReceiveRate=").append(fFmReceiveRate);
        sb.append(", fFmSignalStrength=").append(fFmSignalStrength);
        sb.append(", fEmergencyBroadcastMesStatus=").append(fEmergencyBroadcastMesStatus);
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