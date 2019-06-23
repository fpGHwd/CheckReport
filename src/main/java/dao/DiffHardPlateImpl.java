/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-19
 * @Time: 上午11:23
 * @Project: CheckReport
 */

package dao;

import entity.TbCheckDiffHardPlateEntity;
import entity.TbCheckDiffSoftPlateEntity;
import entity.TbCheckDiffZoneEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

public class DiffHardPlateImpl implements DiffHardPlateDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public void saveDiffHardPlate(TbCheckDiffHardPlateEntity tcdhp) {
        String sql = "INSERT INTO tb_check_diff_hard_plate VALUES(NULL,?,?,?,?,?,?,?,?)";
        template.update(sql,
                tcdhp.getDeviceId(),
                tcdhp.getPointId(),
                tcdhp.getPointName(),
                tcdhp.getValType(),
                tcdhp.getRefVal(),
                tcdhp.getRealVal(),
                tcdhp.getCheckTime(),
                tcdhp.getIsDifferent()
                );
    }
}
