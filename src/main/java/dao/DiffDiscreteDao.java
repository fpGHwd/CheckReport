package dao;

import entity.TbCheckDiffDiscreteEntity;
import entity.TbCheckDiffSettingsEntity;

import java.util.List;

public interface DiffDiscreteDao {
    void saveDiffDiscrete(TbCheckDiffDiscreteEntity tcdse);
    List<TbCheckDiffDiscreteEntity> getDiscrete(String deviceId);
}
