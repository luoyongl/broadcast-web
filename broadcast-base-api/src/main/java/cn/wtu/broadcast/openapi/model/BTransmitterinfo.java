package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;

public class BTransmitterinfo implements Serializable {
    private Integer fId;

    private String fTransmitterId;

    private String fTransmitterName;

    private String fAdapterName;

    private String fRegion;

    private String fInstallArea;

    private String fPhysicalCode;

    private String fResourcecode;

    private Integer fTransmitterState;

    private String fTransmitterOutputFm;

    private String fOutputPower;

    private String fEquipmentTemperature;

    private String fTransmitterVoltage;

    private String fTransmitterCurrent;

    private String fTransmitterReflectionPower;

    private String fLeftChannelModulation;

    private String fRightChannelModulation;

    private String fHarmonicChannelModulation;

    private String fDifferentialChannelModulation;

    private Integer fRfLockState;

    private Integer pllLockState;

    private String fBackTime;

    private Integer fAdapterId;

    private static final long serialVersionUID = 1L;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getfTransmitterId() {
        return fTransmitterId;
    }

    public void setfTransmitterId(String fTransmitterId) {
        this.fTransmitterId = fTransmitterId == null ? null : fTransmitterId.trim();
    }

    public String getfTransmitterName() {
        return fTransmitterName;
    }

    public void setfTransmitterName(String fTransmitterName) {
        this.fTransmitterName = fTransmitterName == null ? null : fTransmitterName.trim();
    }

    public String getfAdapterName() {
        return fAdapterName;
    }

    public void setfAdapterName(String fAdapterName) {
        this.fAdapterName = fAdapterName == null ? null : fAdapterName.trim();
    }

    public String getfRegion() {
        return fRegion;
    }

    public void setfRegion(String fRegion) {
        this.fRegion = fRegion == null ? null : fRegion.trim();
    }

    public String getfInstallArea() {
        return fInstallArea;
    }

    public void setfInstallArea(String fInstallArea) {
        this.fInstallArea = fInstallArea == null ? null : fInstallArea.trim();
    }

    public String getfPhysicalCode() {
        return fPhysicalCode;
    }

    public void setfPhysicalCode(String fPhysicalCode) {
        this.fPhysicalCode = fPhysicalCode == null ? null : fPhysicalCode.trim();
    }

    public String getfResourcecode() {
        return fResourcecode;
    }

    public void setfResourcecode(String fResourcecode) {
        this.fResourcecode = fResourcecode == null ? null : fResourcecode.trim();
    }

    public Integer getfTransmitterState() {
        return fTransmitterState;
    }

    public void setfTransmitterState(Integer fTransmitterState) {
        this.fTransmitterState = fTransmitterState;
    }

    public String getfTransmitterOutputFm() {
        return fTransmitterOutputFm;
    }

    public void setfTransmitterOutputFm(String fTransmitterOutputFm) {
        this.fTransmitterOutputFm = fTransmitterOutputFm == null ? null : fTransmitterOutputFm.trim();
    }

    public String getfOutputPower() {
        return fOutputPower;
    }

    public void setfOutputPower(String fOutputPower) {
        this.fOutputPower = fOutputPower == null ? null : fOutputPower.trim();
    }

    public String getfEquipmentTemperature() {
        return fEquipmentTemperature;
    }

    public void setfEquipmentTemperature(String fEquipmentTemperature) {
        this.fEquipmentTemperature = fEquipmentTemperature == null ? null : fEquipmentTemperature.trim();
    }

    public String getfTransmitterVoltage() {
        return fTransmitterVoltage;
    }

    public void setfTransmitterVoltage(String fTransmitterVoltage) {
        this.fTransmitterVoltage = fTransmitterVoltage == null ? null : fTransmitterVoltage.trim();
    }

    public String getfTransmitterCurrent() {
        return fTransmitterCurrent;
    }

    public void setfTransmitterCurrent(String fTransmitterCurrent) {
        this.fTransmitterCurrent = fTransmitterCurrent == null ? null : fTransmitterCurrent.trim();
    }

    public String getfTransmitterReflectionPower() {
        return fTransmitterReflectionPower;
    }

    public void setfTransmitterReflectionPower(String fTransmitterReflectionPower) {
        this.fTransmitterReflectionPower = fTransmitterReflectionPower == null ? null : fTransmitterReflectionPower.trim();
    }

    public String getfLeftChannelModulation() {
        return fLeftChannelModulation;
    }

    public void setfLeftChannelModulation(String fLeftChannelModulation) {
        this.fLeftChannelModulation = fLeftChannelModulation == null ? null : fLeftChannelModulation.trim();
    }

