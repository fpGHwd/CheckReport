/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-19
 * @Time: 上午11:23
 * @Project: CheckReport
 */

package dao;

import entity.TbCheckDiffSoftPlateEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

public class DiffSoftPlateImpl implements DiffSoftPlateDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public void saveDiffSoftPlate(TbCheckDiffSoftPlateEntity tcdsp) {
        String sql = "INSERT INTO tb_check_diff_soft_plate VALUES(NULL,?,?,?,?,?,?,?,?)";
        template.update(sql,
                tcdsp.getDeviceId(),
                tcdsp.getPointId(),
                tcdsp.getPointName(),
                tcdsp.getValType(),
                tcdsp.getRefVal(),
                tcdsp.getRealVal(),
                tcdsp.getCheckTime(),
                tcdsp.getIsDifferent()
                );
    }
}
