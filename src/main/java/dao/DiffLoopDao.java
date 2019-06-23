package dao;

import entity.TbCheckDiffLoopEntity;

import java.util.List;

public interface DiffLoopDao {
    void saveLoop(TbCheckDiffLoopEntity tcdle);
    List<TbCheckDiffLoopEntity> getLoop(String deviceId);
}
