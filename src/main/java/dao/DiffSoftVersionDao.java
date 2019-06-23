package dao;

import entity.TbCheckDiffSoftVersionEntity;

import java.util.List;

public interface DiffSoftVersionDao {
    void saveDiffSoftVersion(TbCheckDiffSoftVersionEntity tcdsve);
    List<TbCheckDiffSoftVersionEntity> getDiffSoftVersion(String deviceId);
}
