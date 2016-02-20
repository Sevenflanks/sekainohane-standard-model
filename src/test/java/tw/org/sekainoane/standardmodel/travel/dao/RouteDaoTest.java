package tw.org.sekainoane.standardmodel.travel.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import tw.org.sekainoane.standardmodel.GenericTest;

public class RouteDaoTest extends GenericTest {
	
	@Autowired
	private RouteDao dao;

	@Test
	public void test() {
		dao.findAll();
	}

}
