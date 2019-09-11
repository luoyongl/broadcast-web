package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;
import java.util.Date;

public class BBroadcastTemp implements Serializable {
    private Integer fBroadcastId;

    private Boolean fTimingBroadcast;

    private Date fCreateTime;

    private static final long serialVersionUID = 1L;

    public Integer getfBroadcastId() {
        return fBroadcastId;
    }

    public void setfBroadcastId(Integer fBroadcastId) {
        this.fBroadcastId = fBroadcastId;
    }

    public Boolean getfTimingBroadcast() {
        return fTimingBroadcast;
    }

    public void setfTimingBroadcast(Boolean fTimingBroadcast) {
        this.fTimingBroadcast = fTimingBroadcast;
    }

    public Date getfCreateTime() {
        return fCreateTime;
    }

    public void setfCreateTime(Date fCreateTime) {
        this.fCreateTime = fCreateTime;
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
        BBroadcastTemp other = (BBroadcastTemp) that;
        return (this.getfBroadcastId() == null ? other.getfBroadcastId() == null : this.getfBroadcastId().equals(other.getfBroadcastId()))
            && (this.getfTimingBroadcast() == null ? other.getfTimingBroadcast() == null : this.getfTimingBroadcast().equals(other.getfTimingBroadcast()))
            && (this.getfCreateTime() == null ? other.getfCreateTime() == null : this.getfCreateTime().equals(other.getfCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfBroadcastId() == null) ? 0 : getfBroadcastId().hashCode());
        result = prime * result + ((getfTimingBroadcast() == null) ? 0 : getfTimingBroadcast().hashCode());
        result = prime * result + ((getfCreateTime() == null) ? 0 : getfCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fBroadcastId=").append(fBroadcastId);
        sb.append(", fTimingBroadcast=").append(fTimingBroadcast);
        sb.append(", fCreateTime=").append(fCreateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}