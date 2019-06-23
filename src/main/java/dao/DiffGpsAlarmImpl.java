/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-19
 * @Time: 下午2:27
 * @Project: CheckReport
 */

package dao;

import entity.TbCheckDiffGpsAlarmEntity;
import entity.TbCheckDiffSelfAlarmEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

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
}
