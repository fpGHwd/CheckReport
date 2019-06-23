/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-19
 * @Time: 下午2:52
 * @Project: CheckReport
 */

package entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "tb_check_diff_analog", schema = "report", catalog = "")
public class TbCheckDiffAnalogEntity {
    private int id;
    private String deviceId;
    private String pointId;
    private String pointName;
    private String valType;
    private Double realVal;
    private Double lowerLimit;
    private Double upperLimit;
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
    @Column(name = "ValType", nullable = true, length = 64)
    public String getValType() {
        return valType;
    }

    public void setValType(String valType) {
        this.valType = valType;
    }

    @Basic
    @Column(name = "RealVal", nullable = true, precision = 0)
    public Double getRealVal() {
        return realVal;
    }

    public void setRealVal(Double realVal) {
        this.realVal = realVal;
    }

    @Basic
    @Column(name = "LowerLimit", nullable = true, precision = 0)
    public Double getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(Double lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    @Basic
    @Column(name = "UpperLimit", nullable = true, precision = 0)
    public Double getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(Double upperLimit) {
        this.upperLimit = upperLimit;
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

        TbCheckDiffAnalogEntity that = (TbCheckDiffAnalogEntity) o;

        if (id != that.id) return false;
        if (pointId != null ? !pointId.equals(that.pointId) : that.pointId != null) return false;
        if (pointName != null ? !pointName.equals(that.pointName) : that.pointName != null) return false;
        if (valType != null ? !valType.equals(that.valType) : that.valType != null) return false;
        if (realVal != null ? !realVal.equals(that.realVal) : that.realVal != null) return false;
        if (lowerLimit != null ? !lowerLimit.equals(that.lowerLimit) : that.lowerLimit != null) return false;
        if (upperLimit != null ? !upperLimit.equals(that.upperLimit) : that.upperLimit != null) return false;
        if (checkTime != null ? !checkTime.equals(that.checkTime) : that.checkTime != null) return false;
        if (isDifferent != null ? !isDifferent.equals(that.isDifferent) : that.isDifferent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (pointId != null ? pointId.hashCode() : 0);
        result = 31 * result + (pointName != null ? pointName.hashCode() : 0);
        result = 31 * result + (valType != null ? valType.hashCode() : 0);
        result = 31 * result + (realVal != null ? realVal.hashCode() : 0);
        result = 31 * result + (lowerLimit != null ? lowerLimit.hashCode() : 0);
        result = 31 * result + (upperLimit != null ? upperLimit.hashCode() : 0);
        result = 31 * result + (checkTime != null ? checkTime.hashCode() : 0);
        result = 31 * result + (isDifferent != null ? isDifferent.hashCode() : 0);
        return result;
    }
}
