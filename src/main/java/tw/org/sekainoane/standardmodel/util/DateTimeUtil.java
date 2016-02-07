package tw.org.sekainoane.standardmodel.util;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;

import tw.org.sekainoane.standardmodel.grid.data.entity.OperationLogEntity;

public class DateTimeUtil {

	public static final Function<OperationLogEntity, String> byYear = o -> "" + o.getDate().getYear();// LocalDateTime.of(o.getDate().getYear(), 1, 1, 1, 1);
	
	public static final Function<OperationLogEntity, String> byHalfYear = o -> {
		int month = o.getDate().getMonthValue();
		if (month >= 1 && month < 7) {
//			return LocalDateTime.of(o.getDate().getYear(), 1, 1, 1, 1);
			return o.getDate().getYear() + "-1st Half";
		} else {
//			return LocalDateTime.of(o.getDate().getYear(), 7, 1, 1, 1);
			return o.getDate().getYear() + "-2nd Half";
		}
	};
	
	public static final Function<OperationLogEntity, String> bySeason = o -> {
		int month = o.getDate().getMonthValue();
		if (month >= 1 && month < 4) {
//			return LocalDateTime.of(o.getDate().getYear(), 1, 1, 1, 1);
			return o.getDate().getYear() + "-Q1";
		} else if (month >= 4 && month < 7) {
//			return LocalDateTime.of(o.getDate().getYear(), 4, 1, 1, 1);
			return o.getDate().getYear() + "-Q2";
		} else if (month >= 7 && month < 10) {
//			return LocalDateTime.of(o.getDate().getYear(), 7, 1, 1, 1);
			return o.getDate().getYear() + "-Q3";
		} else {
//			return LocalDateTime.of(o.getDate().getYear(), 10, 1, 1, 1);
			return o.getDate().getYear() + "-Q4";
		}
	};
	
	public static final Function<OperationLogEntity, String> byMonth = o -> "" + o.getDate().getYear() + " " + o.getDate().getMonth().getDisplayName(TextStyle.SHORT, Locale.US); // LocalDateTime.of(o.getDate().getYear(), o.getDate().getMonthValue(), 1, 1, 1);
	
	private static final WeekFields weekFields = WeekFields.ISO;
	public static final Function<OperationLogEntity, String> byWeek = o -> {
//		LocalDateTime dayOfYearWeek = o.getDate().with(weekFields.dayOfWeek(), 1);
//		return LocalDateTime.of(dayOfYearWeek.getYear(), dayOfYearWeek.getMonthValue(), dayOfYearWeek.getDayOfMonth(), 1, 1);
		return o.getDate().getYear() + "-" + o.getDate().get(weekFields.weekOfWeekBasedYear());
	};
	
	public static final Function<OperationLogEntity, String> byDate = o -> LocalDateTime.of(o.getDate().getYear(), o.getDate().getMonthValue(), o.getDate().getDayOfMonth(), 1, 1).format(DateTimeFormatter.ISO_DATE);

	public static final Function<OperationLogEntity, String> bySheet = o -> {
		List<LocalTime> sheet = Arrays.asList(LocalTime.of(5, 45), LocalTime.of(14, 45), LocalTime.of(23, 45));
		
		int sheetNo = sheet.indexOf(o.getDate().toLocalTime());
		if (sheetNo == 0) {
			return o.getDate().format(DateTimeFormatter.ISO_DATE) + "-1st Sheet";
		} else if (sheetNo == 1) {
			return o.getDate().format(DateTimeFormatter.ISO_DATE) + "-2nd Sheet";
		} else {
			return o.getDate().format(DateTimeFormatter.ISO_DATE) + "-3rd Sheet";
		}
	};
	
}
