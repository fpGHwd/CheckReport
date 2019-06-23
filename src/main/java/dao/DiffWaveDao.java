package dao;

import entity.TbCheckDiffWaveEntity;

import java.util.List;

public interface DiffWaveDao {
    void saveWave(TbCheckDiffWaveEntity tcdwe);
    List<TbCheckDiffWaveEntity> getWave(String deviceId);
}
