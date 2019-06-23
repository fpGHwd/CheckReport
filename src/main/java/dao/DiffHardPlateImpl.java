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
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

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

    @Override
    public List<TbCheckDiffHardPlateEntity> getDiffHardPlate(String deviceId) {
        String sql = "SELECT * FROM tb_check_diff_hard_plate WHERE DeviceId = ?";
        List<TbCheckDiffHardPlateEntity> result = template.query(sql, new BeanPropertyRowMapper<TbCheckDiffHardPlateEntity>(TbCheckDiffHardPlateEntity.class), deviceId);
        return result;
    }
}
