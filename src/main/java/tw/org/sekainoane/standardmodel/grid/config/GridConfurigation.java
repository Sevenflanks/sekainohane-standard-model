package tw.org.sekainoane.standardmodel.grid.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Configuration
@Lazy
@ComponentScan(basePackages = {"tw.org.sekainoane.standardmodel.grid.**.service"}, useDefaultFilters = false, includeFilters = {@ComponentScan.Filter(value = Service.class, type = FilterType.ANNOTATION)})
public class GridConfurigation {

}
