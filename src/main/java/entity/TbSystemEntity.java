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
import java.sql.Date;

@Entity
@Table(name = "tb_system", schema = "report", catalog = "")
public class TbSystemEntity {
    private int id;
    private String substation;
    private Date checkTime;
    private Integer checkReason;
    private Integer deviceSum;
    private Integer checkDeviceSum;
    private Integer abnormalDeviceSum;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "substation", nullable = false, length = 64)
    public String getSubstation() {
        return substation;
    }

    public void setSubstation(String substation) {
        this.substation = substation;
    }

    @Basic
    @Column(name = "CheckTime", nullable = true)
    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    @Basic
    @Column(name = "CheckReason", nullable = true)
    public Integer getCheckReason() {
        return checkReason;
    }

    public void setCheckReason(Integer checkReason) {
        this.checkReason = checkReason;
    }

    @Basic
    @Column(name = "DeviceSum", nullable = true)
    public Integer getDeviceSum() {
        return deviceSum;
    }

    public void setDeviceSum(Integer deviceSum) {
        this.deviceSum = deviceSum;
    }

    @Basic
    @Column(name = "CheckDeviceSum", nullable = true)
    public Integer getCheckDeviceSum() {
        return checkDeviceSum;
    }

    public void setCheckDeviceSum(Integer checkDeviceSum) {
        this.checkDeviceSum = checkDeviceSum;
    }

    @Basic
    @Column(name = "AbnormalDeviceSum", nullable = true)
    public Integer getAbnormalDeviceSum() {
        return abnormalDeviceSum;
    }

    public void setAbnormalDeviceSum(Integer abnormalDeviceSum) {
        this.abnormalDeviceSum = abnormalDeviceSum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbSystemEntity that = (TbSystemEntity) o;

        if (id != that.id) return false;
        if (substation != null ? !substation.equals(that.substation) : that.substation != null) return false;
        if (checkTime != null ? !checkTime.equals(that.checkTime) : that.checkTime != null) return false;
        if (checkReason != null ? !checkReason.equals(that.checkReason) : that.checkReason != null) return false;
        if (deviceSum != null ? !deviceSum.equals(that.deviceSum) : that.deviceSum != null) return false;
        if (checkDeviceSum != null ? !checkDeviceSum.equals(that.checkDeviceSum) : that.checkDeviceSum != null)
            return false;
        if (abnormalDeviceSum != null ? !abnormalDeviceSum.equals(that.abnormalDeviceSum) : that.abnormalDeviceSum != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (substation != null ? substation.hashCode() : 0);
        result = 31 * result + (checkTime != null ? checkTime.hashCode() : 0);
        result = 31 * result + (checkReason != null ? checkReason.hashCode() : 0);
        result = 31 * result + (deviceSum != null ? deviceSum.hashCode() : 0);
        result = 31 * result + (checkDeviceSum != null ? checkDeviceSum.hashCode() : 0);
        result = 31 * result + (abnormalDeviceSum != null ? abnormalDeviceSum.hashCode() : 0);
        return result;
    }
}
