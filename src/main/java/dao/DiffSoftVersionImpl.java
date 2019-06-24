/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-19
 * @Time: 下午2:13
 * @Project: CheckReport
 */

package dao;

import entity.TbCheckDiffSoftVersionEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class DiffSoftVersionImpl implements DiffSoftVersionDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    public void saveDiffSoftVersion(TbCheckDiffSoftVersionEntity tcdsve) {
        String sql = "INSERT INTO tb_check_diff_soft_version VALUES(NULL,?,?,?,?,?,?,?)";
        template.update(sql,
                tcdsve.getDeviceId(),
                tcdsve.getPointId(),
                tcdsve.getPointName(),
                tcdsve.getRefVal(),
                tcdsve.getRealVal(),
                tcdsve.getCheckTime(),
                tcdsve.getIsDifferent()
        );
    }

    @Override
    public List<TbCheckDiffSoftVersionEntity> getSoftVersion(String deviceId) {
        String sql = "SELECT * FROM tb_check_diff_soft_version WHERE DeviceId = ?";
        List<TbCheckDiffSoftVersionEntity> result = template.query(sql, new BeanPropertyRowMapper<TbCheckDiffSoftVersionEntity>(TbCheckDiffSoftVersionEntity.class), deviceId);
        return result;
    }
}
