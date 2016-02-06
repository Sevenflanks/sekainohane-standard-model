package tw.org.sekainoane.standardmodel.util;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.function.Function;

import tw.org.sekainoane.standardmodel.grid.data.entity.OperationLogEntity;

public class DateTimeUtil {

	public static final Function<OperationLogEntity, LocalDateTime> byYear = o -> LocalDateTime.of(o.getDate().getYear(), 1, 1, 1, 1);
	
	public static final Function<OperationLogEntity, LocalDateTime> bySeason = o -> {
		int month = o.getDate().getMonthValue();
		if (month >= 1 && month < 4) {
			return LocalDateTime.of(o.getDate().getYear(), 1, 1, 1, 1);
		} else if (month >= 4 && month < 7) {
			return LocalDateTime.of(o.getDate().getYear(), 4, 1, 1, 1);
		} else if (month >= 7 && month < 10) {
			return LocalDateTime.of(o.getDate().getYear(), 7, 1, 1, 1);
		} else {
			return LocalDateTime.of(o.getDate().getYear(), 10, 1, 1, 1);
		}
	};
	public static final Function<OperationLogEntity, LocalDateTime> byMonth = o -> LocalDateTime.of(o.getDate().getYear(), o.getDate().getMonthValue(), 1, 1, 1);
	
	private static final WeekFields weekFields = WeekFields.ISO;
	public static final Function<OperationLogEntity, LocalDateTime> byWeek = o -> {
		LocalDateTime dayOfYearWeek = o.getDate().with(weekFields.dayOfWeek(), 1);
		return LocalDateTime.of(dayOfYearWeek.getYear(), dayOfYearWeek.getMonthValue(), dayOfYearWeek.getDayOfMonth(), 1, 1);
	};
	
	public static final Function<OperationLogEntity, LocalDateTime> byDate = o -> LocalDateTime.of(o.getDate().getYear(), o.getDate().getMonthValue(), o.getDate().getDayOfMonth(), 1, 1);
	
	public static final Function<OperationLogEntity, LocalDateTime> bySheet = o -> o.getDate();
	
}