    public String getfRightChannelModulation() {
        return fRightChannelModulation;
    }

    public void setfRightChannelModulation(String fRightChannelModulation) {
        this.fRightChannelModulation = fRightChannelModulation == null ? null : fRightChannelModulation.trim();
    }

    public String getfHarmonicChannelModulation() {
        return fHarmonicChannelModulation;
    }

    public void setfHarmonicChannelModulation(String fHarmonicChannelModulation) {
        this.fHarmonicChannelModulation = fHarmonicChannelModulation == null ? null : fHarmonicChannelModulation.trim();
    }

    public String getfDifferentialChannelModulation() {
        return fDifferentialChannelModulation;
    }

    public void setfDifferentialChannelModulation(String fDifferentialChannelModulation) {
        this.fDifferentialChannelModulation = fDifferentialChannelModulation == null ? null : fDifferentialChannelModulation.trim();
    }

    public Integer getfRfLockState() {
        return fRfLockState;
    }

    public void setfRfLockState(Integer fRfLockState) {
        this.fRfLockState = fRfLockState;
    }

    public Integer getPllLockState() {
        return pllLockState;
    }

    public void setPllLockState(Integer pllLockState) {
        this.pllLockState = pllLockState;
    }

    public String getfBackTime() {
        return fBackTime;
    }

    public void setfBackTime(String fBackTime) {
        this.fBackTime = fBackTime == null ? null : fBackTime.trim();
    }

    public Integer getfAdapterId() {
        return fAdapterId;
    }

