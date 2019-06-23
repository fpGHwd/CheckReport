/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-19
 * @Time: 下午2:27
 * @Project: CheckReport
 */

package dao;

import entity.TbCheckDiffSelfAlarmEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class DiffSelfAlarmImpl implements DiffSelfAlarmDao {


    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    public void saveSelfAlarm(TbCheckDiffSelfAlarmEntity tcdsae) {

        String sql = "INSERT INTO tb_check_diff_self_alarm VALUES(NULL,?,?,?,?,?,?)";
        template.update(sql,
                tcdsae.getDeviceId(),
                tcdsae.getPointId(),
                tcdsae.getPointName(),
                tcdsae.getRealVal(),
                tcdsae.getCheckTime(),
                tcdsae.getIsDifferent()
        );
    }

    @Override
    public List<TbCheckDiffSelfAlarmEntity> getSelfAlarm(String deviceId) {
        String sql = "SELECT * FROM tb_check_diff_self_alarm WHERE DeviceId = ?";
        List<TbCheckDiffSelfAlarmEntity> result = template.query(sql, new BeanPropertyRowMapper<TbCheckDiffSelfAlarmEntity>(TbCheckDiffSelfAlarmEntity.class), deviceId);
        return result;
    }
}
