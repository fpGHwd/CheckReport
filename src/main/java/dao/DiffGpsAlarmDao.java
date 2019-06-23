package dao;

import entity.TbCheckDiffGpsAlarmEntity;
import entity.TbCheckDiffSelfAlarmEntity;

import java.util.List;

public interface DiffGpsAlarmDao {
    void saveGpsAlarm(TbCheckDiffGpsAlarmEntity tcdgae);
    List<TbCheckDiffGpsAlarmEntity> getGpsAlarm(String deviceId);
}