    public void setfAdapterId(Integer fAdapterId) {
        this.fAdapterId = fAdapterId;
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
        BTransmitterinfo other = (BTransmitterinfo) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfTransmitterId() == null ? other.getfTransmitterId() == null : this.getfTransmitterId().equals(other.getfTransmitterId()))
            && (this.getfTransmitterName() == null ? other.getfTransmitterName() == null : this.getfTransmitterName().equals(other.getfTransmitterName()))
            && (this.getfAdapterName() == null ? other.getfAdapterName() == null : this.getfAdapterName().equals(other.getfAdapterName()))
            && (this.getfRegion() == null ? other.getfRegion() == null : this.getfRegion().equals(other.getfRegion()))
            && (this.getfInstallArea() == null ? other.getfInstallArea() == null : this.getfInstallArea().equals(other.getfInstallArea()))
            && (this.getfPhysicalCode() == null ? other.getfPhysicalCode() == null : this.getfPhysicalCode().equals(other.getfPhysicalCode()))
            && (this.getfResourcecode() == null ? other.getfResourcecode() == null : this.getfResourcecode().equals(other.getfResourcecode()))
            && (this.getfTransmitterState() == null ? other.getfTransmitterState() == null : this.getfTransmitterState().equals(other.getfTransmitterState()))
            && (this.getfTransmitterOutputFm() == null ? other.getfTransmitterOutputFm() == null : this.getfTransmitterOutputFm().equals(other.getfTransmitterOutputFm()))
            && (this.getfOutputPower() == null ? other.getfOutputPower() == null : this.getfOutputPower().equals(other.getfOutputPower()))
            && (this.getfEquipmentTemperature() == null ? other.getfEquipmentTemperature() == null : this.getfEquipmentTemperature().equals(other.getfEquipmentTemperature()))
            && (this.getfTransmitterVoltage() == null ? other.getfTransmitterVoltage() == null : this.getfTransmitterVoltage().equals(other.getfTransmitterVoltage()))
            && (this.getfTransmitterCurrent() == null ? other.getfTransmitterCurrent() == null : this.getfTransmitterCurrent().equals(other.getfTransmitterCurrent()))
            && (this.getfTransmitterReflectionPower() == null ? other.getfTransmitterReflectionPower() == null : this.getfTransmitterReflectionPower().equals(other.getfTransmitterReflectionPower()))
            && (this.getfLeftChannelModulation() == null ? other.getfLeftChannelModulation() == null : this.getfLeftChannelModulation().equals(other.getfLeftChannelModulation()))
            && (this.getfRightChannelModulation() == null ? other.getfRightChannelModulation() == null : this.getfRightChannelModulation().equals(other.getfRightChannelModulation()))
            && (this.getfHarmonicChannelModulation() == null ? other.getfHarmonicChannelModulation() == null : this.getfHarmonicChannelModulation().equals(other.getfHarmonicChannelModulation()))
            && (this.getfDifferentialChannelModulation() == null ? other.getfDifferentialChannelModulation() == null : this.getfDifferentialChannelModulation().equals(other.getfDifferentialChannelModulation()))
            && (this.getfRfLockState() == null ? other.getfRfLockState() == null : this.getfRfLockState().equals(other.getfRfLockState()))
            && (this.getPllLockState() == null ? other.getPllLockState() == null : this.getPllLockState().equals(other.getPllLockState()))
            && (this.getfBackTime() == null ? other.getfBackTime() == null : this.getfBackTime().equals(other.getfBackTime()))
            && (this.getfAdapterId() == null ? other.getfAdapterId() == null : this.getfAdapterId().equals(other.getfAdapterId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfTransmitterId() == null) ? 0 : getfTransmitterId().hashCode());
        result = prime * result + ((getfTransmitterName() == null) ? 0 : getfTransmitterName().hashCode());
        result = prime * result + ((getfAdapterName() == null) ? 0 : getfAdapterName().hashCode());
        result = prime * result + ((getfRegion() == null) ? 0 : getfRegion().hashCode());
        result = prime * result + ((getfInstallArea() == null) ? 0 : getfInstallArea().hashCode());
        result = prime * result + ((getfPhysicalCode() == null) ? 0 : getfPhysicalCode().hashCode());
        result = prime * result + ((getfResourcecode() == null) ? 0 : getfResourcecode().hashCode());
        result = prime * result + ((getfTransmitterState() == null) ? 0 : getfTransmitterState().hashCode());
        result = prime * result + ((getfTransmitterOutputFm() == null) ? 0 : getfTransmitterOutputFm().hashCode());
        result = prime * result + ((getfOutputPower() == null) ? 0 : getfOutputPower().hashCode());
        result = prime * result + ((getfEquipmentTemperature() == null) ? 0 : getfEquipmentTemperature().hashCode());
        result = prime * result + ((getfTransmitterVoltage() == null) ? 0 : getfTransmitterVoltage().hashCode());
        result = prime * result + ((getfTransmitterCurrent() == null) ? 0 : getfTransmitterCurrent().hashCode());
        result = prime * result + ((getfTransmitterReflectionPower() == null) ? 0 : getfTransmitterReflectionPower().hashCode());
        result = prime * result + ((getfLeftChannelModulation() == null) ? 0 : getfLeftChannelModulation().hashCode());
        result = prime * result + ((getfRightChannelModulation() == null) ? 0 : getfRightChannelModulation().hashCode());
        result = prime * result + ((getfHarmonicChannelModulation() == null) ? 0 : getfHarmonicChannelModulation().hashCode());
        result = prime * result + ((getfDifferentialChannelModulation() == null) ? 0 : getfDifferentialChannelModulation().hashCode());
        result = prime * result + ((getfRfLockState() == null) ? 0 : getfRfLockState().hashCode());
        result = prime * result + ((getPllLockState() == null) ? 0 : getPllLockState().hashCode());
        result = prime * result + ((getfBackTime() == null) ? 0 : getfBackTime().hashCode());
        result = prime * result + ((getfAdapterId() == null) ? 0 : getfAdapterId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fId=").append(fId);
        sb.append(", fTransmitterId=").append(fTransmitterId);
        sb.append(", fTransmitterName=").append(fTransmitterName);
        sb.append(", fAdapterName=").append(fAdapterName);
        sb.append(", fRegion=").append(fRegion);
        sb.append(", fInstallArea=").append(fInstallArea);
        sb.append(", fPhysicalCode=").append(fPhysicalCode);
        sb.append(", fResourcecode=").append(fResourcecode);
        sb.append(", fTransmitterState=").append(fTransmitterState);
        sb.append(", fTransmitterOutputFm=").append(fTransmitterOutputFm);
        sb.append(", fOutputPower=").append(fOutputPower);
        sb.append(", fEquipmentTemperature=").append(fEquipmentTemperature);
        sb.append(", fTransmitterVoltage=").append(fTransmitterVoltage);
        sb.append(", fTransmitterCurrent=").append(fTransmitterCurrent);
        sb.append(", fTransmitterReflectionPower=").append(fTransmitterReflectionPower);
        sb.append(", fLeftChannelModulation=").append(fLeftChannelModulation);
        sb.append(", fRightChannelModulation=").append(fRightChannelModulation);
        sb.append(", fHarmonicChannelModulation=").append(fHarmonicChannelModulation);
        sb.append(", fDifferentialChannelModulation=").append(fDifferentialChannelModulation);
        sb.append(", fRfLockState=").append(fRfLockState);
        sb.append(", pllLockState=").append(pllLockState);
        sb.append(", fBackTime=").append(fBackTime);
        sb.append(", fAdapterId=").append(fAdapterId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}