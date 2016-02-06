package tw.org.sekainoane.standardmodel.grid.data.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tw.org.sekainoane.standardmodel.grid.data.setting.Machine;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationLogEntity {
	
	private LocalDateTime date;
	
	private Machine machine;
	
	private int cnt;
	
}
