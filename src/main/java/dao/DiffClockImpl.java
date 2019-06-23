/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-19
 * @Time: 下午1:49
 * @Project: CheckReport
 */

package dao;

import entity.TbCheckDiffClockEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

public class DiffClockImpl implements DiffClockDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    public void saveDiffClock(TbCheckDiffClockEntity tcdce) {
        String sql = "INSERT INTO tb_check_diff_clock VALUES(NULL, ?,?,?,?,?,?,?)";
        template.update(sql,
                tcdce.getDeviceId(),
                tcdce.getPointName(),
                tcdce.getValType(),
                tcdce.getRefVal(),
                tcdce.getRealVal(),
                tcdce.getCheckTime(),
                tcdce.getIsDifferent());
    }
}
