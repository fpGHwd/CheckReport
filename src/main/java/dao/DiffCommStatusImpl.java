/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-19
 * @Time: 下午2:01
 * @Project: CheckReport
 */

package dao;

import entity.TbCheckDiffClockEntity;
import entity.TbCheckDiffCommStatusEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class DiffCommStatusImpl implements DiffCommStatusDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public void saveDiffCommStatus(TbCheckDiffCommStatusEntity tcdcde) {

        String sql = "INSERT INTO tb_check_diff_comm_status VALUES(NULL, ?,?,?,?,?)";
        template.update(sql,
                tcdcde.getDeviceId(),
                tcdcde.getPointName(),
                tcdcde.getRealVal(),
                tcdcde.getCheckTime(),
                tcdcde.getIsDifferent());

    }

    @Override
    public List<TbCheckDiffCommStatusEntity> getCommStatus(String deviceId) {
        String sql = "SELECT * FROM tb_check_diff_comm_status WHERE DeviceId = ?";
        List<TbCheckDiffCommStatusEntity> result = template.query(sql, new BeanPropertyRowMapper<TbCheckDiffCommStatusEntity>(TbCheckDiffCommStatusEntity.class), deviceId);
        return result;
    }
}
