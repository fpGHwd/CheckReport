/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-19
 * @Time: 下午2:13
 * @Project: CheckReport
 */

package dao;

import entity.TbCheckDiffSoftPlateEntity;
import entity.TbCheckDiffSoftVersionEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

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
}
