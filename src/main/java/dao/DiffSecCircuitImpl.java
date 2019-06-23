/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-19
 * @Time: 下午2:07
 * @Project: CheckReport
 */

package dao;

import entity.TbCheckDiffCommStatusEntity;
import entity.TbCheckDiffSecCircuitEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

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
}
