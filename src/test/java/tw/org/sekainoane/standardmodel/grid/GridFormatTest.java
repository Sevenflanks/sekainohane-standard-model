package tw.org.sekainoane.standardmodel.grid;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import tw.org.sekainoane.standardmodel.GenericTest;
import tw.org.sekainoane.standardmodel.grid.data.entity.OperationLogEntity;
import tw.org.sekainoane.standardmodel.grid.data.service.OperationLogService;
import tw.org.sekainoane.standardmodel.util.DateTimeUtil;

public class GridFormatTest extends GenericTest {

	@Autowired
	private OperationLogService operationLogService;
	
	private final Function<OperationLogEntity, Object> byMachine = o -> o.getMachine();
	private final Function<OperationLogEntity, Object> bySubDept = o -> o.getMachine().getSubDept();
	private final Function<OperationLogEntity, Object> byDept = o -> o.getMachine().getSubDept().getDept();
	
	private final Comparator<Entry<String, Map<Object,Optional<OperationLogEntity>>>> byKeyLength = Comparator.comparing(e -> e.getKey().length());
	private final Comparator<Entry<String, Map<Object,Optional<OperationLogEntity>>>> byKey = Comparator.comparing(e -> e.getKey());
	
	@Test
	public void test() {
		showGridInConsole(DateTimeUtil.byHalfYear, byDept);
	}

	private void showGridInConsole(final Function<OperationLogEntity, String> verticalGrouping,
			final Function<OperationLogEntity, Object> horizonGrouping) {
		List<OperationLogEntity> sources = operationLogService.getAll();
		
		Map<String, Map<Object, Optional<OperationLogEntity>>> result = sources.stream()
			.collect(Collectors.groupingBy(verticalGrouping, Collectors.groupingBy(horizonGrouping, Collectors.reducing((o1,o2) -> {
				o1.setCnt(o1.getCnt() + o2.getCnt());
				return o1;
			}))));
		
		
		Comparator.comparing(o -> o.toString().length()).thenComparing(o -> o.toString());
		result.entrySet().stream().sorted(byKeyLength.thenComparing(byKey))
			.forEach(e -> {
				StringBuilder sb = new StringBuilder();
				sb.append(e.getKey()).append("\t");
				
				e.getValue().forEach((group, log) -> {
					sb.append("[").append(group).append("]").append(":").append(log.map(o -> o.getCnt()).orElse(0)).append("\t");
				});
				
				System.out.println(sb.toString());
			});
	}
	
}
