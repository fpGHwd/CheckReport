package dao;

import entity.TbCheckDiffZoneEntity;

import java.util.List;

public interface DiffZoneDao {
    void saveDiffZone(TbCheckDiffZoneEntity tcbze);
    List<TbCheckDiffZoneEntity> getZone(String deviceId);
}
