/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-19
 * @Time: 下午3:15
 * @Project: CheckReport
 */

package dao;

import entity.TbCheckDiffAnalogEntity;
import entity.TbCheckDiffChannelEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class DiffChannelImpl implements DiffChannelDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public void saveChannel(TbCheckDiffChannelEntity tcdce) {
        String sql = "INSERT INTO tb_check_diff_channel VALUES(NULL,?,?,?,?,?,?)";
        template.update(sql,
                tcdce.getDeviceId(),
                tcdce.getPointId(),
                tcdce.getPointName(),
                tcdce.getRealVal(),
                tcdce.getCheckTime(),
                tcdce.getIsDifferent());
    }

    @Override
    public List<TbCheckDiffChannelEntity> getChannel(String deviceId) {
        String sql = "SELECT * FROM tb_check_diff_channel WHERE DeviceId = ?";
        List<TbCheckDiffChannelEntity> result = template.query(sql, new BeanPropertyRowMapper<TbCheckDiffChannelEntity>(TbCheckDiffChannelEntity.class), deviceId);
        return result;
    }
}
