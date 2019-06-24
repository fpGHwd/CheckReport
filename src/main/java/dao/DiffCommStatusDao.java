package dao;

import entity.TbCheckDiffCommStatusEntity;

import java.util.List;

public interface DiffCommStatusDao {
    void saveDiffCommStatus(TbCheckDiffCommStatusEntity tcdcde);
    List<TbCheckDiffCommStatusEntity> getCommStatus(String deviceId);
}
