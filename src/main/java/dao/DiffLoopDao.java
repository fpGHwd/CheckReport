package dao;

import entity.TbCheckDiffAnalogEntity;
import entity.TbCheckDiffLoopEntity;

public interface DiffLoopDao {
    void saveLoop(TbCheckDiffLoopEntity tcdle);
}
