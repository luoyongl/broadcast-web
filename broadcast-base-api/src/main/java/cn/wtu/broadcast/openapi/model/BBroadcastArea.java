package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;

public class BBroadcastArea implements Serializable {
    private Integer fId;

    private Byte fAssociationType;

    private String fAssocaitionPrimaryKey;

    private Integer fAreaId;

    private static final long serialVersionUID = 1L;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public Byte getfAssociationType() {
        return fAssociationType;
    }

    public void setfAssociationType(Byte fAssociationType) {
        this.fAssociationType = fAssociationType;
    }

    public String getfAssocaitionPrimaryKey() {
        return fAssocaitionPrimaryKey;
    }

    public void setfAssocaitionPrimaryKey(String fAssocaitionPrimaryKey) {
        this.fAssocaitionPrimaryKey = fAssocaitionPrimaryKey == null ? null : fAssocaitionPrimaryKey.trim();
    }

    public Integer getfAreaId() {
        return fAreaId;
    }

    public void setfAreaId(Integer fAreaId) {
        this.fAreaId = fAreaId;
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
        BBroadcastArea other = (BBroadcastArea) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfAssociationType() == null ? other.getfAssociationType() == null : this.getfAssociationType().equals(other.getfAssociationType()))
            && (this.getfAssocaitionPrimaryKey() == null ? other.getfAssocaitionPrimaryKey() == null : this.getfAssocaitionPrimaryKey().equals(other.getfAssocaitionPrimaryKey()))
            && (this.getfAreaId() == null ? other.getfAreaId() == null : this.getfAreaId().equals(other.getfAreaId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfAssociationType() == null) ? 0 : getfAssociationType().hashCode());
        result = prime * result + ((getfAssocaitionPrimaryKey() == null) ? 0 : getfAssocaitionPrimaryKey().hashCode());
        result = prime * result + ((getfAreaId() == null) ? 0 : getfAreaId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fId=").append(fId);
        sb.append(", fAssociationType=").append(fAssociationType);
        sb.append(", fAssocaitionPrimaryKey=").append(fAssocaitionPrimaryKey);
        sb.append(", fAreaId=").append(fAreaId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}