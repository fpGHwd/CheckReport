package dao;

import entity.TbCheckDiffClockEntity;

import java.util.List;

public interface DiffClockDao {

    void saveDiffClock(TbCheckDiffClockEntity tcdce);
    List<TbCheckDiffClockEntity> getClock(String deviceId);
}
