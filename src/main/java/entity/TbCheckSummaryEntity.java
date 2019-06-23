/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-18
 * @Time: 下午7:30
 * @Project: CheckReport
 */

package entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_check_summary", schema = "report", catalog = "")
public class TbCheckSummaryEntity {
    private String deviceId;
    private String deviceName;
    private byte isChecked;
    private Integer unCheckReason;
    private Integer result;
    private Byte zoneResult;
    private Byte zoneUncheckReason;
    private Byte zoneIsChecked;
    private Byte settingResult;
    private Byte settingUncheckReason;
    private Byte settingIsChecked;
    private Byte softPlateResult;
    private Byte softPlateUncheckReason;
    private Byte softPlateIsChecked;
    private Byte hardPlateResult;
    private Byte hardPlateUncheckReason;
    private Byte hardPlateIsChecked;
    private Byte discreteResult;
    private Byte discreteUncheckReason;
    private Byte discreteIsChecked;
    private Byte clockResult;
    private Byte clockUncheckReason;
    private Byte clockIsChecked;
    private Byte commStatusResult;
    private Byte commStatusUncheckReason;
    private Byte commStatusIsChecked;
    private Byte secCircuitResult;
    private Byte secCircuitUncheckReason;
    private Byte secCircuitIsChecked;
    private Byte softVersionResult;
    private Byte softVersionUncheckReason;
    private Byte softVersionIsChecked;
    private Byte selfAlarmResult;
    private Byte selfAlarmUncheckReason;
    private Byte selfAlarmIsChecked;
    private Byte gpsAlarmResult;
    private Byte gpsAlarmUncheckReason;
    private Byte gpsAlarmIsChecked;
    private Byte waveResult;
    private Byte waveUncheckReason;
    private Byte waveIsChecked;
    private Byte analogResult;
    private Byte analogUncheckReason;
    private Byte analogIsChecked;
    private Byte loopResult;
    private Byte loopUncheckReason;
    private Byte loopIsChecked;
    private Byte channelResult;
    private Byte channelUncheckReason;
    private Byte channelIsChecked;
    private Byte switchResult;
    private Byte switchUncheckReason;
    private Byte switchIsChecked;

    @Id
    @Column(name = "deviceId", nullable = false, length = 256)
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Basic
    @Column(name = "DeviceName", nullable = true, length = 64)
    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    @Basic
    @Column(name = "IsChecked", nullable = false)
    public byte getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(byte isChecked) {
        this.isChecked = isChecked;
    }

    @Basic
    @Column(name = "UnCheckReason", nullable = true)
    public Integer getUnCheckReason() {
        return unCheckReason;
    }

    public void setUnCheckReason(Integer unCheckReason) {
        this.unCheckReason = unCheckReason;
    }

    @Basic
    @Column(name = "Result", nullable = true)
    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    @Basic
    @Column(name = "ZoneResult", nullable = true)
    public Byte getZoneResult() {
        return zoneResult;
    }

    public void setZoneResult(Byte zoneResult) {
        this.zoneResult = zoneResult;
    }

    @Basic
    @Column(name = "ZoneUncheckReason", nullable = true)
    public Byte getZoneUncheckReason() {
        return zoneUncheckReason;
    }

    public void setZoneUncheckReason(Byte zoneUncheckReason) {
        this.zoneUncheckReason = zoneUncheckReason;
    }

    @Basic
    @Column(name = "ZoneIsChecked", nullable = true)
    public Byte getZoneIsChecked() {
        return zoneIsChecked;
    }

    public void setZoneIsChecked(Byte zoneIsChecked) {
        this.zoneIsChecked = zoneIsChecked;
    }

    @Basic
    @Column(name = "SettingResult", nullable = true)
    public Byte getSettingResult() {
        return settingResult;
    }

    public void setSettingResult(Byte settingResult) {
        this.settingResult = settingResult;
    }

    @Basic
    @Column(name = "SettingUncheckReason", nullable = true)
    public Byte getSettingUncheckReason() {
        return settingUncheckReason;
    }

    public void setSettingUncheckReason(Byte settingUncheckReason) {
        this.settingUncheckReason = settingUncheckReason;
    }

    @Basic
    @Column(name = "SettingIsChecked", nullable = true)
    public Byte getSettingIsChecked() {
        return settingIsChecked;
    }

