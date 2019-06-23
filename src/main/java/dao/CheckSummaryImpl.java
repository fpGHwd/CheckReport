/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-19
 * @Time: 上午9:00
 * @Project: CheckReport
 */

package dao;

import entity.TbCheckSummaryEntity;
import entity.TbSystemEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class CheckSummaryImpl implements CheckSummaryDao {


    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public void saveCheckSummary(TbCheckSummaryEntity tcse) {
        String sql = "INSERT INTO tb_check_summary VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        template.update(sql,tcse.getDeviceId(),tcse.getDeviceName(),tcse.getIsChecked(),tcse.getUnCheckReason(),tcse.getResult()
                ,tcse.getZoneResult(),tcse.getZoneUncheckReason(),tcse.getZoneIsChecked()
                ,tcse.getSettingResult(),tcse.getSettingUncheckReason(),tcse.getSettingIsChecked()
                ,tcse.getSoftPlateResult(),tcse.getSoftPlateUncheckReason(),tcse.getSoftPlateIsChecked()
                ,tcse.getHardPlateResult(),tcse.getHardPlateUncheckReason(),tcse.getHardPlateIsChecked()
                ,tcse.getDiscreteResult(),tcse.getDiscreteUncheckReason(),tcse.getDiscreteIsChecked()
                ,tcse.getClockResult(),tcse.getClockUncheckReason(),tcse.getClockIsChecked()
                ,tcse.getCommStatusResult(),tcse.getCommStatusUncheckReason(),tcse.getCommStatusIsChecked()
                ,tcse.getSecCircuitResult(),tcse.getSecCircuitUncheckReason(),tcse.getSecCircuitIsChecked()
                ,tcse.getSoftVersionResult(),tcse.getSoftVersionUncheckReason(),tcse.getSoftVersionIsChecked()
                ,tcse.getSelfAlarmResult(),tcse.getSelfAlarmUncheckReason(),tcse.getSelfAlarmIsChecked()
                ,tcse.getGpsAlarmResult(),tcse.getGpsAlarmUncheckReason(),tcse.getGpsAlarmIsChecked()
                ,tcse.getWaveResult(),tcse.getWaveUncheckReason(),tcse.getWaveIsChecked()
                ,tcse.getAnalogResult(),tcse.getAnalogUncheckReason(),tcse.getAnalogIsChecked()
                ,tcse.getLoopResult(),tcse.getLoopUncheckReason(),tcse.getLoopIsChecked()
                ,tcse.getChannelResult(),tcse.getChannelUncheckReason(),tcse.getChannelIsChecked()
                ,tcse.getSwitchResult(),tcse.getSwitchUncheckReason(),tcse.getSwitchIsChecked()
        );
    }

    @Override
    public List<TbCheckSummaryEntity> getCheckSummary() {
        return null;
    }
}
