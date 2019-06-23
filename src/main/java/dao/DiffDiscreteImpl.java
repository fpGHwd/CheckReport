/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-19
 * @Time: 上午11:50
 * @Project: CheckReport
 */

package dao;

import entity.TbCheckDiffCommStatusEntity;
import entity.TbCheckDiffDiscreteEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class DiffDiscreteImpl implements DiffDiscreteDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public void saveDiffDiscrete(TbCheckDiffDiscreteEntity tcdde) {
        String sql = "INSERT INTO tb_check_diff_discrete VALUES(NULL,?,?,?,?,?,?,?,?)";

        template.update(sql,
                tcdde.getDeviceId(),
                tcdde.getPointId(),
                tcdde.getPointName(),
                tcdde.getValType(),
                tcdde.getRefVal(),
                tcdde.getRealVal(),
                tcdde.getCheckTime(),
                tcdde.getIsDifferent());
    }

    @Override
    public List<TbCheckDiffDiscreteEntity> getDiffDiscrete(String deviceId) {
        String sql = "SELECT * FROM tb_check_diff_discrete WHERE DeviceId = ?";
        List<TbCheckDiffDiscreteEntity> result = template.query(sql, new BeanPropertyRowMapper<TbCheckDiffDiscreteEntity>(TbCheckDiffDiscreteEntity.class), deviceId);
        return result;
    }
}
