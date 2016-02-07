package tw.org.sekainoane.standardmodel.grid.data.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tw.org.sekainoane.standardmodel.grid.data.setting.Machine;

/**
 * 工作資料的最細單位
 * @param date 型別為{LocalDateTime}的原因是要把班表資訊塞入
 * @author RHYS
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationLogEntity {
	
	private LocalDateTime date;
	
	private Machine machine;
	
	private int cnt;
	
}
