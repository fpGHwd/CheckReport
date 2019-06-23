package dao;

import entity.TbCheckDiffGpsAlarmEntity;
import entity.TbCheckDiffWaveEntity;

public interface DiffWaveDao {
    void saveWave(TbCheckDiffWaveEntity tcdwe);
}
