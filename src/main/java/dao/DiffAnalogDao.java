package dao;

import entity.TbCheckDiffAnalogEntity;

import java.util.List;

public interface DiffAnalogDao {
    void saveAnalog(TbCheckDiffAnalogEntity tcdae);
    List<TbCheckDiffAnalogEntity> getAnalog(String deviceId);
}
