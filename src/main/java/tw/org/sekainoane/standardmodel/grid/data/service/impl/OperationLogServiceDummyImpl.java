package tw.org.sekainoane.standardmodel.grid.data.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import tw.org.sekainoane.standardmodel.grid.data.entity.OperationLogEntity;
import tw.org.sekainoane.standardmodel.grid.data.service.OperationLogService;
import tw.org.sekainoane.standardmodel.grid.data.setting.Machine;

/**
 * 組出用以測試的假資料
 * 
 * @author RHYS
 */
@Service
public class OperationLogServiceDummyImpl implements OperationLogService {
	

	/**
	 * 產生假資料
	 * @param rangeOfDate 日期長度(從2015-01-01開始算)
	 */
	private List<OperationLogEntity> generate(int rangeOfDate) {
		List<OperationLogEntity> result = Lists.newArrayList();
		
		// 班表, 每一班的起始時間
		List<LocalTime> shift = Arrays.asList(LocalTime.of(5, 45), LocalTime.of(14, 45), LocalTime.of(23, 45));
		// 將Machine表列
		Machine[] machines = Machine.values();
		// 起始時間
		LocalDate currentDate = LocalDate.parse("2015-01-01");
		
		// 每天, 每班, 每台機器定義最細粒度的資料
		for (int date = 0; date < rangeOfDate; date++) {
			for (int sheet = 0; sheet <= 2; sheet++) {
				for (int machine = 0; machine < machines.length; machine++) {
					result.add(new OperationLogEntity(LocalDateTime.of(currentDate, shift.get(sheet)), machines[machine], randomCnt()));
				}
			}
			currentDate = currentDate.plusDays(1);
		}
		
		return result;
	}
	
	// 隨機產生數量, 範圍為10000~100000
	private int randomCnt() {
		final double min = 10000;
		final double max = 100000;
		final double range = max - min;
		
		return (int)(Math.random() * range + min);
	}

	@Override
	public List<OperationLogEntity> getAll() {
		return generate(1000);
	}
	
}
