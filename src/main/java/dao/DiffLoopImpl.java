/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-19
 * @Time: 下午3:06
 * @Project: CheckReport
 */

package dao;

import entity.TbCheckDiffLoopEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class DiffLoopImpl implements DiffLoopDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public void saveLoop(TbCheckDiffLoopEntity tcdle) {
        String sql = "INSERT INTO tb_check_diff_loop VALUES(NULL,?,?,?,?,?,?,?,?,?)";
        template.update(sql,
                tcdle.getDeviceId(),
                tcdle.getPointId(),
                tcdle.getPointName(),
                tcdle.getValType(),
                tcdle.getRealVal(),
                tcdle.getLowerLimit(),
                tcdle.getUpperLimit(),
                tcdle.getCheckTime(),
                tcdle.getIsDifferent());
    }

    @Override
    public List<TbCheckDiffLoopEntity> getLoop(String deviceId) {
        String sql = "SELECT * FROM tb_check_diff_loop WHERE DeviceId = ?";
        List<TbCheckDiffLoopEntity> result = template.query(sql, new BeanPropertyRowMapper<TbCheckDiffLoopEntity>(TbCheckDiffLoopEntity.class), deviceId);
        return result;
    }

}
