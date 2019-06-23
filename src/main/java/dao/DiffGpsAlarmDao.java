package dao;

import entity.TbCheckDiffGpsAlarmEntity;
import entity.TbCheckDiffSelfAlarmEntity;

public interface DiffGpsAlarmDao {
    void saveGpsAlarm(TbCheckDiffGpsAlarmEntity tcdgae);
}
