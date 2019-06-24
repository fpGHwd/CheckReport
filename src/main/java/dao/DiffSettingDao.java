package dao;

import entity.TbCheckDiffSettingsEntity;

import java.util.List;

public interface DiffSettingDao {
    void saveDiffSetting(TbCheckDiffSettingsEntity tcdse);
    List<TbCheckDiffSettingsEntity> getSetting(String deviceId);
}
