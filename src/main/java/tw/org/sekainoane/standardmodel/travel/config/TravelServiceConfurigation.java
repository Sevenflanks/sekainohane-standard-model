package tw.org.sekainoane.standardmodel.travel.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * Spring的基本Config
 * 掃過service package下的所有@Service
 * @author RHYS
 */
@Configuration
@Lazy
@ComponentScan(basePackages = {"tw.org.sekainoane.standardmodel.travel.**.service"}, useDefaultFilters = false, includeFilters = {@ComponentScan.Filter(value = Service.class, type = FilterType.ANNOTATION)})
public class TravelServiceConfurigation {

}
