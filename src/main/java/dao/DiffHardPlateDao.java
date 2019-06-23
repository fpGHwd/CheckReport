package dao;

import entity.TbCheckDiffHardPlateEntity;
import entity.TbCheckDiffSoftPlateEntity;

import java.util.List;

public interface DiffHardPlateDao {
    void saveDiffHardPlate(TbCheckDiffHardPlateEntity tcdhp);
    List<TbCheckDiffHardPlateEntity> getDiffHardPlate(String deviceId);
}
