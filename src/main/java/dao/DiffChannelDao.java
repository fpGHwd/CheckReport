package dao;

import entity.TbCheckDiffChannelEntity;

import java.util.List;

public interface DiffChannelDao {
    void saveChannel(TbCheckDiffChannelEntity tcdce);
    List<TbCheckDiffChannelEntity> getChannel(String deviceId);
}
