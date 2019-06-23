package dao;

import entity.TbCheckSummaryEntity;

import java.util.List;

public interface CheckSummaryDao {
    void saveCheckSummary(TbCheckSummaryEntity tcse);
    List<TbCheckSummaryEntity> getCheckSummary();
}
