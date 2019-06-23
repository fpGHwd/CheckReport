package dao;

import entity.TbCheckDiffSoftPlateEntity;

import java.util.List;

public interface DiffSoftPlateDao {
    void saveDiffSoftPlate(TbCheckDiffSoftPlateEntity tcdsp);
    List<TbCheckDiffSoftPlateEntity> getDiffSoftPlate(String deviceId);
}
