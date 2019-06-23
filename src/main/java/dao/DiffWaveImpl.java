/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-19
 * @Time: 下午2:42
 * @Project: CheckReport
 */

package dao;

import entity.TbCheckDiffWaveEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class DiffWaveImpl implements DiffWaveDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    public void saveWave(TbCheckDiffWaveEntity tcdwe) {
        String sql = "INSERT INTO tb_check_diff_wave VALUES(NULL,?,?,?,?)";
        template.update(sql,
                tcdwe.getDeviceId(),
                tcdwe.getRealVal(),
                tcdwe.getCheckTime(),
                tcdwe.getIsDifferent()
        );
    }

    @Override
    public List<TbCheckDiffWaveEntity> getWave(String deviceId) {
        String sql = "SELECT * FROM tb_check_diff_wave WHERE DeviceId = ?";
        List<TbCheckDiffWaveEntity> result = template.query(sql, new BeanPropertyRowMapper<TbCheckDiffWaveEntity>(TbCheckDiffWaveEntity.class), deviceId);
        return result;
    }
}
