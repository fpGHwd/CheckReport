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
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

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

    @Override
    public List<TbCheckDiffSoftPlateEntity> getSoftPlate(String deviceId) {
        String sql = "SELECT * FROM tb_check_diff_soft_plate WHERE DeviceId = ?";
        List<TbCheckDiffSoftPlateEntity> result = template.query(sql, new BeanPropertyRowMapper<TbCheckDiffSoftPlateEntity>(TbCheckDiffSoftPlateEntity.class), deviceId);
        return result;
    }
}
