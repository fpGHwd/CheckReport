package dao;

import entity.TbCheckDiffSecCircuitEntity;

import java.util.List;

public interface DiffSecCircuitDao {
    void saveDiffSecCircuit(TbCheckDiffSecCircuitEntity tcdsce);
    List<TbCheckDiffSecCircuitEntity> getSecCircuit(String deviceId);
}
