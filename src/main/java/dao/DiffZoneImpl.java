/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-19
 * @Time: 上午10:10
 * @Project: CheckReport
 */

package dao;

import entity.TbCheckDiffZoneEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

public class DiffZoneImpl implements DiffZoneDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public void saveDiffZone(TbCheckDiffZoneEntity tcbze) {
        String sql = "INSERT INTO tb_check_diff_zone VALUES(NULL,?,?,?,?,?,?,?)";
        template.update(sql,tcbze.getDeviceId(),tcbze.getPointName(),
                tcbze.getValType(),tcbze.getRefVal(),tcbze.getRealVal(),
                tcbze.getCheckTime(),tcbze.getIsDifferent());
    }
}
