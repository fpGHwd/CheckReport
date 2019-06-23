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
@Table(name = "tb_check_diff_self_alarm", schema = "report", catalog = "")
public class TbCheckDiffSelfAlarmEntity {
    private int id;
    private String deviceId;
    private String pointId;
    private String pointName;
    private Integer realVal;
    private Date checkTime;
    private Byte isDifferent;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "DeviceId", nullable = false, length = 256)
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Basic
    @Column(name = "PointId", nullable = true, length = 256)
    public String getPointId() {
        return pointId;
    }

    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

    @Basic
    @Column(name = "PointName", nullable = true, length = 64)
    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    @Basic
    @Column(name = "RealVal", nullable = true)
    public Integer getRealVal() {
        return realVal;
    }

    public void setRealVal(Integer realVal) {
        this.realVal = realVal;
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
    @Column(name = "IsDifferent", nullable = true)
    public Byte getIsDifferent() {
        return isDifferent;
    }

    public void setIsDifferent(Byte isDifferent) {
        this.isDifferent = isDifferent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbCheckDiffSelfAlarmEntity that = (TbCheckDiffSelfAlarmEntity) o;

        if (id != that.id) return false;
        if (deviceId != null ? !deviceId.equals(that.deviceId) : that.deviceId != null) return false;
        if (pointId != null ? !pointId.equals(that.pointId) : that.pointId != null) return false;
        if (pointName != null ? !pointName.equals(that.pointName) : that.pointName != null) return false;
        if (realVal != null ? !realVal.equals(that.realVal) : that.realVal != null) return false;
        if (checkTime != null ? !checkTime.equals(that.checkTime) : that.checkTime != null) return false;
        if (isDifferent != null ? !isDifferent.equals(that.isDifferent) : that.isDifferent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (deviceId != null ? deviceId.hashCode() : 0);
        result = 31 * result + (pointId != null ? pointId.hashCode() : 0);
        result = 31 * result + (pointName != null ? pointName.hashCode() : 0);
        result = 31 * result + (realVal != null ? realVal.hashCode() : 0);
        result = 31 * result + (checkTime != null ? checkTime.hashCode() : 0);
        result = 31 * result + (isDifferent != null ? isDifferent.hashCode() : 0);
        return result;
    }
}
