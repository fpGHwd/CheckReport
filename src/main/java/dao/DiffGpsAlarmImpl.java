/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-19
 * @Time: 下午2:27
 * @Project: CheckReport
 */

package dao;

import entity.TbCheckDiffDiscreteEntity;
import entity.TbCheckDiffGpsAlarmEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class DiffGpsAlarmImpl implements DiffGpsAlarmDao {


    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public void saveGpsAlarm(TbCheckDiffGpsAlarmEntity tcdgae) {
        String sql = "INSERT INTO tb_check_diff_gps_alarm VALUES(NULL,?,?,?,?,?,?)";
        template.update(sql,
                tcdgae.getDeviceId(),
                tcdgae.getPointId(),
                tcdgae.getPointName(),
                tcdgae.getRealVal(),
                tcdgae.getCheckTime(),
                tcdgae.getIsDifferent()
        );
    }

    @Override
    public List<TbCheckDiffGpsAlarmEntity> getGpsAlarm(String deviceId) {
        String sql = "SELECT * FROM tb_check_diff_gps_alarm WHERE DeviceId = ?";
        List<TbCheckDiffGpsAlarmEntity> result = template.query(sql, new BeanPropertyRowMapper<TbCheckDiffGpsAlarmEntity>(TbCheckDiffGpsAlarmEntity.class), deviceId);
        return result;
    }
}