    public void setSettingIsChecked(Byte settingIsChecked) {
        this.settingIsChecked = settingIsChecked;
    }

    @Basic
    @Column(name = "SoftPlateResult", nullable = true)
    public Byte getSoftPlateResult() {
        return softPlateResult;
    }

    public void setSoftPlateResult(Byte softPlateResult) {
        this.softPlateResult = softPlateResult;
    }

    @Basic
    @Column(name = "SoftPlateUncheckReason", nullable = true)
    public Byte getSoftPlateUncheckReason() {
        return softPlateUncheckReason;
    }

    public void setSoftPlateUncheckReason(Byte softPlateUncheckReason) {
        this.softPlateUncheckReason = softPlateUncheckReason;
    }

    @Basic
    @Column(name = "SoftPlateIsChecked", nullable = true)
    public Byte getSoftPlateIsChecked() {
        return softPlateIsChecked;
    }

    public void setSoftPlateIsChecked(Byte softPlateIsChecked) {
        this.softPlateIsChecked = softPlateIsChecked;
    }

    @Basic
    @Column(name = "HardPlateResult", nullable = true)
    public Byte getHardPlateResult() {
        return hardPlateResult;
    }

    public void setHardPlateResult(Byte hardPlateResult) {
        this.hardPlateResult = hardPlateResult;
    }

    @Basic
    @Column(name = "HardPlateUncheckReason", nullable = true)
    public Byte getHardPlateUncheckReason() {
        return hardPlateUncheckReason;
    }

    public void setHardPlateUncheckReason(Byte hardPlateUncheckReason) {
        this.hardPlateUncheckReason = hardPlateUncheckReason;
    }

    @Basic
    @Column(name = "HardPlateIsChecked", nullable = true)
    public Byte getHardPlateIsChecked() {
        return hardPlateIsChecked;
    }

    public void setHardPlateIsChecked(Byte hardPlateIsChecked) {
        this.hardPlateIsChecked = hardPlateIsChecked;
    }

    @Basic
    @Column(name = "DiscreteResult", nullable = true)
    public Byte getDiscreteResult() {
        return discreteResult;
    }

    public void setDiscreteResult(Byte discreteResult) {
        this.discreteResult = discreteResult;
    }

    @Basic
    @Column(name = "DiscreteUncheckReason", nullable = true)
    public Byte getDiscreteUncheckReason() {
        return discreteUncheckReason;
    }

    public void setDiscreteUncheckReason(Byte discreteUncheckReason) {
        this.discreteUncheckReason = discreteUncheckReason;
    }

    @Basic
    @Column(name = "DiscreteIsChecked", nullable = true)
    public Byte getDiscreteIsChecked() {
        return discreteIsChecked;
    }

    public void setDiscreteIsChecked(Byte discreteIsChecked) {
        this.discreteIsChecked = discreteIsChecked;
    }

    @Basic
    @Column(name = "ClockResult", nullable = true)
    public Byte getClockResult() {
        return clockResult;
    }

    public void setClockResult(Byte clockResult) {
        this.clockResult = clockResult;
    }

    @Basic
    @Column(name = "ClockUncheckReason", nullable = true)
    public Byte getClockUncheckReason() {
        return clockUncheckReason;
    }

    public void setClockUncheckReason(Byte clockUncheckReason) {
        this.clockUncheckReason = clockUncheckReason;
    }

    @Basic
    @Column(name = "ClockIsChecked", nullable = true)
    public Byte getClockIsChecked() {
        return clockIsChecked;
    }

    public void setClockIsChecked(Byte clockIsChecked) {
        this.clockIsChecked = clockIsChecked;
    }

    @Basic
    @Column(name = "CommStatusResult", nullable = true)
    public Byte getCommStatusResult() {
        return commStatusResult;
    }

    public void setCommStatusResult(Byte commStatusResult) {
        this.commStatusResult = commStatusResult;
    }

    @Basic
    @Column(name = "CommStatusUncheckReason", nullable = true)
    public Byte getCommStatusUncheckReason() {
        return commStatusUncheckReason;
    }

    public void setCommStatusUncheckReason(Byte commStatusUncheckReason) {
        this.commStatusUncheckReason = commStatusUncheckReason;
    }

