/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-18
 * @Time: 下午6:48
 * @Project: CheckReport
 */

package dao;

import entity.TbSystemEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

public class SystemInfoDaoImpl implements SystemInfoDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    public void saveSystemInfo(TbSystemEntity tse) {
        String sql = "INSERT INTO tb_system VALUES(NULL,?,?,?,?,?,?)";
        template.update(sql,tse.getSubstation(),tse.getCheckTime(),tse.getCheckReason(),tse.getDeviceSum(),tse.getCheckDeviceSum(),tse.getAbnormalDeviceSum());
    }
}
