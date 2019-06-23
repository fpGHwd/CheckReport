/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-19
 * @Time: 下午2:01
 * @Project: CheckReport
 */

package dao;

import entity.TbCheckDiffCommStatusEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

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
}
