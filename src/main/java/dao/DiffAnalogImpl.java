/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-19
 * @Time: 下午2:53
 * @Project: CheckReport
 */

package dao;

import entity.TbCheckDiffAnalogEntity;
import entity.TbCheckSummaryEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

public class DiffAnalogImpl implements DiffAnalogDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public void saveAnalog(TbCheckDiffAnalogEntity tcdae) {
        String sql = "INSERT INTO tb_check_diff_analog VALUES(NULL,?,?,?,?,?,?,?,?,?)";
        template.update(sql,
                tcdae.getDeviceId(),
                tcdae.getPointId(),
                tcdae.getPointName(),
                tcdae.getValType(),
                tcdae.getRealVal(),
                tcdae.getLowerLimit(),
                tcdae.getUpperLimit(),
                tcdae.getCheckTime(),
                tcdae.getIsDifferent());

    }
}
