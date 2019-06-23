/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-19
 * @Time: 上午10:26
 * @Project: CheckReport
 */

package dao;

import entity.TbCheckDiffSettingsEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

public class DiffSettingImpl implements DiffSettingDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public void saveDiffSetting(TbCheckDiffSettingsEntity tcbse) {
        String sql = "INSERT INTO tb_check_diff_settings VALUES(NULL,?,?,?,?,?,?,?,?,?)";
        template.update(sql,
                tcbse.getDeviceId(),
                tcbse.getPointId(),
                tcbse.getPointName(),
                tcbse.getValType(),
                tcbse.getRefVal(),
                tcbse.getRealVal(),
                tcbse.getZoneNo(),
                tcbse.getCheckTime(),
                tcbse.getIsDifferent()
        );

    }
}