    @Basic
    @Column(name = "CommStatusIsChecked", nullable = true)
    public Byte getCommStatusIsChecked() {
        return commStatusIsChecked;
    }

    public void setCommStatusIsChecked(Byte commStatusIsChecked) {
        this.commStatusIsChecked = commStatusIsChecked;
    }

    @Basic
    @Column(name = "SecCircuitResult", nullable = true)
    public Byte getSecCircuitResult() {
        return secCircuitResult;
    }

    public void setSecCircuitResult(Byte secCircuitResult) {
        this.secCircuitResult = secCircuitResult;
    }

    @Basic
    @Column(name = "SecCircuitUncheckReason", nullable = true)
    public Byte getSecCircuitUncheckReason() {
        return secCircuitUncheckReason;
    }

    public void setSecCircuitUncheckReason(Byte secCircuitUncheckReason) {
        this.secCircuitUncheckReason = secCircuitUncheckReason;
    }

    @Basic
    @Column(name = "SecCircuitIsChecked", nullable = true)
    public Byte getSecCircuitIsChecked() {
        return secCircuitIsChecked;
    }

    public void setSecCircuitIsChecked(Byte secCircuitIsChecked) {
        this.secCircuitIsChecked = secCircuitIsChecked;
    }

    @Basic
    @Column(name = "SoftVersionResult", nullable = true)
    public Byte getSoftVersionResult() {
        return softVersionResult;
    }

    public void setSoftVersionResult(Byte softVersionResult) {
        this.softVersionResult = softVersionResult;
    }

    @Basic
    @Column(name = "SoftVersionUncheckReason", nullable = true)
    public Byte getSoftVersionUncheckReason() {
        return softVersionUncheckReason;
    }

    public void setSoftVersionUncheckReason(Byte softVersionUncheckReason) {
        this.softVersionUncheckReason = softVersionUncheckReason;
    }

    @Basic
    @Column(name = "SoftVersionIsChecked", nullable = true)
    public Byte getSoftVersionIsChecked() {
        return softVersionIsChecked;
    }

    public void setSoftVersionIsChecked(Byte softVersionIsChecked) {
        this.softVersionIsChecked = softVersionIsChecked;
    }

    @Basic
    @Column(name = "SelfAlarmResult", nullable = true)
    public Byte getSelfAlarmResult() {
        return selfAlarmResult;
    }

    public void setSelfAlarmResult(Byte selfAlarmResult) {
        this.selfAlarmResult = selfAlarmResult;
    }

    @Basic
    @Column(name = "SelfAlarmUncheckReason", nullable = true)
    public Byte getSelfAlarmUncheckReason() {
        return selfAlarmUncheckReason;
    }

    public void setSelfAlarmUncheckReason(Byte selfAlarmUncheckReason) {
        this.selfAlarmUncheckReason = selfAlarmUncheckReason;
    }

    @Basic
    @Column(name = "SelfAlarmIsChecked", nullable = true)
    public Byte getSelfAlarmIsChecked() {
        return selfAlarmIsChecked;
    }

    public void setSelfAlarmIsChecked(Byte selfAlarmIsChecked) {
        this.selfAlarmIsChecked = selfAlarmIsChecked;
    }

    @Basic
    @Column(name = "GpsAlarmResult", nullable = true)
    public Byte getGpsAlarmResult() {
        return gpsAlarmResult;
    }

    public void setGpsAlarmResult(Byte gpsAlarmResult) {
        this.gpsAlarmResult = gpsAlarmResult;
    }

    @Basic
    @Column(name = "GpsAlarmUncheckReason", nullable = true)
    public Byte getGpsAlarmUncheckReason() {
        return gpsAlarmUncheckReason;
    }

    public void setGpsAlarmUncheckReason(Byte gpsAlarmUncheckReason) {
        this.gpsAlarmUncheckReason = gpsAlarmUncheckReason;
    }

    @Basic
    @Column(name = "GpsAlarmIsChecked", nullable = true)
    public Byte getGpsAlarmIsChecked() {
        return gpsAlarmIsChecked;
    }

    public void setGpsAlarmIsChecked(Byte gpsAlarmIsChecked) {
        this.gpsAlarmIsChecked = gpsAlarmIsChecked;
    }

    @Basic
    @Column(name = "WaveResult", nullable = true)
    public Byte getWaveResult() {
        return waveResult;
    }

