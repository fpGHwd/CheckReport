package dao;

import entity.TbCheckDiffSelfAlarmEntity;

import java.util.List;

public interface DiffSelfAlarmDao {
    void saveSelfAlarm(TbCheckDiffSelfAlarmEntity tcdsae);
    List<TbCheckDiffSelfAlarmEntity> getSelfAlarm(String deviceId);
}
