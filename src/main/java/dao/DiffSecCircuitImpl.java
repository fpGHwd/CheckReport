/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-19
 * @Time: 下午2:07
 * @Project: CheckReport
 */

package dao;

import entity.TbCheckDiffSecCircuitEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class DiffSecCircuitImpl implements DiffSecCircuitDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public void saveDiffSecCircuit(TbCheckDiffSecCircuitEntity tcdsce) {
        String sql = "INSERT INTO tb_check_diff_sec_circuit VALUES(NULL, ?,?,?,?,?,?)";
        template.update(sql,
                tcdsce.getDeviceId(),
                tcdsce.getPointId(),
                tcdsce.getPointName(),
                tcdsce.getRealVal(),
                tcdsce.getCheckTime(),
                tcdsce.getIsDifferent());
    }

    @Override
    public List<TbCheckDiffSecCircuitEntity> getSecCircuit(String deviceId) {
        String sql = "SELECT * FROM tb_check_diff_sec_circuit WHERE DeviceId = ?";
        List<TbCheckDiffSecCircuitEntity> result = template.query(sql, new BeanPropertyRowMapper<TbCheckDiffSecCircuitEntity>(TbCheckDiffSecCircuitEntity.class), deviceId);
        return result;
    }
}