    public void setWaveResult(Byte waveResult) {
        this.waveResult = waveResult;
    }

    @Basic
    @Column(name = "WaveUncheckReason", nullable = true)
    public Byte getWaveUncheckReason() {
        return waveUncheckReason;
    }

    public void setWaveUncheckReason(Byte waveUncheckReason) {
        this.waveUncheckReason = waveUncheckReason;
    }

    @Basic
    @Column(name = "WaveIsChecked", nullable = true)
    public Byte getWaveIsChecked() {
        return waveIsChecked;
    }

    public void setWaveIsChecked(Byte waveIsChecked) {
        this.waveIsChecked = waveIsChecked;
    }

    @Basic
    @Column(name = "AnalogResult", nullable = true)
    public Byte getAnalogResult() {
        return analogResult;
    }

    public void setAnalogResult(Byte analogResult) {
        this.analogResult = analogResult;
    }

    @Basic
    @Column(name = "AnalogUncheckReason", nullable = true)
    public Byte getAnalogUncheckReason() {
        return analogUncheckReason;
    }

    public void setAnalogUncheckReason(Byte analogUncheckReason) {
        this.analogUncheckReason = analogUncheckReason;
    }

    @Basic
    @Column(name = "AnalogIsChecked", nullable = true)
    public Byte getAnalogIsChecked() {
        return analogIsChecked;
    }

    public void setAnalogIsChecked(Byte analogIsChecked) {
        this.analogIsChecked = analogIsChecked;
    }

    @Basic
    @Column(name = "LoopResult", nullable = true)
    public Byte getLoopResult() {
        return loopResult;
    }

    public void setLoopResult(Byte loopResult) {
        this.loopResult = loopResult;
    }

    @Basic
    @Column(name = "LoopUncheckReason", nullable = true)
    public Byte getLoopUncheckReason() {
        return loopUncheckReason;
    }

    public void setLoopUncheckReason(Byte loopUncheckReason) {
        this.loopUncheckReason = loopUncheckReason;
    }

    @Basic
    @Column(name = "LoopIsChecked", nullable = true)
    public Byte getLoopIsChecked() {
        return loopIsChecked;
    }

    public void setLoopIsChecked(Byte loopIsChecked) {
        this.loopIsChecked = loopIsChecked;
    }

    @Basic
    @Column(name = "ChannelResult", nullable = true)
    public Byte getChannelResult() {
        return channelResult;
    }

    public void setChannelResult(Byte channelResult) {
        this.channelResult = channelResult;
    }

    @Basic
    @Column(name = "ChannelUncheckReason", nullable = true)
    public Byte getChannelUncheckReason() {
        return channelUncheckReason;
    }

    public void setChannelUncheckReason(Byte channelUncheckReason) {
        this.channelUncheckReason = channelUncheckReason;
    }

    @Basic
    @Column(name = "ChannelIsChecked", nullable = true)
    public Byte getChannelIsChecked() {
        return channelIsChecked;
    }

    public void setChannelIsChecked(Byte channelIsChecked) {
        this.channelIsChecked = channelIsChecked;
    }

    @Basic
    @Column(name = "SwitchResult", nullable = true)
    public Byte getSwitchResult() {
        return switchResult;
    }

    public void setSwitchResult(Byte switchResult) {
        this.switchResult = switchResult;
    }

    @Basic
    @Column(name = "SwitchUncheckReason", nullable = true)
    public Byte getSwitchUncheckReason() {
        return switchUncheckReason;
    }

    public void setSwitchUncheckReason(Byte switchUncheckReason) {
        this.switchUncheckReason = switchUncheckReason;
    }

    @Basic
    @Column(name = "SwitchIsChecked", nullable = true)
    public Byte getSwitchIsChecked() {
        return switchIsChecked;
    }

