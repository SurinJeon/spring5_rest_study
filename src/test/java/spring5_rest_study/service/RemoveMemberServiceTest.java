package spring5_rest_study.service;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import spring5_rest_study.config.ContextRoot;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ContextRoot.class)
@WebAppConfiguration
public class RemoveMemberServiceTest {
	private static final Log log = LogFactory.getLog(RemoveMemberServiceTest.class);

	@Autowired
	private RemoveMemberService service;
	
	@Autowired
	private MemberListService listService;
	
	@Test
	public void testRemoveMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		int res = service.removeMember(6L);
		Assert.assertEquals(1, res);
	
		listService.getLists().stream().forEach(m -> log.debug(m.toString()));
	}

}
