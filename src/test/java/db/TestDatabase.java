/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-18
 * @Time: 下午3:15
 * @Project: CheckReport
 */

package db;

import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDatabase {
    public static void main(String[] args) throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        System.out.println(conn);
        JDBCUtils.close(null, conn);
    }
}

// https://blog.csdn.net/oldinaction/article/details/50489056
