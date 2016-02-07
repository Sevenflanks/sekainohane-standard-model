package tw.org.sekainoane.standardmodel.grid.data.service;

import java.util.List;

import tw.org.sekainoane.standardmodel.grid.data.entity.OperationLogEntity;

/**
 * 取得工作資料
 * 
 * @author RHYS
 */
public interface OperationLogService {

	public List<OperationLogEntity> getAll();

}
