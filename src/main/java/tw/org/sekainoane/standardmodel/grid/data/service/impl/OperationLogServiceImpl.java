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

@Service
public class OperationLogServiceImpl implements OperationLogService {
	
	private List<OperationLogEntity> generate() {
		List<LocalTime> shift = Arrays.asList(LocalTime.of(5, 45), LocalTime.of(14, 45), LocalTime.of(23, 45));
		
		List<OperationLogEntity> result = Lists.newArrayList();
		Machine[] machines = Machine.values();
		LocalDate currentDate = LocalDate.parse("2015-01-01");
		
		for (int date = 0; date < 365; date++) {
			for (int sheet = 0; sheet <= 2; sheet++) {
				for (int machine = 0; machine < machines.length; machine++) {
					result.add(new OperationLogEntity(LocalDateTime.of(currentDate, shift.get(sheet)), machines[machine], randomCnt()));
				}
			}
			currentDate = currentDate.plusDays(1);
		}
		
		return result;
	}
	
	private int randomCnt() {
		final double min = 10000;
		final double max = 100000;
		final double range = max - min;
		
		return (int)(Math.random() * range + min);
	}

	public List<OperationLogEntity> getAll() {
		return generate();
	}
	
}
