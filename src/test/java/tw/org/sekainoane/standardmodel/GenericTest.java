package tw.org.sekainoane.standardmodel;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tw.org.sekainoane.standardmodel.grid.config.GridConfurigation;

/**
 * TEST若使用了Spring所管理的Bean
 * 則必須要繼承這支
 * @author RHYS
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {GridConfurigation.class})
public class GenericTest {

}
