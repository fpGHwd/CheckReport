/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-18
 * @Time: 下午6:48
 * @Project: CheckReport
 */

package dao;

import entity.TbCheckSummaryEntity;
import entity.TbSystemEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class SystemInfoDaoImpl implements SystemInfoDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    public void saveSystemInfo(TbSystemEntity tse) {
        String sql = "INSERT INTO tb_system VALUES(NULL,?,?,?,?,?,?)";
        template.update(sql,tse.getSubstation(),tse.getCheckTime(),tse.getCheckReason(),tse.getDeviceSum(),tse.getCheckDeviceSum(),tse.getAbnormalDeviceSum());
    }

    @Override
    public TbSystemEntity getSystemInfo() {
        String sql = "SELECT * FROM tb_system";
        TbSystemEntity result = template.queryForObject(sql, new BeanPropertyRowMapper<TbSystemEntity>(TbSystemEntity.class));
        return result;
    }
}
