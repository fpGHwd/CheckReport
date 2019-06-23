/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-19
 * @Time: 下午3:06
 * @Project: CheckReport
 */

package dao;

import entity.TbCheckDiffAnalogEntity;
import entity.TbCheckDiffLoopEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

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

}
