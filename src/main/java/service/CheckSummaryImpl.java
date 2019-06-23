/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-19
 * @Time: 上午8:34
 * @Project: CheckReport
 */

package service;

import dao.CheckSummaryDao;
import entity.TbCheckSummaryEntity;

public class CheckSummaryImpl implements CheckSummaryService {

    private static CheckSummaryDao csd = new dao.CheckSummaryImpl();

    public void saveCheckSummary(TbCheckSummaryEntity tcse) {
        csd.saveCheckSummary(tcse);
    }
}
