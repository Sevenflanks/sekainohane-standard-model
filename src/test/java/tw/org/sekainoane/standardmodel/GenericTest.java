package tw.org.sekainoane.standardmodel;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tw.org.sekainoane.standardmodel.grid.config.GridServiceConfurigation;
import tw.org.sekainoane.standardmodel.travel.config.TravelDaoConfurigation;
import tw.org.sekainoane.standardmodel.travel.config.TravelServiceConfurigation;

/**
 * TEST若使用了Spring所管理的Bean
 * 則必須要繼承這支
 * @author RHYS
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {GridServiceConfurigation.class, TravelServiceConfurigation.class, TravelDaoConfurigation.class})
public class GenericTest {

}
