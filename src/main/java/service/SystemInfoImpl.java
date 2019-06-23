/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-18
 * @Time: 下午6:41
 * @Project: CheckReport
 */

package service;

import dao.SystemInfoDao;
import dao.SystemInfoDaoImpl;
import entity.TbSystemEntity;

public class SystemInfoImpl implements SystemInfoService {

    private static SystemInfoDao sid = new SystemInfoDaoImpl();

    public void saveSystemInfoService(TbSystemEntity tse) {
        sid.saveSystemInfo(tse);
    }
}