    public void setSwitchIsChecked(Byte switchIsChecked) {
        this.switchIsChecked = switchIsChecked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbCheckSummaryEntity that = (TbCheckSummaryEntity) o;

        if (isChecked != that.isChecked) return false;
        if (deviceId != null ? !deviceId.equals(that.deviceId) : that.deviceId != null) return false;
        if (deviceName != null ? !deviceName.equals(that.deviceName) : that.deviceName != null) return false;
        if (unCheckReason != null ? !unCheckReason.equals(that.unCheckReason) : that.unCheckReason != null)
            return false;
        if (result != null ? !result.equals(that.result) : that.result != null) return false;
        if (zoneResult != null ? !zoneResult.equals(that.zoneResult) : that.zoneResult != null) return false;
        if (zoneUncheckReason != null ? !zoneUncheckReason.equals(that.zoneUncheckReason) : that.zoneUncheckReason != null)
            return false;
        if (zoneIsChecked != null ? !zoneIsChecked.equals(that.zoneIsChecked) : that.zoneIsChecked != null)
            return false;
        if (settingResult != null ? !settingResult.equals(that.settingResult) : that.settingResult != null)
            return false;
        if (settingUncheckReason != null ? !settingUncheckReason.equals(that.settingUncheckReason) : that.settingUncheckReason != null)
            return false;
        if (settingIsChecked != null ? !settingIsChecked.equals(that.settingIsChecked) : that.settingIsChecked != null)
            return false;
        if (softPlateResult != null ? !softPlateResult.equals(that.softPlateResult) : that.softPlateResult != null)
            return false;
        if (softPlateUncheckReason != null ? !softPlateUncheckReason.equals(that.softPlateUncheckReason) : that.softPlateUncheckReason != null)
            return false;
        if (softPlateIsChecked != null ? !softPlateIsChecked.equals(that.softPlateIsChecked) : that.softPlateIsChecked != null)
            return false;
        if (hardPlateResult != null ? !hardPlateResult.equals(that.hardPlateResult) : that.hardPlateResult != null)
            return false;
        if (hardPlateUncheckReason != null ? !hardPlateUncheckReason.equals(that.hardPlateUncheckReason) : that.hardPlateUncheckReason != null)
            return false;
        if (hardPlateIsChecked != null ? !hardPlateIsChecked.equals(that.hardPlateIsChecked) : that.hardPlateIsChecked != null)
            return false;
        if (discreteResult != null ? !discreteResult.equals(that.discreteResult) : that.discreteResult != null)
            return false;
        if (discreteUncheckReason != null ? !discreteUncheckReason.equals(that.discreteUncheckReason) : that.discreteUncheckReason != null)
            return false;
        if (discreteIsChecked != null ? !discreteIsChecked.equals(that.discreteIsChecked) : that.discreteIsChecked != null)
            return false;
        if (clockResult != null ? !clockResult.equals(that.clockResult) : that.clockResult != null) return false;
        if (clockUncheckReason != null ? !clockUncheckReason.equals(that.clockUncheckReason) : that.clockUncheckReason != null)
            return false;
        if (clockIsChecked != null ? !clockIsChecked.equals(that.clockIsChecked) : that.clockIsChecked != null)
            return false;
        if (commStatusResult != null ? !commStatusResult.equals(that.commStatusResult) : that.commStatusResult != null)
            return false;
        if (commStatusUncheckReason != null ? !commStatusUncheckReason.equals(that.commStatusUncheckReason) : that.commStatusUncheckReason != null)
            return false;
        if (commStatusIsChecked != null ? !commStatusIsChecked.equals(that.commStatusIsChecked) : that.commStatusIsChecked != null)
            return false;
        if (secCircuitResult != null ? !secCircuitResult.equals(that.secCircuitResult) : that.secCircuitResult != null)
            return false;
        if (secCircuitUncheckReason != null ? !secCircuitUncheckReason.equals(that.secCircuitUncheckReason) : that.secCircuitUncheckReason != null)
            return false;
        if (secCircuitIsChecked != null ? !secCircuitIsChecked.equals(that.secCircuitIsChecked) : that.secCircuitIsChecked != null)
            return false;
        if (softVersionResult != null ? !softVersionResult.equals(that.softVersionResult) : that.softVersionResult != null)
            return false;
        if (softVersionUncheckReason != null ? !softVersionUncheckReason.equals(that.softVersionUncheckReason) : that.softVersionUncheckReason != null)
            return false;
        if (softVersionIsChecked != null ? !softVersionIsChecked.equals(that.softVersionIsChecked) : that.softVersionIsChecked != null)
            return false;
        if (selfAlarmResult != null ? !selfAlarmResult.equals(that.selfAlarmResult) : that.selfAlarmResult != null)
            return false;
        if (selfAlarmUncheckReason != null ? !selfAlarmUncheckReason.equals(that.selfAlarmUncheckReason) : that.selfAlarmUncheckReason != null)
            return false;
        if (selfAlarmIsChecked != null ? !selfAlarmIsChecked.equals(that.selfAlarmIsChecked) : that.selfAlarmIsChecked != null)
            return false;
        if (gpsAlarmResult != null ? !gpsAlarmResult.equals(that.gpsAlarmResult) : that.gpsAlarmResult != null)
            return false;
        if (gpsAlarmUncheckReason != null ? !gpsAlarmUncheckReason.equals(that.gpsAlarmUncheckReason) : that.gpsAlarmUncheckReason != null)
            return false;
        if (gpsAlarmIsChecked != null ? !gpsAlarmIsChecked.equals(that.gpsAlarmIsChecked) : that.gpsAlarmIsChecked != null)
            return false;
        if (waveResult != null ? !waveResult.equals(that.waveResult) : that.waveResult != null) return false;
        if (waveUncheckReason != null ? !waveUncheckReason.equals(that.waveUncheckReason) : that.waveUncheckReason != null)
            return false;
        if (waveIsChecked != null ? !waveIsChecked.equals(that.waveIsChecked) : that.waveIsChecked != null)
            return false;
        if (analogResult != null ? !analogResult.equals(that.analogResult) : that.analogResult != null) return false;
        if (analogUncheckReason != null ? !analogUncheckReason.equals(that.analogUncheckReason) : that.analogUncheckReason != null)
            return false;
        if (analogIsChecked != null ? !analogIsChecked.equals(that.analogIsChecked) : that.analogIsChecked != null)
            return false;
        if (loopResult != null ? !loopResult.equals(that.loopResult) : that.loopResult != null) return false;
        if (loopUncheckReason != null ? !loopUncheckReason.equals(that.loopUncheckReason) : that.loopUncheckReason != null)
            return false;
        if (loopIsChecked != null ? !loopIsChecked.equals(that.loopIsChecked) : that.loopIsChecked != null)
            return false;
        if (channelResult != null ? !channelResult.equals(that.channelResult) : that.channelResult != null)
            return false;
        if (channelUncheckReason != null ? !channelUncheckReason.equals(that.channelUncheckReason) : that.channelUncheckReason != null)
            return false;
        if (channelIsChecked != null ? !channelIsChecked.equals(that.channelIsChecked) : that.channelIsChecked != null)
            return false;
        if (switchResult != null ? !switchResult.equals(that.switchResult) : that.switchResult != null) return false;
        if (switchUncheckReason != null ? !switchUncheckReason.equals(that.switchUncheckReason) : that.switchUncheckReason != null)
            return false;
        if (switchIsChecked != null ? !switchIsChecked.equals(that.switchIsChecked) : that.switchIsChecked != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result1 = deviceId != null ? deviceId.hashCode() : 0;
        result1 = 31 * result1 + (deviceName != null ? deviceName.hashCode() : 0);
        result1 = 31 * result1 + (int) isChecked;
        result1 = 31 * result1 + (unCheckReason != null ? unCheckReason.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        result1 = 31 * result1 + (zoneResult != null ? zoneResult.hashCode() : 0);
        result1 = 31 * result1 + (zoneUncheckReason != null ? zoneUncheckReason.hashCode() : 0);
        result1 = 31 * result1 + (zoneIsChecked != null ? zoneIsChecked.hashCode() : 0);
        result1 = 31 * result1 + (settingResult != null ? settingResult.hashCode() : 0);
        result1 = 31 * result1 + (settingUncheckReason != null ? settingUncheckReason.hashCode() : 0);
        result1 = 31 * result1 + (settingIsChecked != null ? settingIsChecked.hashCode() : 0);
        result1 = 31 * result1 + (softPlateResult != null ? softPlateResult.hashCode() : 0);
        result1 = 31 * result1 + (softPlateUncheckReason != null ? softPlateUncheckReason.hashCode() : 0);
        result1 = 31 * result1 + (softPlateIsChecked != null ? softPlateIsChecked.hashCode() : 0);
        result1 = 31 * result1 + (hardPlateResult != null ? hardPlateResult.hashCode() : 0);
        result1 = 31 * result1 + (hardPlateUncheckReason != null ? hardPlateUncheckReason.hashCode() : 0);
        result1 = 31 * result1 + (hardPlateIsChecked != null ? hardPlateIsChecked.hashCode() : 0);
        result1 = 31 * result1 + (discreteResult != null ? discreteResult.hashCode() : 0);
        result1 = 31 * result1 + (discreteUncheckReason != null ? discreteUncheckReason.hashCode() : 0);
        result1 = 31 * result1 + (discreteIsChecked != null ? discreteIsChecked.hashCode() : 0);
        result1 = 31 * result1 + (clockResult != null ? clockResult.hashCode() : 0);
        result1 = 31 * result1 + (clockUncheckReason != null ? clockUncheckReason.hashCode() : 0);
        result1 = 31 * result1 + (clockIsChecked != null ? clockIsChecked.hashCode() : 0);
        result1 = 31 * result1 + (commStatusResult != null ? commStatusResult.hashCode() : 0);
        result1 = 31 * result1 + (commStatusUncheckReason != null ? commStatusUncheckReason.hashCode() : 0);
        result1 = 31 * result1 + (commStatusIsChecked != null ? commStatusIsChecked.hashCode() : 0);
        result1 = 31 * result1 + (secCircuitResult != null ? secCircuitResult.hashCode() : 0);
        result1 = 31 * result1 + (secCircuitUncheckReason != null ? secCircuitUncheckReason.hashCode() : 0);
        result1 = 31 * result1 + (secCircuitIsChecked != null ? secCircuitIsChecked.hashCode() : 0);
        result1 = 31 * result1 + (softVersionResult != null ? softVersionResult.hashCode() : 0);
        result1 = 31 * result1 + (softVersionUncheckReason != null ? softVersionUncheckReason.hashCode() : 0);
        result1 = 31 * result1 + (softVersionIsChecked != null ? softVersionIsChecked.hashCode() : 0);
        result1 = 31 * result1 + (selfAlarmResult != null ? selfAlarmResult.hashCode() : 0);
        result1 = 31 * result1 + (selfAlarmUncheckReason != null ? selfAlarmUncheckReason.hashCode() : 0);
        result1 = 31 * result1 + (selfAlarmIsChecked != null ? selfAlarmIsChecked.hashCode() : 0);
        result1 = 31 * result1 + (gpsAlarmResult != null ? gpsAlarmResult.hashCode() : 0);
        result1 = 31 * result1 + (gpsAlarmUncheckReason != null ? gpsAlarmUncheckReason.hashCode() : 0);
        result1 = 31 * result1 + (gpsAlarmIsChecked != null ? gpsAlarmIsChecked.hashCode() : 0);
        result1 = 31 * result1 + (waveResult != null ? waveResult.hashCode() : 0);
        result1 = 31 * result1 + (waveUncheckReason != null ? waveUncheckReason.hashCode() : 0);
        result1 = 31 * result1 + (waveIsChecked != null ? waveIsChecked.hashCode() : 0);
        result1 = 31 * result1 + (analogResult != null ? analogResult.hashCode() : 0);
        result1 = 31 * result1 + (analogUncheckReason != null ? analogUncheckReason.hashCode() : 0);
        result1 = 31 * result1 + (analogIsChecked != null ? analogIsChecked.hashCode() : 0);
        result1 = 31 * result1 + (loopResult != null ? loopResult.hashCode() : 0);
        result1 = 31 * result1 + (loopUncheckReason != null ? loopUncheckReason.hashCode() : 0);
        result1 = 31 * result1 + (loopIsChecked != null ? loopIsChecked.hashCode() : 0);
        result1 = 31 * result1 + (channelResult != null ? channelResult.hashCode() : 0);
        result1 = 31 * result1 + (channelUncheckReason != null ? channelUncheckReason.hashCode() : 0);
        result1 = 31 * result1 + (channelIsChecked != null ? channelIsChecked.hashCode() : 0);
        result1 = 31 * result1 + (switchResult != null ? switchResult.hashCode() : 0);
        result1 = 31 * result1 + (switchUncheckReason != null ? switchUncheckReason.hashCode() : 0);
        result1 = 31 * result1 + (switchIsChecked != null ? switchIsChecked.hashCode() : 0);
        return result1;
    }
}
